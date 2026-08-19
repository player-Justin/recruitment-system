package com.project.platform.mapper;

import com.project.platform.entity.Enterprise;
import com.project.platform.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface EnterpriseMapper {
    List<Enterprise> queryPage(Integer offset, Integer pageSize, @Param("query") Map<String, Object> query);

    int queryCount(@Param("query") Map<String, Object> query);

    @Select("SELECT * FROM enterprise WHERE id = #{id}")
    Enterprise selectById(Integer id);

    @Select("SELECT * FROM enterprise")
    List<Enterprise> list();

    int insert(Enterprise entity);

    int updateById(Enterprise entity);

    boolean removeByIds(List<Integer> ids);

    @Select("SELECT * FROM enterprise WHERE username = #{username}")
    Enterprise selectByUsername(String username);

    @Select("SELECT * FROM enterprise WHERE tel = #{tel}")
    Enterprise selectByTel(String tel);

}