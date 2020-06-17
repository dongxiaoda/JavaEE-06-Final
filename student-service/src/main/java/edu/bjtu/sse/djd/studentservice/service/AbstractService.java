package edu.bjtu.sse.djd.studentservice.service;

import edu.bjtu.sse.djd.studentservice.entity.Student;
import edu.bjtu.sse.djd.studentservice.repository.AbstractRepository;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractService
 * @date 2020/6/17 19:23
 **/


public abstract class AbstractService<E, PK> {

    /**
     * 抽象方法 获取 repository
     *
     * @param
     * @return edu.bjtu.sse.djd.studentservice.repository.AbstractRepository<E, PK>
     * @author 董金达
     * @date 19:25 2020/6/17
     **/
    protected abstract AbstractRepository getRepository();

    /**
     * 返回所有数据
     *
     * @param
     * @return java.util.List<edu.bjtu.sse.djd.studentservice.entity.Student>
     * @author 董金达
     * @date 19:42 2020/6/17
     **/
    public List<Student> findAll() {
        return getRepository().findAll();
    }

    /**
     * 更新或添加一条记录
     *
     * @param
     * @param student
     * @return void
     * @author 董金达
     * @date 19:43 2020/6/17
     **/
    public void save(Student student) {
        getRepository().save(student);
    }

    /**
     * 删除一条记录
     *
     * @param
     * @param student
     * @return void
     * @author 董金达
     * @date 19:44 2020/6/17
     **/
    public void delete(Student student) {
        getRepository().delete(student);
    }

}
