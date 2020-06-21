# 基于 MySQL + springcloud 微服务框架的作业管理系统

## 概述

项目分为注册中心，网关代理，作业服务，学生作业服务，学生服务，教师服务，UI 文件夹为项目web前端界面，共七个模块

主要功能包括

*   师生的注册登录
*   教师查看作业，发布作业，修改作业，添加学生信息，修改学生信息
*   学生查看作业，提交作业

## eureka-server 服务注册中心

在微服务架构中往往会有一个注册中心，每个微服务都会向注册中心去注册自己的地址及端口信息，注册中心维护着服务名称与服务实例的对应关系。每个微服务都会定时从注册中心获取服务列表，同时汇报自己的运行情况，这样当有的服务需要调用其他服务时，就可以从自己获取到的服务列表中获取实例地址进行调用，Eureka实现了这套服务注册与发现机制。

简单的服务注册中心的搭建主要分为以下三步：添加依赖和注解，修改配置文件	

首先使用 spring initializr 新建一个 module，添加依赖选择 Eureka Server，如下图

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/服务注册中心添加依赖.png)

启动类上添加注解 @EnableEurekaServer，来启动 eureka 注册中心功能

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
```

配置文件 applicatiion.properties 添加 eureka 注册中心的配置

```properties
# 服务名称
spring.application.name=eureka-server
# 应用服务web访问端口
server.port=8000
# 服务注册中心示例主机名
eureka.instance.hostname=localhost
# 是否向服务注册中心注册自己 默认为true
eureka.client.register-with-eureka=false
# 是否检索服务
eureka.client.fetch-registry=false
# 续期时间，即扫描失效服务的间隔时间（缺省为60*1000ms）
#eureka.server.eviction-interval-timer-in-ms=1000
# 服务注册中心的配置内容，指定服务注册中心的位置
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
```

运行服务，查看 localhost:8000，响应界面如下，即为服务注册中心配置完成

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/服务注册中心页面.png)

## 搭建 Eureka 客户端

搭建过程与服务注册中心类似，添加依赖和注解，修改配置文件，以本项目中 homework-service 的搭建过程为例

核心依赖为 Eureka Discovery Client 和 Spring Web，lombok、JPA、MySQL Driver 是基于本项目所需的依赖

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/Eureka客户端添加依赖.png)

启动类添加注解，添加 @EnableDiscoveryClient 注解表明是一个 Eureka  客户端

```java
@EnableEurekaClient
@SpringBootApplication
public class HomeworkServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkServiceApplication.class, args);
    }

}
```

修改配置文件如下

```properties
# 服务名称
spring.application.name=homework-service
# 应用服务web访问端口
server.port=8081

# 注册中心地址
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/

# 数据库基本配置
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/school?useSSL=FALSE&serverTimezone=UTC&characterEncoding=utf8
spring.datasource.username=root
spring.datasource.password=990818
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# 显示 SQL 语句
spring.jpa.show-sql=true
```

此项目的服务客户端均基于 MVC 架构，具体代码可参考文末git地址

启动服务后，可以在服务注册中心看到注册成功

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/homework-service服务启动.png)

postman 验证接口功能，因为设置了 Zuul 网关代理，所以只需向暴露的网关端口发送请求即可

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/postman验证homework-service接口.png)

其他服务搭建过程与此类似

## 网关代理

Spring Cloud Zuul 是Spring Cloud Netflix 子项目的核心组件之一，可以作为微服务架构中的API网关使用，支持动态路由与过滤功能。API网关为微服务架构中的服务提供了统一的访问入口，客户端通过API网关访问相关服务。API网关的定义类似于设计模式中的门面模式，它相当于整个微服务架构中的门面，所有客户端的访问都通过它来进行路由及过滤。它实现了请求路由、负载均衡、校验过滤、服务容错、服务聚合等功能。

服务搭建过程与服务注册中心类似，首先在创建 module 时添加 Eureka-Zuul 依赖

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/网关代理添加依赖.png)

添加注解 @EnableZuulProxy 注解来启用 Zuul 的API网关功能

```java
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulApplication.class, args);
    }

}
```

修改配置文件

```properties
# 服务名称
spring.application.name=eureka-zuul
# 应用服务web访问端口
server.port=8080

# 注册中心地址
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/

# 以url为转发路径
#zuul.routes.homework-service.url=http://localhost:8081
#zuul.routes.student-service.url=http://localhost:8082
#zuul.routes.student-homework-service.url=http://localhost:8083

# 以服务名称为匹配路径
zuul.routes.homework-service.path=/homework-service/**
zuul.routes.student-service.path=/student-service/**
zuul.routes.student-homework-service.path=/student-homework-service/**
zuul.routes.teacher-service.path=/teacher-service/**

# 网关路径前缀
zuul.prefix=/proxy
```

启动服务如下图所示，即为成功

![](https://cdn.jsdelivr.net/gh/AFreshCodeFarmer/FigureBed//img/Typora/网关代理注册成功.png)

## web前端界面

web界面使用 HTML5 + CSS + JS，未使用框架，重点实现部分为**网络连接**和**动态添加数据至表格**

网络连接部分使用 axios，axios 是一个基于 promise 的 HTTP 库，可以用在浏览器和 node.js 中

以教师添加作业为例

```javascript
function addHomework_func() {

    // 获取输入框的内容
    const title = document.getElementById("homeworkTitle_1").value;
    const content = document.getElementById("homeworkContent_1").value;

    const url = "http://localhost:8080/proxy/homework-service/Homework/save";

    // 发送 post 请求
    axios({
        method: 'post',
        url: url,
        data: {
            "title": title,
            "content": content
        },
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            alert("Succeed to add homework");
        })
        .catch(function (error) {
            alert("Fail to add homework");
        });

    location.reload();
}
```

需要注意的是，本项目中 post 参数采用 application/json 格式，而不是 application/x-www-form-urlencoded 或 application/form-data，这种方式可以使参数不体现在 url 路径中

需要做跨域设置，request headers 添加如上请求头，服务端需要在 controller 类添加@Crossorigin 注解

```java
@CrossOrigin
@Controller
@RequestMapping(value = "/Homework")
public class HomeworkController {
	...
}
```

表格动态添加数据如下，主要函数为 insertRow(index)新建空行 和 insertCell(index)新建空格

*   insertRow(index)  index = 0 时，表示在第一行添加空行；index = 表格行数时，表示在最后一行添加空行；返回值为对此行的引用
*   insertCell(index)  用法与 insertRow(index) 类似，返回值为对此格的引用

最后使用 innerHTML 对表格内容进行赋值，并设置文字居中

```javascript
function refreshTable_func() {

    const url = "http://localhost:8080/proxy/homework-service/Homework/findAll";

    axios({
        method: 'get',
        url: url,
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            let homeworkData = [];
            for (let i = 0; i < response.data.data.length; i++) {
                homeworkData.push(response.data.data[i]);
            }

            // 获取表格对象
            let table = document.getElementById("homeworkTable");

            // 获取表格行数
            let row = table.rows.length;

            // 循环插入
            for (let i = 0; i < homeworkData.length; i++) {


                // 新建一行
                let tableRow = table.insertRow(i + row);

                let tableCellArray = [];

                for (let j = 0; j < 5; j++) {
                    tableCellArray[j] = tableRow.insertCell(j);
                }

                tableCellArray[0].innerHTML = homeworkData[i].id;
                tableCellArray[1].innerHTML = homeworkData[i].title;
                tableCellArray[2].innerHTML = homeworkData[i].content;
                tableCellArray[3].innerHTML = homeworkData[i].createTime;
                tableCellArray[4].innerHTML = homeworkData[i].updateTime;

                tableRow.align = 'center';

                table.appendChild(tableRow);
            }
        })
        .catch(function (error) {
            alert("Fail to get homework");
        });
}
```