package me.terje.spring.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.terje.spring.model.Item;
import me.terje.spring.model.Logistics;
import me.terje.spring.model.Order;
import me.terje.spring.restful.OrderRestful;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderRestful.class)
public class OrderTest {
    @Autowired
    private OrderRestful restful;

    @Test
    public void testPost() throws JsonProcessingException {
        Order order = new Order();
        order.setCode("code_123456");
        order.setCustomerId(76543);
        Logistics lg = new Logistics();
        lg.setCompanyName("company01");
        lg.setDistance(666);
        lg.setStartCity("start01");
        lg.setTargetCity("target01");
        order.setLogistics(lg);
        Item item01 = new Item();
        item01.setCode("item_code_001");
        item01.setName("item01");
        item01.setProductDate(new Date());

        Item item02 = new Item();
        item02.setCode("item_code_002");
        item02.setName("item02");
        item02.setProductDate(new Date());

        List<Item> list = new ArrayList<Item>();
        list.add(item01);
        list.add(item02);
        order.setItems(list);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(order);
        System.out.println(restful.post(jsonStr));
    }
    @Test
    public void testGet(){
        System.out.println(restful.get(13));
    }

    @Test
    public void testUpate() throws IOException {
        String jsonStr = restful.get(13);
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(jsonStr,Order.class);
        order.setPrice(666777888);
        order.getLogistics().setDistance(999888);
        order.getItems().get(0).setName("update_name666");

        String jsonStrUpdate = objectMapper.writeValueAsString(order);

        restful.update(jsonStrUpdate);
    }

    @Test
    public void testDelete(){
        System.out.println(restful.delete(2));
    }

}
