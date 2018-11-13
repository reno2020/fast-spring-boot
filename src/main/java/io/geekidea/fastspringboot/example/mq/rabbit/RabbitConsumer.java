package io.geekidea.fastspringboot.example.mq.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     RabbitMQ消费者
 * </p>
 * @author liujixiang
 * @since 2018/11/12
 */
@Component
@Slf4j
@AutoConfigureAfter(RabbitProperties.class)
public class RabbitConsumer {
    @RabbitListener(queues = "${spring.rabbitmq.template.queue}")
    public void process(String message){
        log.debug("process message {}",message);
    }

}
