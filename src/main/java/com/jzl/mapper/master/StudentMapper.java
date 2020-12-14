package com.jzl.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzl.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:44 2020/11/11
 * @Modified By:
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> queryByDate(@Param("date") Date date);
}
