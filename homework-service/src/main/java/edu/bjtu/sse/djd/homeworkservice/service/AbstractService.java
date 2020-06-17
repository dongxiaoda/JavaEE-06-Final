package edu.bjtu.sse.djd.homeworkservice.service;

import edu.bjtu.sse.djd.homeworkservice.repository.AbstractRepository;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractService
 * @date 2020/6/17 16:46
 **/

public abstract class AbstractService<E, PK> {

    /**
     * 抽象方法 获取repository
     *
     * @param
     * @return edu.bjtu.sse.djd.homeworkservice.repository.AbstractRepository<E, PK>
     * @author 董金达
     * @date 16:47 2020/6/17
     **/
    protected abstract AbstractRepository<E, PK> getRepository();

    /**
     * 返回所有记录
     *
     * @param
     * @return java.util.List<E>
     * @author 董金达
     * @date 16:49 2020/6/17
     **/
    public List<E> findAll() {
        return getRepository().findAll();
    }

    /**
     * 增加或更新一条记录
     *
     * @param
     * @param e
     * @return void
     * @author 董金达
     * @date 16:57 2020/6/17
     **/
    public void save(E e) {
        getRepository().save(e);
    }

    /**
     * 删除一条数据
     *
     * @param
     * @param e
     * @return void
     * @author 董金达
     * @date 16:58 2020/6/17
     **/
    public void delete(E e) {
        getRepository().delete(e);
    }
}
