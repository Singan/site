package com.spring.site.mapper;


import com.spring.site.domain.Board;
import com.spring.site.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BoardMapper {

    @Options(useGeneratedKeys = true, keyProperty = "no")
    @Insert("INSERT INTO  member(id, pw, name) VALUES(#{id}, #{pw},#{name})")
    int insert(Board board) throws Exception;
    @Select("SELECT * FROM board")
    List<Board> list() throws Exception;
    @Select("SELECT * FROM board where id = #{id}")
    Member selectOne(Board userId);


}
