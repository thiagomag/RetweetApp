package br.com.thiago.retweetbot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "TweetApiV1", url = "https://api.twitter.com")
public interface TwitterClientV1 {

    @PostMapping(value = "/1.1/statuses/retweet/{id}", consumes = "application/json")
    ResponseEntity<String> retweetById(@PathVariable String id,
                                       @RequestHeader("Authorization") String consumerKey);
}
