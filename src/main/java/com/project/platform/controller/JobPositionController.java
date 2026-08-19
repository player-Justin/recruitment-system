package com.project.platform.controller;

import com.project.platform.entity.JobPosition;
import com.project.platform.mapper.JobPositionMapper;
import com.project.platform.service.JobPositionService;
import com.project.platform.vo.PageVO;
import com.project.platform.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 职位
 */
@RestController
@RequestMapping("/jobPosition")
public class JobPositionController {
    @Resource
    private JobPositionService jobPositionService;

    @Resource
    private JobPositionMapper jobPositionMapper;

    /**
     * 分页查询
     *
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public ResponseVO<PageVO<JobPosition>> page(@RequestParam Map<String, Object> query, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageVO<JobPosition> page = jobPositionService.page(query, pageNum, pageSize);
        return ResponseVO.ok(page);

    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("selectById/{id}")
    public ResponseVO<JobPosition> selectById(@PathVariable("id") Integer id) {
        JobPosition entity = jobPositionService.selectById(id);
        return ResponseVO.ok(entity);
    }


    /**
     * 列表
     *
     * @return
     */
    @GetMapping("list")
    public ResponseVO<List<JobPosition>> list() {
        return ResponseVO.ok(jobPositionService.list());
    }


    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping("add")
    public ResponseVO add(@RequestBody JobPosition entity) {
        jobPositionService.insert(entity);
        return ResponseVO.ok();
    }

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    @PutMapping("update")
    public ResponseVO update(@RequestBody JobPosition entity) {
        jobPositionService.updateById(entity);
        return ResponseVO.ok();
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @DeleteMapping("delBatch")
    public ResponseVO delBatch(@RequestBody List<Integer> ids) {
        jobPositionService.removeByIds(ids);
        return ResponseVO.ok();
    }

    @GetMapping("top/{number}")
    public ResponseVO<List<JobPosition>> top(@PathVariable Integer number) {
        List<JobPosition> top = jobPositionMapper.top(number);
        return ResponseVO.ok(top);
    }
}
