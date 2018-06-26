package com.softbreezee.miniprogram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {


    @GetMapping(value = "/hh")
    public String start() {
        return "ssssss";
    }

}
