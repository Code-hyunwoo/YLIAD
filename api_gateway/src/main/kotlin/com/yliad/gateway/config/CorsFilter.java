package com.yliad.gateway.config;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.config.GlobalCorsProperties;
import org.springframework.cloud.gateway.handler.FilteringWebHandler;
import org.springframework.cloud.gateway.handler.RoutePredicateHandlerMapping;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties("spring.cloud.gateway.globalcors")
public class CorsFilter {

  private final Map<String, CorsConfiguration> corsConfigurations = new LinkedHashMap<>();

  public Map<String, CorsConfiguration> getCorsConfigurations() {
    return corsConfigurations;
  }
  
  @Bean
  @Primary
  public RoutePredicateHandlerMapping passCorsRoutePredicateHandlerMapping(
      FilteringWebHandler webHandler, RouteLocator routeLocator,
      GlobalCorsProperties globalCorsProperties, Environment environment) {
    return new PassCorsRoutePredicateHandlerMapping(webHandler, routeLocator,
        globalCorsProperties, environment);
  }
}