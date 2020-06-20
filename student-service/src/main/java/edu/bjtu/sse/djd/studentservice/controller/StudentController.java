package edu.bjtu.sse.djd.studentservice.controller;

import edu.bjtu.sse.djd.studentservice.entity.Student;
import edu.bjtu.sse.djd.studentservice.response.DataResponse;
import edu.bjtu.sse.djd.studentservice.response.Response;
import edu.bjtu.sse.djd.studentservice.service.StudentService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name StudentController
 * @date 2020/6/17 19:52
 **/

@CrossOrigin
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
     * 更新或添加一条记录
     *
     * @param
     * @param student
     * @return void
     * @author 董金达
     * @date 20:00 2020/6/17
     **/
    @ResponseBody
    @PostMapping(value = "/register")
    public Response saveStudent(@RequestBody Student student) {
        studentService.save(student);

        Response response = new Response();
        response.setCode(0);
        response.setMsg("Succeed to register");

        return response;
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public Response login(@RequestBody Student student) {
        Example<Student> example = Example.of(student);

        List<Student> list = studentService.findByExample(example);

        Response response = new Response();

        if (list.size() > 0) {
            Student realStudent = list.get(0);


            String msg = student.getPassword().equals(realStudent.getPassword()) ? "Match" : "Not Match";

            int code = student.getPassword().equals(realStudent.getPassword()) ? 0 : -1;

            response.setCode(code);
            response.setMsg(msg);

        } else {

            String msg = "No such student, please register first";
            int code = -1;

            response.setCode(code);
            response.setMsg(msg);

        }
        return response;


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
    @ResponseBody
    @PostMapping(value = "/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
    }

}
