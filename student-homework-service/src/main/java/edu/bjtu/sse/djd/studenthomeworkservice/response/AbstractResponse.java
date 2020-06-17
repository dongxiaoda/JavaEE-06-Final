package edu.bjtu.sse.djd.studenthomeworkservice.response;

import lombok.Data;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractResponse
 * @date 2020/6/17 22:58
 **/

@Data
public abstract class AbstractResponse {

    private int code;

    private String msg;
}
