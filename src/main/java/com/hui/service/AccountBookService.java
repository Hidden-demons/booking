package com.hui.service;

import com.hui.pojo.AccountBook;
import com.hui.pojo.Users;

import java.util.List;

public interface AccountBookService {

    List<AccountBook> queryAccountBook(AccountBook record);

    Integer insertAccountBook(AccountBook record);
}
