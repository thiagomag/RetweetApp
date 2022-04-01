package br.com.thiago.retweetbot;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TweetSearchService {

    private final TweeterClient tweeterClient;
    private final RetweetService retweetService;

    public TweetSearchDto recentSearch(String query, String bearerToken) throws IOException {
        var response = tweeterClient.tweetSearch(query, bearerToken).getBody();
        ObjectMapper mapper = new ObjectMapper();
        var tweets = mapper.readValue(response, TweetSearchDto.class);

        retweetService.retweet(tweets, bearerToken);

        return tweets;
    }
}
