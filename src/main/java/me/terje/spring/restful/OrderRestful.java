package me.terje.spring.restful;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.terje.spring.model.Order;
import me.terje.spring.service.OrderSerivice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/order")
@SpringBootApplication
@ConfigurationProperties(prefix="config-p")
@ComponentScan({"me.terje.spring.service"})
public class OrderRestful {
    private static Logger logger = LoggerFactory.getLogger(OrderRestful.class);
    private String param1;
    private int param2;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    @Autowired
    private OrderSerivice orderSerivice;

    @PostMapping
    public int post(@RequestParam("post_str") String postStr){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order order = objectMapper.readValue(postStr,Order.class);
            return orderSerivice.save(order);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return 0;
    }

    @GetMapping
    public String get(@RequestParam("id") int id){
        logger.info("start...");
        try{
            Order order = orderSerivice.get(id);
            if(order == null){
                logger.warn("object of id is null~");
                return "{'error':'000001'}";
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(order);
            logger.info("json_str: "+jsonStr);
            return jsonStr;
        } catch (JsonProcessingException e){
            logger.error(e.getMessage(),e);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return "{'error':'000000'}";
    }

    @PutMapping
    public int update(@RequestParam("put_str") String putStr){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order order = objectMapper.readValue(putStr,Order.class);
            return orderSerivice.update(order);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return 0;
    }

    @DeleteMapping
    public int delete(@RequestParam("id") int id){
        try {
            return orderSerivice.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return 0;
    }


}
