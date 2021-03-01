package com.arvon.summary.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Arvon
 * @date 2021/2/26 20:09
 */
@Component
@RocketMQMessageListener(topic = "sync-topic", consumerGroup = "consumer-demo1")
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("收到： " + s);
    }
}
