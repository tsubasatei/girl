package com.xt.girl.controller;

import com.xt.girl.domain.Girl;
import com.xt.girl.domain.Result;
import com.xt.girl.repository.GirlRepository;
import com.xt.girl.service.GirlService;
import com.xt.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created with xt.
 * Date: 2018/3/14
 * Time: 15:12
 * Description:
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * Created with xt.
     * Date:2018/3/14
     * Time:15:22
     * Params:
     * Description:查询所有女生列表
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * Created with xt.
     * Date:2018/3/14
     * Time:15:30
     * Params:
     * Description:添加一个女生
     */
    /*@PostMapping("/girls")
    public Girl girlAdd(@RequestParam("age") Integer age,
                        @RequestParam("cupSize") String cupSize) {*/
    /*public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        *//*girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());*//*

        return girlRepository.save(girl);
    }*/
    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return null;
           // return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        /*girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());*/

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * Created with xt.
     * Date:2018/3/14
     * Time:15:48
     * Params:
     * Description:查询一个女生
     */
    @GetMapping(value="/girls/{id}")
    public Optional<Girl> gileFindOne(@PathVariable("id") Integer id){
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> girlExample = Example.of(girl);

        return girlRepository.findOne(girlExample);
        //return Optional.ofNullable(girlRepository.findOne(girlExample).orElse(null));
    }

    @PutMapping(value="/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    /**
     * Created with xt.
     * Date:2018/3/14
     * Time:16:40
     * Params:
     * Description:删除
     */
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value="/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping(value="/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value="/girls/getAge/{id}")
    public void  getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
