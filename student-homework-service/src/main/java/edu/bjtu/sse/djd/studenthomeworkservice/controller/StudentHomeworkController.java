package edu.bjtu.sse.djd.studenthomeworkservice.controller;

import edu.bjtu.sse.djd.studenthomeworkservice.entity.StudentHomework;
import edu.bjtu.sse.djd.studenthomeworkservice.response.DataResponse;
import edu.bjtu.sse.djd.studenthomeworkservice.response.Response;
import edu.bjtu.sse.djd.studenthomeworkservice.service.StudentHomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name StudentHomeworkController
 * @date 2020/6/17 22:59
 **/

@CrossOrigin
@Controller
@RequestMapping(value = "/StudentHomework")
public class StudentHomeworkController {

    private final StudentHomeworkService studentHomeworkService;

    public StudentHomeworkController(StudentHomeworkService studentHomeworkService) {
        this.studentHomeworkService = studentHomeworkService;
    }

    /**
     * 所有 StudentHomework 数据封装为 DataResponse
     *
     * @param
     * @return edu.bjtu.sse.djd.studenthomeworkservice.response.DataResponse<java.util.List < edu.bjtu.sse.djd.studenthomeworkservice.entity.StudentHomework>>
     * @author 董金达
     * @date 23:04 2020/6/17
     **/
    @ResponseBody
    @GetMapping(value = "/findAll")
    public DataResponse<List<StudentHomework>> findAll() {

        DataResponse<List<StudentHomework>> dataResponse = new DataResponse<>();

        List<StudentHomework> list = studentHomeworkService.findAll();

        dataResponse.setData(list);
        dataResponse.setCode(0);
        dataResponse.setMsg("Succeed to get all StudentHomework");

        return dataResponse;
    }

    /**
     * 添加或更新一条 StudentHomework
     *
     * @param
     * @param studentHomework
     * @return void
     * @author 董金达
     * @date 23:06 2020/6/17
     **/
    @ResponseBody
    @PostMapping(value = "/save")
    public Response save(@RequestBody StudentHomework studentHomework) {
        studentHomeworkService.save(studentHomework);

        String msg = "Succeed to save student-homework";

        Response response = new Response();
        response.setCode(0);
        response.setMsg(msg);

        return response;
    }

    /**
     * 删除一条 StudentHomework
     *
     * @param
     * @param studentHomework
     * @return void
     * @author 董金达
     * @date 23:08 2020/6/17
     **/
    @PostMapping(value = "/delete")
    public void delete(@RequestBody StudentHomework studentHomework) {
        studentHomeworkService.delete(studentHomework);
    }

}
