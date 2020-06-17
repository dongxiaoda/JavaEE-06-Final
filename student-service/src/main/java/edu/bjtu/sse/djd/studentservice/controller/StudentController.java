package edu.bjtu.sse.djd.studentservice.controller;

import edu.bjtu.sse.djd.studentservice.entity.Student;
import edu.bjtu.sse.djd.studentservice.response.DataResponse;
import edu.bjtu.sse.djd.studentservice.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name StudentController
 * @date 2020/6/17 19:52
 **/

@Controller(value = "Student")
@RequestMapping(value = "/Student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 所有 Student 数据封装为 DataResponse
     *
     * @param
     * @return edu.bjtu.sse.djd.studentservice.response.DataResponse<java.util.List < edu.bjtu.sse.djd.studentservice.entity.Student>>
     * @author 董金达
     * @date 19:56 2020/6/17
     **/
    @ResponseBody
    @GetMapping(value = "/findAll")
    public DataResponse<List<Student>> findAllStudent() {

        DataResponse<List<Student>> dataResponse = new DataResponse<>();

        List<Student> list = studentService.findAll();

        dataResponse.setData(list);
        dataResponse.setCode(0);
        dataResponse.setMsg("Succeed to get all student");

        return dataResponse;
    }

    /**
     * 更新或删除一条记录
     *
     * @param
     * @param student
     * @return void
     * @author 董金达
     * @date 20:00 2020/6/17
     **/
    @PostMapping(value = "/save")
    public void saveStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    /**
     * 删除一条记录
     *
     * @param
     * @param student
     * @return void
     * @author 董金达
     * @date 20:00 2020/6/17
     **/
    @PostMapping(value = "/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
    }

}
