package io.geekidea.fastspringboot.example.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     消费者
 * </p>
 * @author liujixiang
 * @since 2018/11/12
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "${spring.rabbitmq.template.queue}")
    public void process(String message){
        log.debug("process message {}",message);
    }

}
