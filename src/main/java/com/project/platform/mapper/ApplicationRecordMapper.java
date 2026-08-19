package com.project.platform.mapper;

import com.project.platform.entity.ApplicationRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface ApplicationRecordMapper {
    List<ApplicationRecord> queryPage(Integer offset, Integer pageSize, @Param("query") Map<String, Object> query);

    int queryCount(@Param("query") Map<String, Object> query);

    @Select("SELECT * FROM application_record WHERE id = #{id}")
    ApplicationRecord selectById(Integer id);

    @Select("SELECT * FROM application_record")
    List<ApplicationRecord> list();

    int insert(ApplicationRecord entity);

    int updateById(ApplicationRecord entity);

    boolean removeByIds(List<Integer> ids);

}