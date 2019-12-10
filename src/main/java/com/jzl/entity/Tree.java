package com.jzl.entity;

import lombok.Data;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:39 2019/11/22
 * @Modified By:
 */
@Data
public class Tree {
    private String color;
    private String high;

    public Tree() {
    }

    public Tree(String color, String high) {
        this.color = color;
        this.high = high;
    }
}
