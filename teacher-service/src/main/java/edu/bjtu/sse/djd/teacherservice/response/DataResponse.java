package edu.bjtu.sse.djd.teacherservice.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 董金达
 * @version 1.0
 * @name DataResponse
 * @date 2020/6/19 8:56
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponse<T> extends Response {

    private T data;
}
