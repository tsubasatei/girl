package com.xt.girl.service;

import com.xt.girl.domain.Girl;
import com.xt.girl.enums.ResultEnum;
import com.xt.girl.exception.GirlException;
import com.xt.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created with xt.
 * Date: 2018/3/14
 * Time: 17:01
 * Description:
 */
@Service
@Transactional
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(19);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlA.setAge(20);
        girlA.setCupSize("BBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Optional<Girl> girlOptional = girlRepository.findById(id);
        Girl girl = girlOptional.get();
        Integer age = girl.getAge();
        if(age <= 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age <= 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果大于16
    }

    /**
     * Created with xt.
     * Date:2018/3/16
     * Time:9:20
     * Params:
     * Description:通过id查一个女生的信息
     */
    public Optional<Girl> findOne(Integer id){
        return girlRepository.findById(id);
    }
}
