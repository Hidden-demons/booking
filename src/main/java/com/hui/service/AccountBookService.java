package com.hui.service;

import com.hui.pojo.AccountBook;
import com.hui.pojo.Users;

import java.util.List;

public interface AccountBookService {
    /**
     * @param  record
     * @return 返回记账的资料
     *
     * */
    List<AccountBook> queryAccountBook(AccountBook record);

    Integer insertAccountBook(AccountBook record);

    Integer delAccountBook(AccountBook record);
}
