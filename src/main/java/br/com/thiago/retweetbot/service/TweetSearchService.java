package br.com.thiago.retweetbot.service;

import br.com.thiago.retweetbot.client.TwitterClientV2;
import br.com.thiago.retweetbot.entity.TweetSearchResponse;
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

    public TweetSearchResponse recentSearch(String query) throws IOException, GeneralSecurityException {
        final var bearerToken = "Bearer " + token;
        var tweetResponse = twitterClientV2.tweetSearch(query, bearerToken);

        retweetService.retweet(tweetResponse);

        return tweetResponse;
    }
}
