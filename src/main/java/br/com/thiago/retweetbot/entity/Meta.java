package br.com.thiago.retweetbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {

    @JsonProperty("newest_id")
    private Long newestId;
    @JsonProperty("oldest_id")
    private Long oldestId;
    @JsonProperty("result_count")
    private Long resultCount;
    @JsonProperty("next_token")
    private String nextToken;
}
