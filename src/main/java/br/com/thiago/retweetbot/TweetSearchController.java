package br.com.thiago.retweetbot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class TweetSearchController {

    private final TweetSearchService tweetSearchService;

    @GetMapping("/{query}")
    public ResponseEntity<TweetSearchDto> recentSearch(@PathVariable String query) throws IOException {
        return ResponseEntity.ok().body(tweetSearchService.recentSearch(query));
    }
}
