package edu.bjtu.sse.djd.teacherservice.service;

import edu.bjtu.sse.djd.teacherservice.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 董金达
 * @version 1.0
 * @name BaseService
 * @date 2020/6/19 10:27
 **/

public abstract class BaseService<E, PK, R extends AbstractRepository<E, PK>> extends AbstractService<E, PK> {

    @Autowired
    protected R repository;

    @Override
    public R getRepository() {
        return repository;
    }

}
