package com.g4m.mapper;


import com.g4m.base.BaseMapper;
import com.g4m.entity.Video;

import java.util.List;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 15:02
 */
public interface VideoMapper extends BaseMapper<Video> {

    List<Video> getAvilableList();

    Integer updateCount(Long id);
}
