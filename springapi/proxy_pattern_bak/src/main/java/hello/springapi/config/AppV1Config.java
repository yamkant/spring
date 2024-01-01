package hello.springapi.config;

import hello.springapi.app.v1.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppV1Config {

    @Bean
    public OrderControllerV1 orderControllerV1() {
        log.info("HERE IN ORDER CONTROLLER V1==============================");
        return (OrderControllerV1) new OrderControllerV1Impl(orderServiceV1());
    }

    @Bean
    public OrderServiceV1 orderServiceV1() {
        log.info("HERE IN ORDER SERVICE V1==============================");
        return new OrderServiceV1Impl(orderRepositoryV1());
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1() {
        log.info("HERE IN ORDER REPOSITORY V1==============================");
        return new OrderRepositoryV1Impl();
    }
}
