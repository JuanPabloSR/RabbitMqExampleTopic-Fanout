//package com.sofka.porteroejemploproductor.config;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.amqp.support.converter.MessageConverter;
//
//@Configuration
//public class RabbitPorteroTopicConfig {
//
//    @Bean
//    Queue apartamento601Queue() {return new Queue("apartamento601Queue", false);}
//
//    @Bean
//    Queue apartamento602Queue() {return new Queue("apartamento602Queue", false);}
//
//    @Bean
//    Queue apartamento603Queue() {return new Queue("apartamento603Queue", false);}
//
//    @Bean
//    TopicExchange topicExchange(){
//        return new TopicExchange("topic-exchange");
//    }
//
//
//    @Bean
//    Binding apartamento601Binding(Queue apartamento601Queue, TopicExchange topicExchange){
//        return BindingBuilder.bind(apartamento601Queue).to(topicExchange).with("queue.apartamento601");
//    }
//    @Bean
//    Binding apartamento602Binding(Queue apartamento602Queue, TopicExchange topicExchange){
//        return BindingBuilder.bind(apartamento602Queue).to(topicExchange).with("queue.apartamento602");
//    }
//    @Bean
//    Binding apartamento603Binding(Queue apartamento603Queue, TopicExchange topicExchange){
//        return BindingBuilder.bind(apartamento603Queue).to(topicExchange).with("queue.apartamento603");
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
//        return simpleMessageListenerContainer;
//    }
//
//    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }
//
//}
