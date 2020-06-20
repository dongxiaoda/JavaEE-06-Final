package edu.bjtu.sse.djd.homeworkservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Homework 实体类
 *
 * @author 董金达
 * @version 1.0
 * @name Homework
 * @date 2020/6/17 16:35
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
