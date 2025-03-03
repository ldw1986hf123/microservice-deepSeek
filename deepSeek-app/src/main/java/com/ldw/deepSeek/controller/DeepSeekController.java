//package com.ldw.deepSeek.controller;
//
//import org.apache.logging.log4j.message.Message;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/ai")
//public class DeepSeekController {
//
//    private final ChatClient chatclient;
//
//    // 构造方法，用于构造chatclient 实例
//    public DeepSeekController(ChatClient.Builder chatClientBuilder) {
//        this.chatclient = chatClientBuilder.build();
//    }
//
//
//    @GetMapping("/chat")
//    public String chat(@RequestParam(value = "message") String message) {
//        return chatclient.prompt(message).call().content();
//    }
//}