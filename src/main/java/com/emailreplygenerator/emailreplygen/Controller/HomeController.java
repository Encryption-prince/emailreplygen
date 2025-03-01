package com.emailreplygenerator.emailreplygen.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")

public class HomeController {

    @GetMapping({"/","/home"})
    public ResponseEntity<String> greetMssg(){
        return new ResponseEntity<>("Hellow World", HttpStatus.OK);
    }
}
