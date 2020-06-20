package edu.bjtu.sse.djd.studentservice.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 董金达
 * @version 1.0
 * @name DataResponse
 * @date 2020/6/17 19:27
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponse<T> extends Response {

    private T data;

}
