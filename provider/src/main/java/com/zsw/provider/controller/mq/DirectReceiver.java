package com.zsw.provider.controller.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zsw
 * @date 2021/3/11 17:54
 * @description :  创建消息处理者DirectReceiver
 */
@Component
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "myDirectQueue") // 队列
    public void process(String msg) {
        System.out.println("消费到消息"+msg);
    }

    // 处理三个队列的消息
    @RabbitHandler
    @RabbitListener(queues = "fanoutQueueA")
    public void processA(String msg) {
        System.out.println("fanoutQueueA " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanoutQueueB")
    public void processB(String msg) {
        System.out.println("fanoutQueueB " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanoutQueueC")
    public void processC(String msg) {
        System.out.println("fanoutQueueC " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "myTopicQueue_01")
    public void process_01(String msg) {
        System.out.println("myTopicQueue_01 " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "myTopicQueue_02")
    public void process_02(String msg) {
        System.out.println("myTopicQueue_02 " + msg);
    }
}
