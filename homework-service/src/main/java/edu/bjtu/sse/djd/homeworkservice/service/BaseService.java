package edu.bjtu.sse.djd.homeworkservice.service;

import edu.bjtu.sse.djd.homeworkservice.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 董金达
 * @version 1.0
 * @name BaseService
 * @date 2020/6/17 16:51
 **/

public abstract class BaseService<E, PK, R extends AbstractRepository<E, PK>> extends AbstractService<E, PK> {

    @Autowired
    protected R repository;

    @Override
    protected R getRepository() {
        return repository;
    }
}
