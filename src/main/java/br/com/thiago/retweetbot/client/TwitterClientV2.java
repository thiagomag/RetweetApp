package br.com.thiago.retweetbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "TweetApiV2", url = "https://api.twitter.com")
public interface TwitterClientV2 {

    @GetMapping("/2/tweets/search/recent?query=")
    ResponseEntity<String> tweetSearch(@RequestParam String query, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/2/users/by/username/{userName}")
    ResponseEntity<String> getUserDataByUserName(@PathVariable String userName, @RequestHeader("Authorization") String bearerToken);
}