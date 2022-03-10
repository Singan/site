package com.spring.site.service;

import com.spring.site.domain.Board;
import com.spring.site.domain.Member;

import java.util.List;

public interface BoardService {
    List<Board> list() throws Exception;
    List<Board> searchList(Member member) throws Exception;
    void insert(Board board) throws Exception;
    Board detailSearch(int no) throws Exception;
}
