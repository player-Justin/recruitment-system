package com.project.platform.mapper;

import com.project.platform.entity.InterviewRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface InterviewRecordMapper {
    List<InterviewRecord> queryPage(Integer offset, Integer pageSize, @Param("query") Map<String, Object> query);

    int queryCount(@Param("query") Map<String, Object> query);

    @Select("SELECT * FROM interview_record WHERE id = #{id}")
    InterviewRecord selectById(Integer id);

    @Select("SELECT * FROM interview_record")
    List<InterviewRecord> list();

    int insert(InterviewRecord entity);

    int updateById(InterviewRecord entity);

    boolean removeByIds(List<Integer> ids);

}