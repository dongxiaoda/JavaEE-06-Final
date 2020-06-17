package edu.bjtu.sse.djd.studentservice.service;

import edu.bjtu.sse.djd.studentservice.entity.Student;
import edu.bjtu.sse.djd.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * @author 董金达
 * @version 1.0
 * @name StudentService
 * @date 2020/6/17 19:44
 **/

@Service
public class StudentService extends BaseService<Student, Long, StudentRepository> {
}
