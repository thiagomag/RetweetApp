package br.com.thiago.retweetbot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "TweetSearch", url = "https://api.twitter.com/2/tweets/search/recent?query=")
public interface TweetSearchClient {

    @GetMapping
    ResponseEntity<String> tweetSearch(@RequestParam String query, @RequestHeader("Authorization") String bearerToken);
}
