package com.onlinetest.th.Service;

import com.onlinetest.th.Dao.StDao;
import com.onlinetest.th.Model.Test_question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StService {
    @Resource
    StDao stDao;

    public int addSt(Test_question tq){
        return stDao.addSt(tq);
    }
}
