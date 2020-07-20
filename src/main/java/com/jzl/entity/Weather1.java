package com.jzl.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:20 2019/4/24
 * @Modified By:
 */
@Data
public class Weather1 implements Serializable {
    private Integer id;
    private String province;
    private String time;
    private String weather;
    private String temperature;
    private String wind;
}
