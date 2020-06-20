package edu.bjtu.sse.djd.teacherservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 董金达
 * @version 1.0
 * @name Teacher
 * @date 2020/6/19 8:51
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "s_teacher")
public class Teacher {

    @Id
    private Long id;

    private String userName;

    private String password;

}
