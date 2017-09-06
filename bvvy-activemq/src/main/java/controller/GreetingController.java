package controller;

import hello.Greeting;
import hello.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by bvvy on 2017/9/3.
 */
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException {

        Thread.sleep(1000);
        return new Greeting("hello" + helloMessage.getName() + " !");
    }



}
