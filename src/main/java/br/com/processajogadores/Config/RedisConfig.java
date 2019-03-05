package br.com.processajogadores.Config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

//    //Abrir a conection com o Redis
//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        return new LettuceConnectionFactory();
//    }
//
//    //Template para salvar cliente no redis
//    @Bean
//    public RedisTemplate<String, Cliente> clienteRedisTemplate(RedisConnectionFactory connectionFactory) {
//        return redisTemplate(connectionFactory,Cliente.class);
//    }
//
//    //Instanciando template
//    public <T>RedisTemplate<String, T> redisTemplate(RedisConnectionFactory connectionFactory, Class<T> type) {
//        RedisTemplate<String, T> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new Jackson2JsonRedisSerializer<T>(type	));
//        return template;
//
//    }
}
