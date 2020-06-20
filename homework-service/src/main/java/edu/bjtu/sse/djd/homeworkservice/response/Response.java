package edu.bjtu.sse.djd.homeworkservice.response;

import lombok.Data;

/**
 * response 抽象类
 *
 * @author 董金达
 * @version 1.0
 * @name AbstractResponse
 * @date 2020/6/17 16:41
 **/

@Data
public class Response {

    private int code;

    private String msg;
}
