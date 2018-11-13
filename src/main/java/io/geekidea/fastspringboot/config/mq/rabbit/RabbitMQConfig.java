package io.geekidea.fastspringboot.config.mq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *     RabbitMQ配置
 * </p>
 * @author liujixiang
 * @date 2018/11/12
 */
@Configuration
public class RabbitMQConfig {

    @Autowired
    private RabbitProperties rabbitProperties;

    /**
     * 创建默认队列
     */
    @Bean
    public Queue queue(){
        return new Queue(rabbitProperties.getTemplate().getQueue());
    }

    /**
     * 创建默认的Topic交换器
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(rabbitProperties.getTemplate().getExchange());
    }

    /**
     * 使用路由key将队列绑定到交换机上
     */
    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(rabbitProperties.getTemplate().getRoutingKey());
    }

    /**
     * 创建连接工厂
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitProperties.getHost(),rabbitProperties.getPort());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        return connectionFactory;
    }

    /**
     * 创建RabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

}
