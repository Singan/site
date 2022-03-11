package com.spring.site.mapper;


import com.spring.site.domain.Board;
import com.spring.site.domain.Criteria;
import com.spring.site.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BoardMapper {

    String listSelect = "select * from board order by no ";
    @Options(useGeneratedKeys = true, keyProperty = "no")
    @Insert("INSERT INTO board(title,content,writer,date,file) VALUES(#{title}, #{content},#{writer},#{date},#{file})")
    int insert(Board board) throws Exception;
    @Select(listSelect + " limit ${recordsStart},${recordsPerPage}")
    List<Board> list(Criteria criteria) throws Exception;
    @Select(listSelect+"where = #{id}")
    List<Board> searchList(Member member);
    @Select("SELECT * FROM board where no = #{no}")
    Board detailSearch(int no);

    @Select("SELECT count(*) FROM board")
    int countBoard();
}
