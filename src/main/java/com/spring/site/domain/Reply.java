package com.spring.site.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {
    private int rno;
    private int no;
    private String reply;
    private String writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String replyDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateDate;

}
