package com.yliad.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean

//@Configuration
class FilterConfig {

    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder) : RouteLocator =
        builder.routes {
            route {
                path("/first-service/**")
                filters {
                    addRequestHeader("first-request", "first-request-header")
                    addResponseHeader("first-response", "first-response-header")
                }
                uri("http://127.0.0.1:8081")
            }

            route {
                path("/second-service/**")
                filters {
                    addRequestHeader("second-request", "second-request-header")
                    addResponseHeader("second-response", "second-response-header")
                }
                uri("http://127.0.0.1:8082")
            }
        }

}