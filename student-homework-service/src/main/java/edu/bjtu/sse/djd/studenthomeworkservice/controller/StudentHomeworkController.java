package edu.bjtu.sse.djd.studenthomeworkservice.controller;

import edu.bjtu.sse.djd.studenthomeworkservice.entity.StudentHomework;
import edu.bjtu.sse.djd.studenthomeworkservice.response.DataResponse;
import edu.bjtu.sse.djd.studenthomeworkservice.service.StudentHomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name StudentHomeworkController
 * @date 2020/6/17 22:59
 **/

@Controller(value = "StudentHomeworkController")
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
    @GetMapping(value = "/save")
    public void save(@RequestBody StudentHomework studentHomework) {
        studentHomeworkService.save(studentHomework);
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
    @GetMapping(value = "/delete")
    public void delete(@RequestBody StudentHomework studentHomework) {
        studentHomeworkService.delete(studentHomework);
    }

}
