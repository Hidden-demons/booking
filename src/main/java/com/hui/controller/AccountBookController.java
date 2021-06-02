package com.hui.controller;

import com.alibaba.fastjson.JSON;
import com.hui.pojo.AccountBook;
import com.hui.service.AccountBookService;
import com.hui.utils.IMoocJSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@Slf4j
@RequestMapping("ab")
public class AccountBookController {

    @Autowired
    private AccountBookService accountBookService;

    @PostMapping("/queryAccountBook")
    public IMoocJSONResult queryAccountBook(@RequestBody AccountBook accountBook){

        log.info("stat queryAccountBook=====" + JSON.toJSONString(accountBook));
        List<AccountBook> accountBookList = accountBookService.queryAccountBook(accountBook);
        log.info("end queryAccountBook=====" + JSON.toJSONString(accountBookList));

        if (accountBookList.size() <= 0){
            return  IMoocJSONResult.ok();
        }
        return  IMoocJSONResult.ok(accountBookList);
    }

    @PostMapping("/insertAccountBook")
    public IMoocJSONResult insertAccountBook(@RequestBody AccountBook accountBook){

        log.info("stat insertAccountBook=====" + JSON.toJSONString(accountBook));
        Integer integer = accountBookService.insertAccountBook(accountBook);
        log.info("end insertAccountBook=====" + integer);
        if (integer <= 0 ){
            return  IMoocJSONResult.errorMsg("添加失败...请核查数据库...");
        }
        return IMoocJSONResult.ok();
    }
}
