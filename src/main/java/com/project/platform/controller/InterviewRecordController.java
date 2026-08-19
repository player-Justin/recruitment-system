package com.project.platform.controller;

import com.project.platform.entity.InterviewRecord;
import com.project.platform.service.InterviewRecordService;
import com.project.platform.vo.PageVO;
import com.project.platform.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 面试记录
 */
@RestController
@RequestMapping("/interviewRecord")
public class InterviewRecordController {
    @Resource
    private InterviewRecordService interviewRecordService;

    /**
     * 分页查询
     *
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public ResponseVO<PageVO<InterviewRecord>> page(@RequestParam Map<String, Object> query, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageVO<InterviewRecord> page = interviewRecordService.page(query, pageNum, pageSize);
        return ResponseVO.ok(page);

    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("selectById/{id}")
    public ResponseVO<InterviewRecord> selectById(@PathVariable("id") Integer id) {
        InterviewRecord entity = interviewRecordService.selectById(id);
        return ResponseVO.ok(entity);
    }


    /**
     * 列表
     *
     * @return
     */
    @GetMapping("list")
    public ResponseVO<List<InterviewRecord>> list() {
        return ResponseVO.ok(interviewRecordService.list());
    }


    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping("add")
    public ResponseVO add(@RequestBody InterviewRecord entity) {
        interviewRecordService.insert(entity);
        return ResponseVO.ok();
    }

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    @PutMapping("update")
    public ResponseVO update(@RequestBody InterviewRecord entity) {
        interviewRecordService.updateById(entity);
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
        interviewRecordService.removeByIds(ids);
        return ResponseVO.ok();
    }
}
