package edu.bjtu.sse.djd.studenthomeworkservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author 董金达
 * @version 1.0
 * @name AbstractRepository
 * @date 2020/6/17 22:46
 **/

@NoRepositoryBean
public interface AbstractRepository<E, PK> extends JpaRepository<E, PK> {
}
