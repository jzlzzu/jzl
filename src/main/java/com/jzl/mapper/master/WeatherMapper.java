package com.jzl.mapper.master;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzl.entity.OoBean;
import com.jzl.entity.Weather;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:24 2019/4/24
 * @Modified By:
 */
public interface WeatherMapper extends BaseMapper<Weather> {

    @Select("SELECT * FROM `student` LEFT join `weather` on student.id = weather.id")
    List<Weather> lists(Page<Map<String, Object>> page);

    Weather selectCity();

    List<Weather> selectByWeather(Weather weather);

    List<Weather> selectByWeatherList(@Param("age") String age ,@Param("ooBean") OoBean ooBean);

    Integer customInsertSelective(Weather weather);

    void customBatchInsert(@Param("weatherList") List<Weather> weatherList);

    void customeUpdateById(Weather weather);

    @Select("SELECT * FROM `weather` where id = #{id} and city = #{city}")
    Weather testJzl(@Param(value = "id") Integer id, @Param("city") String city);

    @Select("select id , count(city) from weather GROUP BY city")
    List<Map<String, Object>> selectSum();

}
