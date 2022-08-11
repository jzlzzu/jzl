package com.jzl.service;

import com.jzl.entity.Student;

/**
 * 测试一个特殊的实现类
 */
@FunctionalInterface
public interface UserDeService {
    Student loadUserByUsername(String username);
}
