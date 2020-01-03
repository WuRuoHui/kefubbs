package com.wu.kefubbs.mapper;

import com.wu.kefubbs.pojo.GameContact;
import com.wu.kefubbs.pojo.GameContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameContactMapper {
    long countByExample(GameContactExample example);

    int deleteByExample(GameContactExample example);

    int insert(GameContact record);

    int insertSelective(GameContact record);

    List<GameContact> selectByExample(GameContactExample example);

    int updateByExampleSelective(@Param("record") GameContact record, @Param("example") GameContactExample example);

    int updateByExample(@Param("record") GameContact record, @Param("example") GameContactExample example);
}