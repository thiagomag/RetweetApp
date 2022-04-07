package br.com.thiago.retweetbot.controller;

import br.com.thiago.retweetbot.dto.TweetSearchDto;
import br.com.thiago.retweetbot.service.TweetSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class TweetSearchController {

    private final TweetSearchService tweetSearchService;

    @GetMapping
    public ResponseEntity<TweetSearchDto> recentSearch(@PathParam("query") String query) throws IOException, GeneralSecurityException {
        return ResponseEntity.ok().body(tweetSearchService.recentSearch(query));
    }
}
