package br.com.thiago.retweetbot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class TweetSearchController {

    private final TweetSearchService tweetSearchService;

    @GetMapping
    public ResponseEntity<TweetSearchDto> recentSearch(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok().body(tweetSearchService.recentSearch(requestDto.query, requestDto.getBearerToken()));
    }
}
