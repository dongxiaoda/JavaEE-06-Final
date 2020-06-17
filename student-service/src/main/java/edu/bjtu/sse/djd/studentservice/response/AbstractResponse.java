package edu.bjtu.sse.djd.studentservice.response;

import lombok.Data;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractResponse
 * @date 2020/6/17 19:26
 **/

@Data
public abstract class AbstractResponse {

    private int code;

    private String msg;
}
