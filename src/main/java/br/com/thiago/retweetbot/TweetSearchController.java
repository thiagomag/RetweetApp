package br.com.thiago.retweetbot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class TweetSearchController {

    private final TweetSearchService tweetSearchService;

    @GetMapping("/{query}")
    public ResponseEntity<TweetSearchDto> recentSearch(@PathVariable String query) throws IOException, GeneralSecurityException {
        return ResponseEntity.ok().body(tweetSearchService.recentSearch(query));
    }
}
