package com.kd.shequ.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kd.shequ.mapper.AddressMapper;
import com.kd.shequ.model.Address;
import com.kd.shequ.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地址管理实现类
 *
 * @author sunny
 * @create 2018/6/22 10:43
 **/
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public PageInfo<Address> queryAllAdreeTest(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Address> list = addressMapper.queryAllList();
        PageInfo page = new PageInfo(list);
        return page;
    }
}
