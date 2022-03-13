package com.spring.site.service;

import com.spring.site.domain.Board;
import com.spring.site.domain.Criteria;
import com.spring.site.domain.Member;

import java.util.List;

public interface BoardService {
    List<Board> list(Criteria criteria) throws Exception;
    List<Board> searchList(Member member) throws Exception;
    void insert(Board board) throws Exception;
    Board detailBoard(int no) throws Exception;
    int countBoard();
}
