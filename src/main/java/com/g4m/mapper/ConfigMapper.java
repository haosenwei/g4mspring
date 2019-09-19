package com.g4m.mapper;


import com.g4m.base.BaseMapper;
import com.g4m.entity.Config;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:02
 */
public interface ConfigMapper extends BaseMapper<Config> {
    Config getByCode(String code);
}
