package com.jzl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:42 2020/11/11
 * @Modified By:
 */
@Data
@TableName("student")
public class Student {
    private Integer id;
    private String name;
    private String age;
    private Date date;
    private Timestamp timestamp;
}
