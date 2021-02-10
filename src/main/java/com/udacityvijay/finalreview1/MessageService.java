package com.udacityvijay.finalreview1;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//think of a service like a waiter
@Service
public class MessageService {

    private List<ChatMessage> chatMessages;

    public void add(ChatForm chatForm){
        ChatMessage chat = new ChatMessage();
        chat.setUsername(chatForm.getUsername());
        switch(chatForm.getMessageType()){
            case "Say":
                chat.setMessageText(chatForm.getMessage());
                break;
            case "Shout":
                chat.setMessageText(chatForm.getMessage().toUpperCase());
                break;
            case "Whisper":
                chat.setMessageText(chatForm.getMessage().toLowerCase());
                break;
        }
        this.chatMessages.add(chat);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }
}
