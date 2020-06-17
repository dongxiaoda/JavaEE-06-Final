package edu.bjtu.sse.djd.studenthomeworkservice.service;

import edu.bjtu.sse.djd.studenthomeworkservice.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 董金达
 * @version 1.0
 * @name BaseService
 * @date 2020/6/17 22:52
 **/

public abstract class BaseService<E, PK, R extends AbstractRepository<E, PK>> extends AbstractService<E, PK> {

    @Autowired
    protected R repository;

    @Override
    protected R getRepository() {
        return repository;
    }

}
