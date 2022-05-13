package shop.member.main.security.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class PasswordConfig {

    @Bean
    fun passwordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}