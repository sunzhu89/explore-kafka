package com.rpr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;
    @RequestMapping(method = RequestMethod.GET, value = "/gen")
    public void generateEvents(){
        new Random().ints(10,1,100)
                .forEach(i->producerService.sendMessage("This is message with number "+i));
    }
}
