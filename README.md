# Read Me

The original idea is from  
https://medium.com/@vino7tech/understanding-cors-and-csrf-in-spring-boot-7a2d92259592

Also see  
https://medium.com/@sallu-salman/cross-origin-resource-sharing-cors-in-spring-boot-applications-116163a88adc

Project that does not use spring security example

```
@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins("*"); // Replace with your allowed origins
        configuration.setAllowedMethods("*"); // Allow all HTTP methods
        configuration.setAllowedHeaders("*"); // Allow all headers
        configuration.setAllowCredentials(true); // Allow credentials (e.g., cookies)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(corsConfigurationSource());
    }
}
```

Project that does not use spring security example

```
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS on all paths
                .allowedOrigins("http://localhost:3000") // Allow specific origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow specific methods
                .allowedHeaders("Authorization", "Content-Type", "Cache-Control") // Define specific headers
                .allowCredentials(true); // Allow credentials (e.g., cookies)
    }
}
```