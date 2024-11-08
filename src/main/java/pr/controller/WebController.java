package pr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pr.config.MessageConsumer;
import pr.config.MessageProducer;
import pr.model.User;

@RequestMapping("/v1")
@RestController
//@SecurityRequirement(name = "Authorization")
public class WebController {

    @Autowired
    MessageProducer producer;

    @Autowired
    MessageConsumer consumer;
    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@Validated @RequestBody User userInfo)
    {
     producer.sendMessage("Topic-A",userInfo);
     return ResponseEntity.status(HttpStatus.OK).body("Message sent");
    }

}
