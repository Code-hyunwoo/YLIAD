package com.yliad.gateway.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Cors 관련 설정 클래스
 */
@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("http://127.0.0.1:3000");
    config.addAllowedOrigin("https://k6a308.p.ssafy.io");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    config.setAllowedOriginPatterns(Collections.singletonList("*"));
    config.setAllowCredentials(true);
    config.addExposedHeader("authorization");
    config.addExposedHeader("refreshToken");
    config.setMaxAge(3600L);
    source.registerCorsConfiguration("/api/**", config);
    return new CorsFilter(source);
  }

}
