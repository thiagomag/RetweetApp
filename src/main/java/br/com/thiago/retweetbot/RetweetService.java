package br.com.thiago.retweetbot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetweetService {

    private final TweeterClient tweeterClient;
    @Value("${oauth.consumerKey}")
    private String consumerKey;
    @Value("${oauth.consumerSecret}")
    private String consumerSecret;
    @Value("${oauth.accessToken}")
    private String accessToken;
    @Value("${oauth.accessTokenSecret}")
    private String accessTokenSecret;


    public void retweet(TweetSearchDto tweets, String bearerToken) throws JsonProcessingException {

        var userName = "BrazilMemeBot";

        var userResponse = tweeterClient.getUserDataByUserName(userName, bearerToken).getBody();
        ObjectMapper mapper = new ObjectMapper();
        var userData = mapper.readValue(userResponse, User.class);
        var userId = userData.getData().getId();
        var signature = "HMAC-SHA1";

        tweeterClient.retweetById(userId, consumerKey, consumerSecret, accessToken, accessTokenSecret, signature);
    }
}