package com.yliad.gateway.config
import io.jsonwebtoken.Jwts
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class AuthorizationHeaderFilter(private val properties: JwtProperties) :
    AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>(Config::class.java) {

    override fun apply(config: Config?): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val request = exchange.request
            if (!request.headers.containsKey("Authorization")){
                return@GatewayFilter onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED)
            }
            val authorizationHeader = request.headers["Authorization"]?.get(0)
            val jwt = authorizationHeader?.replace("Bearer ", "")

            if (!isJwtValid(jwt)){
                return@GatewayFilter onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED)
            }
            chain.filter(exchange)
        }
    }

    private fun isJwtValid(jwt: String?): Boolean {
        val subject = Jwts.parserBuilder().setSigningKey(properties.secret.toByteArray()).build()
            .parseClaimsJws(jwt).body.subject ?: null

        return subject != null
    }

    private fun onError(
        exchange: ServerWebExchange?,
        err: String,
        httpStatus: HttpStatus
    ): Mono<Void>? {
        val response = exchange?.response
        response?.statusCode = httpStatus

        println(err)
        return response?.setComplete()
    }

    companion object Config{
    }

}