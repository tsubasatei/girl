package com.xt.girl.service;

import com.xt.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created with xt.
 * Date: 2018/3/16
 * Time: 9:26
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() throws Exception {
        Optional<Girl> girl = girlService.findOne(21);
        Assert.assertEquals(new Integer(14), girl.get().getAge());
    }

}