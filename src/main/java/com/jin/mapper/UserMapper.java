package com.jin.mapper;

import com.jin.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 大力pig
 * @since 2023-11-02
 */

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
