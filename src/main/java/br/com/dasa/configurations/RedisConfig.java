package br.com.dasa.configurations;

import org.ff4j.redis.RedisConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import static java.lang.Thread.sleep;

@Configuration
public class RedisConfig {

    private final static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.ssl}")
    private boolean ssl;

    private int retryLimit = 3;

    @Bean
    public RedisConnection redisConnection() throws InterruptedException {

        logger.info("Trying to connect with Redis: {} and port: {} and password: {}", host, port, password);

        var connection = new RedisConnection(host, port, password, ssl);

        try {
            var response = connection.getJedis().ping();
            logger.info("Received from PING : {} from Redis connection.", response);
        } catch (JedisConnectionException e) {
            if (--retryLimit == 0) {
                logger.error("[redis-connection-failed] Connection failed 3 times");
                return connection;
            }

            logger.debug("Retrying after 3 seconds...");
            sleep(3000);

            redisConnection();
        }

        return connection;
    }

    @Bean
    public Jedis jedis(RedisConnection redisConnection) {
        return redisConnection.getJedis();
    }

}
