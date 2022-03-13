package com.spring.site.service;

import com.spring.site.domain.Member;
import com.spring.site.domain.Reply;

import java.util.List;

public interface ReplyService {
    int add(Reply reply);
    List<Reply> get(int no);
    int modify(Reply reply);
    int remove(int rno);
}
