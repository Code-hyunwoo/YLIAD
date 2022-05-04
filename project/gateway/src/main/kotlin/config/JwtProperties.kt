package project.gateway.main.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "token")
data class JwtProperties (
    val expirationTime : String,
    val secret : String
)