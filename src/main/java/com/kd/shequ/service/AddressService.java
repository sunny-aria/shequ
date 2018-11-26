package com.kd.shequ.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kd.shequ.model.Address;

/**
 * 地址管理
 *
 * @author sunny
 * @create 2018/6/22 10:42
 **/
public interface AddressService {
    PageInfo<Address> queryAllAdreeTest(int pageNum);
}
