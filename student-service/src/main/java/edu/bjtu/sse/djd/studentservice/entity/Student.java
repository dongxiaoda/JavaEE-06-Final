package edu.bjtu.sse.djd.studentservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Student 实体类
 *
 * @author 董金达
 * @version 1.0
 * @name Student
 * @date 2020/6/17 18:50
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "s_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
