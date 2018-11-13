package io.geekidea.fastspringboot.example.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     Kafka消费者
 * </p>
 * @author liujixiang
 * @since 2018/11/13
 */
@Component
@Slf4j
@AutoConfigureAfter(KafkaProperties.class)
public class KafkaConsumer {
    public KafkaConsumer(){
        System.out.println("init..........");
    }
    @KafkaListener(topics = {"${spring.kafka.template.default-topic}"})
    public void process(String message){
        log.debug("process message {}",message);
    }

}
