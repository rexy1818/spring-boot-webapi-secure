package bo.edu.devsecops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    // Permite explícitamente la ruta de administración con el prefijo /api/ y productos
                    .requestMatchers("/api/admin/**", "/admin/**", "/products/**", "/api/products/**").permitAll()
                    .anyRequest().authenticated()
                )
                .build();
    }
}
