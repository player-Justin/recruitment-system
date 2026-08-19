package com.project.platform.controller;

import com.project.platform.service.AIService;
import com.project.platform.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Resource
    private AIService aiService;

    @GetMapping("/test")
    public ResponseVO<String> test() {
        System.out.println("========== 测试接口被调用 ==========");
        return ResponseVO.ok("后端AI接口正常工作！时间: " + new java.util.Date());
    }

    @PostMapping("/chat")
    public ResponseVO<String> chat(@RequestBody Map<String, String> request) {
        System.out.println("========== 收到AI聊天请求 ==========");
        System.out.println("请求内容: " + request);
        String message = request.get("message");
        if (message == null || message.trim().isEmpty()) {
            return ResponseVO.fail(400, "消息不能为空");
        }
        try {
            String response = aiService.chat(message);
            System.out.println("AI响应成功: " + response);
            return ResponseVO.ok(response);
        } catch (Exception e) {
            System.out.println("AI处理异常:");
            e.printStackTrace();
            return ResponseVO.fail(500, "AI服务异常: " + e.getMessage());
        }
    }
}
