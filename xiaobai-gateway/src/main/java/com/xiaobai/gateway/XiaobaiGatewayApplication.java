package com.xiaobai.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;

@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class XiaobaiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaobaiGatewayApplication.class, args);
    }

    /**
     * 创建用户唯一表识、，使用IP作为唯一标识，根据IP进行限流
     */

    @Bean(name = "ipKeyResolver")
    public KeyResolver userKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //获取用户ip
                String hostString = exchange.getRequest().getRemoteAddress().getHostString();
              //  System.out.println("用户请求的ip" + hostString);
                return Mono.just(hostString);
            }
        };

    }
}