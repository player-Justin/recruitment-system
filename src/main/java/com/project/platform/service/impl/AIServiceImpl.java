package com.project.platform.service.impl;

import com.project.platform.service.AIService;
import com.project.platform.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AIServiceImpl implements AIService {

    @Value("${ai.api.url}")
    private String apiUrl;

    @Value("${ai.api.key}")
    private String apiKey;

    @Value("${ai.model}")
    private String model;

    @Autowired
    private RestTemplate restTemplate;

    // 简单的LRU缓存，缓存常见问题
    private final Map<String, String> cache = new ConcurrentHashMap<>();
    private static final int MAX_CACHE_SIZE = 100;

    // 预设的快捷回复，避免API调用
    private static final Map<String, String> quickReplies = new HashMap<>();
    
    static {
        quickReplies.put("你好", "您好！我是智能助手，有什么可以帮助您的吗？");
        quickReplies.put("你好吗", "我很好，谢谢！请问有什么问题？");
        quickReplies.put("帮助", "我可以帮助您：1. 简历优化建议 2. 面试技巧 3. 求职流程咨询 4. 薪资谈判技巧 5. 职业规划建议");
        quickReplies.put("您好", "您好！我是智能助手，有什么可以帮助您的吗？");
        quickReplies.put("谢谢", "不客气！如果还有问题，随时问我哦！");
        quickReplies.put("再见", "再见！祝您求职顺利！");
    }

    @Override
    public String chat(String message) {
        System.out.println("========== 开始处理AI请求，消息: " + message + " ==========");
        
        // 1. 先检查快捷回复
        String normalizedMessage = message.trim().toLowerCase();
        if (quickReplies.containsKey(normalizedMessage)) {
            System.out.println("使用快捷回复");
            return quickReplies.get(normalizedMessage);
        }
        
        // 2. 检查缓存
        String cacheKey = generateCacheKey(message);
        if (cache.containsKey(cacheKey)) {
            System.out.println("命中缓存");
            return cache.get(cacheKey);
        }

        try {
            System.out.println("调用豆包API...");
            System.out.println("API URL: " + apiUrl);
            System.out.println("Model: " + model);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + apiKey);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", model);
            requestBody.put("temperature", 0.5);       // 降低温度，更快响应
            requestBody.put("max_tokens", 500);       // 限制最大token数，加快响应
            requestBody.put("top_p", 0.9);            // 优化采样策略
            requestBody.put("stream", false);         // 非流式

            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "你是一个在线求职系统的智能助手。请用简洁、清晰、口语化的中文回答用户问题，不要使用Markdown格式、星号、加粗等符号，直接输出纯文字内容。回答要简短实用，重点突出，一般不超过200字。");

            Map<String, String> userMessage = new HashMap<>();
            userMessage.put("role", "user");
            userMessage.put("content", message);

            requestBody.put("messages", Arrays.asList(systemMessage, userMessage));

            System.out.println("请求体: " + requestBody);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

            long startTime = System.currentTimeMillis();
            ResponseEntity<Map> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    request,
                    Map.class
            );
            long endTime = System.currentTimeMillis();
            System.out.println("API调用耗时: " + (endTime - startTime) + "ms");

            System.out.println("API响应状态码: " + response.getStatusCode());

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map<String, Object> body = response.getBody();
                List<Map<String, Object>> choices = (List<Map<String, Object>>) body.get("choices");
                if (choices != null && !choices.isEmpty()) {
                    Map<String, Object> choice = choices.get(0);
                    Map<String, String> messageObj = (Map<String, String>) choice.get("message");
                    if (messageObj != null && messageObj.containsKey("content")) {
                        String result = messageObj.get("content");
                        System.out.println("成功获取AI响应: " + result);
                        
                        // 缓存结果
                        putCache(cacheKey, result);
                        
                        return result;
                    }
                }
            }

            throw new CustomException("AI响应解析失败");
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("AI服务调用异常:");
            e.printStackTrace();
            throw new CustomException("AI服务调用失败: " + e.getMessage());
        }
    }

    private String generateCacheKey(String message) {
        return message.trim().toLowerCase();
    }

    private void putCache(String key, String value) {
        if (cache.size() >= MAX_CACHE_SIZE) {
            // 简单的LRU策略：随机删除一个
            String oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }
}
