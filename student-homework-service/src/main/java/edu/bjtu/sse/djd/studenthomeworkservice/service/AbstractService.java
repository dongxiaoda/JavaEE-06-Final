package edu.bjtu.sse.djd.studenthomeworkservice.service;

import edu.bjtu.sse.djd.studenthomeworkservice.repository.AbstractRepository;

import java.util.List;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractService
 * @date 2020/6/17 22:48
 **/

public abstract class AbstractService<E, PK> {

    /**
     * 获取 repository
     *
     * @param
     * @return edu.bjtu.sse.djd.studenthomeworkservice.repository.AbstractRepository<E, PK>
     * @author 董金达
     * @date 22:49 2020/6/17
     **/
    protected abstract AbstractRepository<E, PK> getRepository();

    /**
     * 返回所有记录
     *
     * @param
     * @return java.util.List<E>
     * @author 董金达
     * @date 22:51 2020/6/17
     **/
    public List<E> findAll() {
        return getRepository().findAll();
    }

    /**
     * 添加或更新一条记录
     *
     * @param
     * @param e
     * @return void
     * @author 董金达
     * @date 22:52 2020/6/17
     **/
    public void save(E e) {
        getRepository().save(e);
    }

    /**
     * 删除一条记录
     *
     * @param
     * @param e
     * @return void
     * @author 董金达
     * @date 22:52 2020/6/17
     **/
    public void delete(E e) {
        getRepository().delete(e);
    }
}
