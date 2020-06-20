package edu.bjtu.sse.djd.homeworkservice.controller;

import edu.bjtu.sse.djd.homeworkservice.entity.Homework;
import edu.bjtu.sse.djd.homeworkservice.response.DataResponse;
import edu.bjtu.sse.djd.homeworkservice.response.Response;
import edu.bjtu.sse.djd.homeworkservice.service.HomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name HomeworkController
 * @date 2020/6/17 16:59
 **/

@CrossOrigin
@Controller(value = "Homework")
@RequestMapping(value = "/Homework")
public class HomeworkController {

    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    /**
     * 所有 Homework 数据封装为 DataResponse
     *
     * @param
     * @return edu.bjtu.sse.djd.homeworkservice.response.DataResponse<java.util.List < edu.bjtu.sse.djd.homeworkservice.entity.Homework>>
     * @author 董金达
     * @date 17:04 2020/6/17
     **/
    @ResponseBody
    @GetMapping(value = "/findAll")
    public DataResponse<List<Homework>> findAllHomework() {

        DataResponse<List<Homework>> dataResponse = new DataResponse<>();

        List<Homework> list = homeworkService.findAll();

        dataResponse.setData(list);
        dataResponse.setCode(0);
        dataResponse.setMsg("Succeed to get all homework");

        return dataResponse;
    }

    /**
     * 更新或添加一条 homework
     *
     * @param
     * @param homework
     * @return void
     * @author 董金达
     * @date 17:07 2020/6/17
     **/
    @ResponseBody
    @PostMapping(value = "/save")
    public Response saveHomework(@RequestBody Homework homework) {
        homeworkService.save(homework);

        Response response = new Response();

        response.setCode(0);
        response.setMsg("Succeed to save a homework");

        return response;
    }

    /**
     * 删除一条 homework
     *
     * @param
     * @param homework
     * @return void
     * @author 董金达
     * @date 17:07 2020/6/17
     **/
    @PostMapping(value = "/delete")
    public void deleteHomework(@RequestBody Homework homework) {
        homeworkService.delete(homework);
    }

}
