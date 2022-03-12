package com.spring.site.mapper;


import com.spring.site.domain.Board;
import com.spring.site.domain.Member;
import com.spring.site.domain.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ReplyMapper {

    @Options(useGeneratedKeys = true, keyProperty = "rno")
    @Insert("INSERT INTO reply(rno,no,reply,writer) VALUES(#{rno}, #{no},#{reply},#{writer})")
    int insert(Reply reply);
    @Select("SELECT * FROM reply where NO = #{no}")
    List<Reply> read(int bno);
    @Update("UPDATE * FROM reply SET reply = #{reply} where rno = #{rno}")
    int update(Reply reply);
    @Delete("DELETE * FROM reply where rno = #{rno}")
    int delete(int rno);
}
