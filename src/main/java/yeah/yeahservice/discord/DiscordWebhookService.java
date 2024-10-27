package yeah.yeahservice.discord;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiscordWebhookService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${discord.webhook.url}")
    private String discordWebhookUrl;

    public void sendWebhookMessage(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> payload = new HashMap<>();
        payload.put("content", message); // Discord로 보낼 메시지 설정

        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

        // Discord 웹훅 URL로 POST 요청
        restTemplate.exchange(discordWebhookUrl, HttpMethod.POST, request, String.class);
    }
}
