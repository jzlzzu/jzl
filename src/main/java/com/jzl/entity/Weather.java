package com.jzl.entity;

import lombok.Data;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:20 2019/4/24
 * @Modified By:
 */
@Data
public class Weather {
    private int id;
    private String province;
    private String city;
    private String time;
    private String weather;
    private String temperature;
    private String wind;
}