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

    public void sendWebhookMessage(String email, String storeName, String storeType, String location, String bestMenu, String price, String target, String mood, String referrer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String message = String.format(
                "✨ 손님의 발견 요청이 추가되었어요!\n\n" +
                        "✉️ ***%s***\n\n" +
                        "가게 정보\n" +
                        "- 이름: %s\n" +
                        "- 종류: %s\n" +
                        "- 위치: %s\n" +
                        "- 대표 메뉴: %s\n" +
                        "- 가격대: %s\n" +
                        "- 타겟: %s\n" +
                        "- 분위기: %s\n" +
                        "- referrer: %s",
                email, storeName, storeType, location, bestMenu, price, target, mood, referrer
        );

        Map<String, String> payload = new HashMap<>();
        payload.put("content", message);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

        restTemplate.exchange(discordWebhookUrl, HttpMethod.POST, request, String.class);
    }
}
