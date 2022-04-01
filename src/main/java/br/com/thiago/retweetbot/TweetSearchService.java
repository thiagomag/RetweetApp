package br.com.thiago.retweetbot;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TweetSearchService {

    private final TweeterClient tweeterClient;
    private final RetweetService retweetService;
    @Value("${oauth.bearerToken}")
    private String token;

    public TweetSearchDto recentSearch(String query) throws IOException {
        final var bearerToken = "Bearer " + token;
        var response = tweeterClient.tweetSearch(query, bearerToken).getBody();
        ObjectMapper mapper = new ObjectMapper();
        var tweets = mapper.readValue(response, TweetSearchDto.class);

        retweetService.retweet(tweets, bearerToken);

        return tweets;
    }
}
