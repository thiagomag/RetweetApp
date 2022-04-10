package br.com.thiago.retweetbot.client;

import br.com.thiago.retweetbot.entity.TweetSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "TweetApiV2", url = "https://api.twitter.com")
public interface TwitterClientV2 {

    @GetMapping("/2/tweets/search/recent?query=")
    TweetSearchResponse tweetSearch(@RequestParam String query, @RequestHeader("Authorization") String bearerToken);
}