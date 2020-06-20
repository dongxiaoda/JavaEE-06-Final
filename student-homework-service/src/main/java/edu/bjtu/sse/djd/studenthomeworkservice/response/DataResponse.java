package edu.bjtu.sse.djd.studenthomeworkservice.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 董金达
 * @version 1.0
 * @name DataResponse
 * @date 2020/6/17 22:59
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponse<T> extends Response {

    private T data;
}
