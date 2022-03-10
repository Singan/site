package com.spring.site.mapper;


import com.spring.site.domain.Board;
import com.spring.site.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BoardMapper {

    String listSelect = "select no,writer,date,title from board ";
    @Options(useGeneratedKeys = true, keyProperty = "no")
    @Insert("INSERT INTO board(title,content,writer,date,file) VALUES(#{title}, #{content},#{writer},#{date},#{file})")
    int insert(Board board) throws Exception;
    @Select(listSelect)
    List<Board> list() throws Exception;
    @Select(listSelect+"where = #{id}")
    List<Board> searchList(Member member);
    @Select("SELECT * FROM board where no = #{no}")
    Board detailSearch(int no);

}
