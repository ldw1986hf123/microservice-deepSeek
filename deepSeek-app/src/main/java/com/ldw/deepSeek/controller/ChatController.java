//package com.ldw.deepSeek.controller;
//
//import org.springframework.ai.chat.model.ChatModel;
//import org.springframework.ai.chat.prompt.Prompt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ChatController {
//
//    @Autowired
//    private ChatModel chatModel;
//
//    @GetMapping("/chat")
//    public String chat(@RequestParam String message) {
//        Prompt prompt = new Prompt(message);
//        return chatModel.call(prompt).getResult().getOutput().getText();
//    }
//}