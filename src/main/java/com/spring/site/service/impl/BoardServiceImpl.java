package com.spring.site.service.impl;

import com.spring.site.domain.Board;
import com.spring.site.domain.Criteria;
import com.spring.site.domain.Member;
import com.spring.site.mapper.BoardMapper;
import com.spring.site.mapper.MemberMapper;
import com.spring.site.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<Board> list(Criteria criteria) throws Exception {
        return boardMapper.list(criteria);
    }

    @Override
    public List<Board> searchList(Member member) throws Exception {
        return boardMapper.searchList(member);
    }

    @Override
    public void insert(Board board) throws Exception {
        boardMapper.insert(board);
    }

    @Override
    public Board detailBoard(int no) throws Exception {
        return boardMapper.detailSearch(no);
    }

    @Override
    public int countBoard() {
        return boardMapper.countBoard();
    }

}
