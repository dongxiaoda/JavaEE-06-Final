package edu.bjtu.sse.djd.teacherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author 董金达
 * @version 1.0
 * @name AbsractRepository
 * @date 2020/6/19 8:53
 **/

@NoRepositoryBean
public interface AbstractRepository<E, PK> extends JpaRepository<E, PK> {
}
