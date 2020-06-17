package edu.bjtu.sse.djd.studenthomeworkservice.service;

import edu.bjtu.sse.djd.studenthomeworkservice.entity.StudentHomework;
import edu.bjtu.sse.djd.studenthomeworkservice.repository.StudentHomeworkRepository;
import org.springframework.stereotype.Service;

/**
 * @author 董金达
 * @version 1.0
 * @name StudentHomeworkService
 * @date 2020/6/17 22:57
 **/

@Service
public class StudentHomeworkService extends BaseService<StudentHomework, Long, StudentHomeworkRepository> {
}
