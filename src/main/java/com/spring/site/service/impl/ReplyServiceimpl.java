package com.spring.site.service.impl;



import com.spring.site.domain.Reply;
import com.spring.site.mapper.ReplyMapper;
import com.spring.site.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReplyServiceimpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public int add(Reply reply) {
        return replyMapper.insert(reply);
    }

    @Override
    public Reply get(int rno) {
        return replyMapper.read(rno);
    }

    @Override
    public int modify(Reply reply) {
        return replyMapper.update(reply);
    }

    @Override
    public int remove(int rno) {
        return replyMapper.delete(rno);
    }
}
