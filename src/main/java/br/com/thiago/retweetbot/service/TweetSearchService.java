package br.com.thiago.retweetbot.service;

import br.com.thiago.retweetbot.client.TwitterClientV2;
import br.com.thiago.retweetbot.dto.TweetSearchDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class TweetSearchService {

    private final TwitterClientV2 twitterClientV2;
    private final RetweetService retweetService;
    @Value("${oauth.bearerToken}")
    private String token;

    public TweetSearchDto recentSearch(String query) throws IOException, GeneralSecurityException {
        final var bearerToken = "Bearer " + token;
        var response = twitterClientV2.tweetSearch(query, bearerToken).getBody();
        ObjectMapper mapper = new ObjectMapper();
        var tweets = mapper.readValue(response, TweetSearchDto.class);

        retweetService.retweet(tweets);

        return tweets;
    }
}
