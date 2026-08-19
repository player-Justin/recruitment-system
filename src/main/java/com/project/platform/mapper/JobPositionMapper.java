package com.project.platform.mapper;

import com.project.platform.entity.JobPosition;
import com.project.platform.vo.ValueNameVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface JobPositionMapper {
    List<JobPosition> queryPage(Integer offset, Integer pageSize, @Param("query") Map<String, Object> query);

    int queryCount(@Param("query") Map<String, Object> query);

    @Select("SELECT * FROM job_position WHERE id = #{id}")
    JobPosition selectById(Integer id);

    @Select("SELECT * FROM job_position")
    List<JobPosition> list();

    int insert(JobPosition entity);

    int updateById(JobPosition entity);

    boolean removeByIds(List<Integer> ids);

    @Select("""
    SELECT job_position.*
          ,enterprise.name AS enterpriseName
          FROM job_position
          LEFT JOIN enterprise ON job_position.enterprise_id=enterprise.id
          ORDER BY job_position.quantity_of_delivery DESC
          limit #{number}
    """)
    List<JobPosition> top(Integer number);


    @Select("""
            SELECT type AS name, COUNT(*) AS value 
            FROM job_position 
            WHERE (enterprise_id = #{enterpriseId} OR #{enterpriseId} IS NULL)
            GROUP BY type
            """)
    List<ValueNameVO> typeRatio(Integer enterpriseId);


    @Select("""
            SELECT experience_required AS name, COUNT(*) AS value 
            FROM job_position 
            WHERE (enterprise_id = #{enterpriseId} OR #{enterpriseId} IS NULL)
            GROUP BY experience_required
            """)
    List<ValueNameVO> experienceRequiredRatio(Integer enterpriseId);

    @Select("""
            SELECT education_required AS name, COUNT(*) AS value 
            FROM job_position 
            WHERE (enterprise_id = #{enterpriseId} OR #{enterpriseId} IS NULL)
            GROUP BY education_required
            """)
    List<ValueNameVO> educationRequiredRatio(Integer enterpriseId);

    @Select("""
            SELECT name AS job_name, quantity_of_delivery AS qty FROM job_position
            WHERE (enterprise_id = #{enterpriseId} OR #{enterpriseId} IS NULL)
            ORDER BY quantity_of_delivery DESC LIMIT 10""")
    @Results({
            @Result(property = "name", column = "job_name"),
            @Result(property = "value", column = "qty")
    })
    List<ValueNameVO> quantityOfDeliveryCount(Integer enterpriseId);



}