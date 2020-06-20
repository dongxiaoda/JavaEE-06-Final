package edu.bjtu.sse.djd.teacherservice.controller;

import edu.bjtu.sse.djd.teacherservice.entity.Teacher;
import edu.bjtu.sse.djd.teacherservice.response.DataResponse;
import edu.bjtu.sse.djd.teacherservice.response.Response;
import edu.bjtu.sse.djd.teacherservice.service.TeacherService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name TeacherController
 * @date 2020/6/19 10:30
 **/

@Controller
@CrossOrigin
@RequestMapping(value = "/Teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ResponseBody
    @GetMapping(value = "/findAll")
    public DataResponse<List<Teacher>> findAll() {

        DataResponse<List<Teacher>> dataResponse = new DataResponse<>();

        List<Teacher> list = teacherService.findAll();

        dataResponse.setData(list);
        dataResponse.setCode(0);
        dataResponse.setMsg("Succeed to get all teachers");

        return dataResponse;
    }

    /**
     * QBE 精准查找
     *
     * @param
     * @param teacher
     * @return edu.bjtu.sse.djd.teacherservice.response.Response
     * @author 董金达
     * @date 10:44 2020/6/19
     **/
    @ResponseBody
    @PostMapping(value = "/login")
    public Response findByExample(@RequestBody Teacher teacher) {

        Example<Teacher> example = Example.of(teacher);

        Teacher realTeacher = teacherService.findByExample(example).get(0);

        Response response = new Response();

        String msg = teacher.getPassword().equals(realTeacher.getPassword()) ? "Match" : "Not Match";

        int code = teacher.getPassword().equals(realTeacher.getPassword()) ? 0 : -1;

        response.setCode(code);
        response.setMsg(msg);

        return response;
    }

    @ResponseBody
    @PostMapping(value = "/register")
    public Response save(@RequestBody Teacher teacher) {
        teacherService.save(teacher);

        Response response = new Response();

        response.setMsg("Succeed to register");
        response.setCode(0);

        return response;
    }

}
