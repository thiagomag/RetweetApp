package br.com.thiago.retweetbot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

    private Long newestId;
    private Long oldestId;
    private Long resultCount;
    private String nextToken;
}
