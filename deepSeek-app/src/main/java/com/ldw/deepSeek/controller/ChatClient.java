package com.ldw.deepSeek.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChatClient {
    private final String apiKey;
    private final String apiUrl;
    private final HttpClient httpClient;

    // 构造函数，初始化API密钥和URL
    public ChatClient(String apiKey, String apiUrl) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.httpClient = HttpClient.newHttpClient();
    }

    // 发送聊天请求
    public String sendChatRequest(String model, String prompt, int maxTokens) throws Exception {
        // 构建JSON请求体
        String jsonBody = String.format(
                "{\"model\": \"%s\", \"prompt\": \"%s\", \"max_tokens\": %d}",
                model, prompt, maxTokens
        );

        // 创建HTTP请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        // 发送请求并获取响应
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String responseBody = response.body();

        // 检查响应
        if (statusCode == 200) {
            return responseBody; // 返回成功结果（JSON格式）
        } else {
            throw new Exception("请求失败，状态码: " + statusCode + ", 错误信息: " + responseBody);
        }
    }

    // 主方法测试
    public static void main(String[] args) {
        String apiKey = "sk-358de00627c34f0baf34b327361e41ed"; // 替换为你的DeepSeek API密钥
        String apiUrl = "https://api.deepseek.com/v1/completions"; // DeepSeek API端点
        ChatClient client = new ChatClient(apiKey, apiUrl);

        try {
            String response = client.sendChatRequest("DeepSeek-V3", "你好，世界！", 50);
            System.out.println("响应: " + response);
        } catch (Exception e) {
            System.err.println("错误: " + e.getMessage());
            if (e.getMessage().contains("invalid_request_error")) {
                System.err.println("提示：检查API密钥、模型名称或JSON格式。");
            }
        }
    }
}