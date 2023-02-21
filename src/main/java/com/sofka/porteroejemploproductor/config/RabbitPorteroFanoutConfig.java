package com.sofka.porteroejemploproductor.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitPorteroFanoutConfig {

    @Bean
    Queue apartamento6001Queue() {return new Queue("apartamento6001Queue", false);}

    @Bean
    Queue apartamento6002Queue() {return new Queue("apartamento6002Queue", false);}

    @Bean
    Queue apartamento6003Queue() {return new Queue("apartamento6003Queue", false);}


    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout-exchange");
    }


    @Bean
    Binding apartamento6001Binding(Queue apartamento6001Queue,FanoutExchange exchange){
        return BindingBuilder.bind(apartamento6001Queue).to(exchange);
    }
    @Bean
    Binding apartamento6002Binding(Queue apartamento6002Queue,FanoutExchange exchange){
        return BindingBuilder.bind(apartamento6002Queue).to(exchange);
    }
    @Bean
    Binding apartamento6003Binding(Queue apartamento6003Queue,FanoutExchange exchange){
        return BindingBuilder.bind(apartamento6003Queue).to(exchange);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        return simpleMessageListenerContainer;
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
