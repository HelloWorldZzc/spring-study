package com.test.service;

import com.test.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl {
    @Autowired
    private LogDao logdao;
    //加上了注解,表示设置事务属性：传播行为设置为当前操作需要新事务
    //这样的话,添加记录操作和转账操作就不属于同一个事件
    //只需要在server中配置好,就能达到需求所描述的,一个成功一个失败,因为他们不属于同一个事件,不会同时成功失败
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String out,String in,Double money){
        logdao.log("转账操作由"+out+"到"+in+",金额："+money);
    }
}