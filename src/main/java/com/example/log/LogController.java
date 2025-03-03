package com.example.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/logger")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    @GetMapping("/log")
    String getLog(){
        logger.debug("this is a debug log message..");
        logger.info("this is a info log message");
        logger.warn("this is a warn log message");
        logger.error("this is a error log message");

        try{
            throw  new RuntimeException("Hello...I'm a runtime exception");
        }catch (RuntimeException e){
            logger.error("Runtime exception :{}", e.getMessage());
        }
        return "Log printedd";
    }
}
