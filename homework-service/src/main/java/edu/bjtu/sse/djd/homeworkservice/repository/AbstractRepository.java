package edu.bjtu.sse.djd.homeworkservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 使用了该注解的接口不会被单独创建实例，只会作为其他接口的父接口而被使用
 *
 * @author 董金达
 * @version 1.0
 * @name AbstractRepository
 * @date 2020/6/17 16:36
 **/

@NoRepositoryBean
public interface AbstractRepository<E, PK> extends JpaRepository<E, PK> {
}
