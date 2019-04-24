package com.jzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzl.entity.Weather;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:24 2019/4/24
 * @Modified By:
 */
@Mapper
public interface WeatherMapper extends BaseMapper<Weather> {

}
