package com.example.ordersmicroservice.controller;

import com.example.ordersmicroservice.dto.OrderDto;
import com.example.ordersmicroservice.messagequeue.KafkaProducer;
import com.example.ordersmicroservice.messagequeue.OrderProducer;
import com.example.ordersmicroservice.repository.OrderEntity;
import com.example.ordersmicroservice.service.OrderService;
import com.example.ordersmicroservice.vo.RequestOrder;
import com.example.ordersmicroservice.vo.ResponseOrder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order-service")
@Slf4j
public class OrderController {
    Environment env;
    OrderService orderService;
    KafkaProducer kafkaProducer;
    OrderProducer orderProducer;
    @Autowired
    public OrderController(Environment env, OrderService orderService, KafkaProducer kafkaProducer,OrderProducer orderProducer) {
        this.env = env;
        this.orderService = orderService;
        this.kafkaProducer = kafkaProducer;
        this.orderProducer = orderProducer;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Order Service on Port %s",
                env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable("userId") String userId,
                                                     @RequestBody RequestOrder orderDetails){
        log.info("Before added orders data");
        ModelMapper mapper = new ModelMapper();
        /* ModelMapper 란 ? 서로 다른 Object간의 필드 값을 자동으로 mapping해주는 library
        * 앤티티와 DTO간에 변환 시 자동으로 Object를 매핑시켜주는 library
        * */
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
        orderDto.setUserId(userId);
        /* DTO 란 ? 데이터 전송 객체
        * 웹 서비스의 클라이언트와 서버, 더 자세히는 클라이언트와 서버의 서비스 계층 사이에서 교환되는 데이터를 담는 그릇
        * Dto 클래스는 클라이언트의 Request_body에 있는 Entity의 필드들을 담아 다음 로직(저장, 수정 등)을 처리하는 곳으로 데이터를 넘겨준다.
        * 반대로 서버쪽에서 클라이언트 쪽으로 응답(Response)을 보낼 때도 이런 DTO 클래스를 이용하면 된다.
        * Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이다.
        * */
        // jpa
//        OrderDto createOrder = orderService.createOrder(orderDto);
//        ResponseOrder responseOrder = mapper.map(createOrder, ResponseOrder.class);

        // kafka
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());

        // send this order to kafka
        kafkaProducer.send("example-catalog-topic", orderDto);
        orderProducer.send("orders", orderDto);


        ResponseOrder responseOrder = mapper.map(orderDto, ResponseOrder.class);
        log.info("After added orders data");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) throws Exception{
        log.info("Before retrieve orders data");
        Iterable<OrderEntity> orderList = orderService.getOrdersByUserId(userId);

        List<ResponseOrder> result = new ArrayList<>();
        orderList.forEach(v ->{
            result.add(new ModelMapper().map(v, ResponseOrder.class));
        });

        try{
            Thread.sleep(1000);
            throw new Exception("장애발생");
        }catch (InterruptedException ex){
            log.warn(String.valueOf(ex));
        }

        log.info("After retrieve orders data");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
