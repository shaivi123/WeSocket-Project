package com.springrest.webSocket.controller;

import com.springrest.webSocket.model.Greeting;
import com.springrest.webSocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message){
        try {
            //for waiting the response
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Greeting("Hello,"+
               HtmlUtils.htmlEscape(message.getName()));
    }

}
