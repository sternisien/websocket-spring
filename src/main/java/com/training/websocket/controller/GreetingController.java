package com.training.websocket.controller;

import com.training.websocket.model.Greeting;
import com.training.websocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topics/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new Greeting("Hello " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
    }
}
