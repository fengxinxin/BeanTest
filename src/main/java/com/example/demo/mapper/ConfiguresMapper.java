package com.example.demo.mapper;

import com.example.demo.Entity.Configures;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by FengXinXin on 2018/4/16.
 */
@Mapper
public interface ConfiguresMapper {
    @Select("SELECT * FROM T_CONFIGURES WHERE server = #{server}")
    List<Configures> getListByServer(@Param("server") String server);

    @Select("SELECT * FROM T_CONFIGURES")
    List<Configures> getAll();
}
