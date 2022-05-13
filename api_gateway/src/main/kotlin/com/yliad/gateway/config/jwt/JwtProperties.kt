package com.yliad.gateway.config.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "token")
data class JwtProperties (
    val accessTokenExpirationTime : Long,
    val refreshTokenExpirationTime : Long,
    val secret : String
)
