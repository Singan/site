package com.spring.site.service;

import com.spring.site.domain.Board;
import com.spring.site.domain.Member;

import java.util.List;

public interface BoardService {
    List<Board> list() throws Exception;
}
