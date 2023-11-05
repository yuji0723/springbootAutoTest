package com.jin.service.domain.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jin.entity.ProductEntity;
import com.jin.mapper.ProductMapper;
import com.jin.service.domain.ProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 大力pig
 * @since 2023-11-05
 */
@Service
@DS("test2")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity>implements ProductService {
}
