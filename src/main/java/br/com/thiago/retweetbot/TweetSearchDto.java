package br.com.thiago.retweetbot;

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

    private List<Data> dataList;
    private Meta meta;
}