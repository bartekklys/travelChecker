package pl.bartekk.travelChecker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

    @Value("${wakacjeUrl}")
    private String wakacjeUrl;

    @Bean
    public WebClient wakacjeWebClient() {
        return createWebClient(wakacjeUrl);
    }

    private WebClient createWebClient(String url) {
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
            .build();
    }
}