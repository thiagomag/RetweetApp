package br.com.thiago.retweetbot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TweetSearchService {

    private final TweetSearchClient tweetSearchClient;

    public TweetSearchDto recentSearch(String query, String bearerToken) {
        return tweetSearchClient.tweetSearch(query, bearerToken);
    }
}
