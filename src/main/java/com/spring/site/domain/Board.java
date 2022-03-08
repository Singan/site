package com.spring.site.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
    private int no;
    private String title;
    private String content;
    private String file;
    private int writer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
}
