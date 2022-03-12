package com.spring.site.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {
    private int rno;
    private int no;
    private String reply;
    private String writer;
    private String replyDate;
    private String updateDate;

}
