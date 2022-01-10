package com.hui.service.impl;

import com.hui.mapper.AccountBookMapper;
import com.hui.pojo.AccountBook;
import com.hui.service.AccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBookImpl implements AccountBookService {

    @Autowired
    private AccountBookMapper bookMapper;

    @Override
    public List<AccountBook> queryAccountBook(AccountBook record) {
        return bookMapper.select(record);
    }

    @Override
    public Integer insertAccountBook(AccountBook record) {
        return bookMapper.insert(record);
    }

    @Override
    public Integer delAccountBook(AccountBook record) {
        return bookMapper.delete(record);
    }

}
