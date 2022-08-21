package com.webapplication;

import domain.modules.share.Infrastructure.bus.event.RabbitMqEventBus;
import domain.modules.share.domain.bus.event.EventBus;
import domain.modules.users.application.updateuser.UpdateUserUseCase;
import domain.modules.users.application.updateuser.UserPostgrestRepository;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public CachingConnectionFactory connectionFactory(Environment env) {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(env.getProperty("spring.rabbitmq.host"));
        final var port = Integer.valueOf(env.getProperty("spring.rabbitmq.port"));
        connectionFactory.setPort(port);
        connectionFactory.setUsername(env.getProperty("spring.rabbitmq.username"));
        connectionFactory.setPassword(env.getProperty("spring.rabbitmq.password"));
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public EventBus eventBus(final RabbitTemplate template) {
        return new RabbitMqEventBus(template);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(
            EventBus eventBus,
            UserPostgrestRepository userRepository) {
        return new UpdateUserUseCase(eventBus, userRepository);
    }

    @Bean
    public UserPostgrestRepository userPostgrestRepository(JdbcTemplate jdbcTemplate) {
        return new UserPostgrestRepository(jdbcTemplate);
    }

}
