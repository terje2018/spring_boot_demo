package me.terje.spring.restful;

import me.terje.spring.service.HeartBeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heartbeat")
@SpringBootApplication
@ComponentScan({"me.terje.spring.service"})
public class HeartBeatRestFul {
    private static Logger logger = LoggerFactory.getLogger(HeartBeatRestFul.class);
    @Autowired
    private HeartBeatService heartBeatService;

    @GetMapping
    public int beat(){
        int i=0;
        try {
            i =  heartBeatService.beat();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return i;
    }
}
