package com.udacityvijay.finalreview1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    //the service helps manage the data from the repository
    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("chats",this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    public String postChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        messageService.add(chatForm);
        model.addAttribute("chats", this.messageService.getChatMessages());
        return "chat";
    }
}
