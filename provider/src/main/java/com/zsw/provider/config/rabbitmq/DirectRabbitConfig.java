package com.zsw.provider.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zsw
 * @date 2021/3/11 17:42
 * @description :
 * DirectExchange
 * 直连型交换机，根据消息携带的路由键，将消息转发给对应的队列
 */
@Configuration
public class DirectRabbitConfig {
    /**
     * 交换机
     */
    @Bean
    public DirectExchange myDirectExchange() {
        // 参数意义:
        // name: 名称
        // durable: true
        // autoDelete: 自动删除
        return new DirectExchange("myDirectExchange", true, false);
    }

    /**
     * 队列
     */
    @Bean
    public Queue myDirectQueue() {

        return new Queue("myDirectQueue", true);
    }

    /**
     * 绑定 路由
     */
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(myDirectQueue())
                .to(myDirectExchange())
                .with("my.direct.routing");
    }
}
