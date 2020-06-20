package edu.bjtu.sse.djd.teacherservice.service;

import edu.bjtu.sse.djd.teacherservice.entity.Teacher;
import edu.bjtu.sse.djd.teacherservice.repository.TeacherRepository;
import org.springframework.stereotype.Service;

/**
 * @author 董金达
 * @version 1.0
 * @name TeacherService
 * @date 2020/6/19 10:27
 **/

@Service
public class TeacherService extends BaseService<Teacher, Long, TeacherRepository> {
}
