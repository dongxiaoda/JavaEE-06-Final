package edu.bjtu.sse.djd.homeworkservice.service;

import edu.bjtu.sse.djd.homeworkservice.entity.Homework;
import edu.bjtu.sse.djd.homeworkservice.repository.HomeworkRepository;
import org.springframework.stereotype.Service;

/**
 * @author 董金达
 * @version 1.0
 * @name HomeworkService
 * @date 2020/6/17 16:53
 **/

@Service
public class HomeworkService extends BaseService<Homework, Long, HomeworkRepository> {
}
