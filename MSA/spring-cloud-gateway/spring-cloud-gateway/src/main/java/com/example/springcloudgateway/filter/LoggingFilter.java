package com.example.springcloudgateway.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {
    public LoggingFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain)->{
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpResponse response = exchange.getResponse();
                log.info("Logging PRE base Message : request id -> {}", config.getBaseMessage());
                if(config.isPreLogger()) {
                    log.info("global Filter Start : request id -> {}", request.getId());
                }
                //Custom Post Filter
                return chain.filter(exchange).then(Mono.fromRunnable(()->{
                    if(config.isPostLogger()) {
                        log.info("Logging Filter End : request id -> {}", request.getId());
                    }
                }));
        }, Ordered.LOWEST_PRECEDENCE);
        //HIGHEST
        //필터의 우선순위가 가장 최상위로 됨
        return filter;
    }
    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

}
