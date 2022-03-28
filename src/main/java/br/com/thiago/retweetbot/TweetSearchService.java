package br.com.thiago.retweetbot;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TweetSearchService {

    private final TweetSearchClient tweetSearchClient;
    private final RetweetService retweetService;

    public TweetSearchDto recentSearch(String query, String bearerToken) throws IOException {
        var response = tweetSearchClient.tweetSearch(query, bearerToken).getBody();
        ObjectMapper mapper = new ObjectMapper();
        var tweets = mapper.readValue(response, TweetSearchDto.class);

        retweetService.retweet(tweets);

        return tweets;
    }
}
