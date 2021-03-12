package com.zsw.provider.controller.mq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @date 2021/3/11 17:48
 * @description : 测试rabbitmq
 */
@RestController
@Api(" Rabbitmq")
public class RabbitMqController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ApiOperation("发送消息到消息队列 DirectExchange模式")
    @PostMapping("/send")
    public String send() {
        String msg = "hello";
        rabbitTemplate.convertAndSend("myDirectExchange", "my.direct.routing", msg); // 指定 交换机和路由 发送到 myDirectQueue 队列上
        return "success";
    }

    /**
     * 创建多个队列绑定到扇形交换机，生产者发送一次消息，可以观察到多个处理者都收到了消息
     * @return
     */
    @ApiOperation("FanoutRabbitConfig 模式")
    @PostMapping("/sendByFanout")
    public String sendByFanout() {

        String msg = "hello fanout";
        rabbitTemplate.convertAndSend("fanoutExchange", null, msg);

        return "success";
    }

    /**
     * 创建两个队列，并使用通配符绑定到主题交换机
     */
    @GetMapping("/sendByTopic")
    public String sendByTopic() {

        String msg = "hello topic";
        rabbitTemplate.convertAndSend("myTopicExchange", "topic.01", msg + " topic.01");
        rabbitTemplate.convertAndSend("myTopicExchange", "topic.02", msg + " topic.02");

        return "success";
    }

}
