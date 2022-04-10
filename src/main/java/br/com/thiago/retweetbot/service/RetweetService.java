package br.com.thiago.retweetbot.service;

import br.com.thiago.retweetbot.entity.TweetSearchResponse;
import com.github.redouane59.twitter.TwitterClient;
import com.github.redouane59.twitter.signature.TwitterCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetweetService {

    @Value("${oauth.apiKey}")
    private String apiKey;
    @Value("${oauth.apiSecretKey}")
    private String apiSecretKey;
    @Value("${oauth.accessToken}")
    private String accessToken;
    @Value("${oauth.accessTokenSecret}")
    private String accessTokenSecret;


    public void retweet(TweetSearchResponse tweets) {

        final var credentials = TwitterCredentials.builder()
                .accessToken(accessToken)
                .accessTokenSecret(accessTokenSecret)
                .apiKey(apiKey)
                .apiSecretKey(apiSecretKey)
                .build();

        TwitterClient twitterClient = new TwitterClient(credentials);

        tweets.getData().forEach(
                data -> twitterClient.retweetTweet(data.getId().toString())
        );
    }
}