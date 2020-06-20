document.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>");

// 刷新表格
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

function submitHomework_func() {
    const homeworkId = document.getElementById("homeworkId").value;
    const studentId = document.getElementById("studentId").value;
    const title = document.getElementById("title").value;
    const content = document.getElementById("content").value;
    const url = "http://localhost:8080/proxy/student-homework-service/StudentHomework/save";
    axios({
        method: 'post',
        url: url,
        data: {
            "studentId": studentId,
            "homeworkId": homeworkId,
            "homeworkTitle": title,
            "homeworkContent": content
        },
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            alert("Succeed to submit homework");
        })
        .catch(function (error) {
            alert("Fail to submit homework");
        });
}

function addHomework_func() {

    const title = document.getElementById("homeworkTitle_1").value;
    const content = document.getElementById("homeworkContent_1").value;

    const url = "http://localhost:8080/proxy/homework-service/Homework/save";

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

function updateHomework_func() {
    const id = document.getElementById("homeworkId").value;
    const title = document.getElementById("homeworkTitle_2").value;
    const content = document.getElementById("homeworkContent_2").value;

    const url = "http://localhost:8080/proxy/homework-service/Homework/save";

    axios({
        method: 'post',
        url: url,
        data: {
            "id": id,
            "title": title,
            "content": content
        },
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json;charset=utf-8"
        }
    })
        .then(function (response) {
            alert("Succeed to update homework");
        })
        .catch(function (error) {
            alert("Fail to update homework");
        });

    location.reload();
}