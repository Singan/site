package com.spring.site.service;

import com.spring.site.domain.Reply;

public interface ReplyService {
    int add(Reply reply);
    Reply get(int rno);
    int modify(Reply reply);
    int remove(int rno);
}
