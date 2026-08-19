package com.project.platform.controller;

import com.project.platform.entity.ApplicationRecord;
import com.project.platform.service.ApplicationRecordService;
import com.project.platform.vo.PageVO;
import com.project.platform.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 投递记录
 */
@RestController
@RequestMapping("/applicationRecord")
public class ApplicationRecordController {
    @Resource
    private ApplicationRecordService applicationRecordService;

    /**
     * 分页查询
     *
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public ResponseVO<PageVO<ApplicationRecord>> page(@RequestParam Map<String, Object> query, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageVO<ApplicationRecord> page = applicationRecordService.page(query, pageNum, pageSize);
        return ResponseVO.ok(page);

    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("selectById/{id}")
    public ResponseVO<ApplicationRecord> selectById(@PathVariable("id") Integer id) {
        ApplicationRecord entity = applicationRecordService.selectById(id);
        return ResponseVO.ok(entity);
    }


    /**
     * 列表
     *
     * @return
     */
    @GetMapping("list")
    public ResponseVO<List<ApplicationRecord>> list() {
        return ResponseVO.ok(applicationRecordService.list());
    }


    /**
     * 新增
     *
     * @param entity
     * @return
     */
    @PostMapping("add")
    public ResponseVO add(@RequestBody ApplicationRecord entity) {
        applicationRecordService.insert(entity);
        return ResponseVO.ok();
    }

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    @PutMapping("update")
    public ResponseVO update(@RequestBody ApplicationRecord entity) {
        applicationRecordService.updateById(entity);
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
        applicationRecordService.removeByIds(ids);
        return ResponseVO.ok();
    }
}
