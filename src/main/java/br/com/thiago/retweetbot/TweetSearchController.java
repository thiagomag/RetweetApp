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

    @GetMapping
    public ResponseEntity<TweetSearchDto> recentSearch(@RequestBody RequestDto requestDto) throws IOException {
        return ResponseEntity.ok().body(tweetSearchService.recentSearch(requestDto.query, requestDto.getBearerToken()));
    }
}
