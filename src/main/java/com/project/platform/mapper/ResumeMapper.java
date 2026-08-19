package com.project.platform.mapper;

import com.project.platform.entity.Resume;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface ResumeMapper {
    List<Resume> queryPage(Integer offset, Integer pageSize, @Param("query") Map<String, Object> query);

    int queryCount(@Param("query") Map<String, Object> query);

    @Select("SELECT * FROM resume WHERE id = #{id}")
    Resume selectById(Integer id);

    @Select("SELECT * FROM resume")
    List<Resume> list();

    int insert(Resume entity);

    int updateById(Resume entity);

    boolean removeByIds(List<Integer> ids);

}