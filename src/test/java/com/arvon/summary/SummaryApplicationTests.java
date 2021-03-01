package com.arvon.summary;


import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("demo1")
class SummaryApplicationTests {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testRocketMq() {
        Message message = new Message();
        message.setBody("同步消息".getBytes());
        SendResult sendResult = rocketMQTemplate.syncSend("SYSNC-TOPIC", message);
        // 同步消息发送成功会有一个返回值，我们可以用这个返回值进行判断和获取一些信息
        System.out.println(sendResult);
    }

}
