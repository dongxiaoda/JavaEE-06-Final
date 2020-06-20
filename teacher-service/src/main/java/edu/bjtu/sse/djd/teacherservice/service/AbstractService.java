package edu.bjtu.sse.djd.teacherservice.service;

import edu.bjtu.sse.djd.teacherservice.repository.AbstractRepository;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractService
 * @date 2020/6/19 8:56
 **/

public abstract class AbstractService<E, PK> {

    /**
     * 抽象方法 获取 repository
     *
     * @param
     * @return edu.bjtu.sse.djd.teacherservice.repository.AbstractRepository
     * @author 董金达
     * @date 8:58 2020/6/19
     **/
    public abstract AbstractRepository getRepository();

    /**
     * 返回所有记录
     *
     * @param
     * @return java.util.List<E>
     * @author 董金达
     * @date 10:26 2020/6/19
     **/
    public List<E> findAll() {
        return getRepository().findAll();
    }


    /**
     * QBE
     *
     * @param
     * @param example
     * @return java.util.List<E>
     * @author 董金达
     * @date 10:26 2020/6/19
     **/
    public List<E> findByExample(Example<E> example) {
        return getRepository().findAll(example);
    }

    /**
     * 更新或添加
     *
     * @param
     * @param e
     * @return void
     * @author 董金达
     * @date 10:26 2020/6/19
     **/
    public void save(E e) {
        getRepository().save(e);
    }

    /**
     * 删除
     *
     * @param
     * @param e
     * @return void
     * @author 董金达
     * @date 10:26 2020/6/19
     **/
    public void delete(E e) {
        getRepository().delete(e);
    }

}
