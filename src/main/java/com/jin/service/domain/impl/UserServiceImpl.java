package com.jin.service.domain.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.jin.entity.UserEntity;
import com.jin.mapper.UserMapper;
import com.jin.service.domain.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 大力pig
 * @since 2023-11-02
 */
@Service
@DS("test")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
