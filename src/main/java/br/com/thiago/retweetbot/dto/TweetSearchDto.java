package br.com.thiago.retweetbot.dto;

import br.com.thiago.retweetbot.entity.Data;
import br.com.thiago.retweetbot.entity.Meta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TweetSearchDto {

    private List<Data> data;
    private Meta meta;
}