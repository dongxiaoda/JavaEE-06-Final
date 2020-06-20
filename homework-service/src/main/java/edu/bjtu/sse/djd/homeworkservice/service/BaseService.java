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
    AbstractRepository<E, PK> repository = null;

    /**
     * 返回 repository
     *
     * @param
     * @return edu.bjtu.sse.djd.homeworkservice.repository.AbstractRepository<E, PK>
     * @author 董金达
     * @date 10:20 2020/6/18
     **/
    @Override
    public AbstractRepository<E, PK> getRepository() {
        return repository;
    }
}
