package com.jzl.design.sigleton;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:11 2020/6/16
 * @Modified By:
 */
public enum  JzlEnum {
    SPRING("spring","春天"),
    SUMMER("summer","夏天");
    private String key;
    private String value;

    JzlEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        JzlEnum spring = JzlEnum.valueOf("SPRING");
        System.out.println(spring);
    }
}
