package edu.bjtu.sse.djd.homeworkservice.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实现带有列表数据的响应
 *
 * @author 董金达
 * @version 1.0
 * @name DataResponse
 * @date 2020/6/17 16:44
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResponse<T> extends AbstractResponse {

    private T data;
}
