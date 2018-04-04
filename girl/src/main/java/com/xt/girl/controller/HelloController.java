package com.xt.girl.controller;

import com.xt.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with xt.
 * Date: 2018/3/13
 * Time: 21:43
 * Description:
 */
@RestController
@RequestMapping(value="/hello")
public class HelloController {

    @Autowired
    GirlProperties girlProperties;
    //@RequestMapping(value = "/say", method= RequestMethod.GET)
    @GetMapping("/say")
    public String say(@RequestParam(value="id", required = false, defaultValue = "0") Integer id){
        //return girlProperties.getCupSize() + girlProperties.getAge();
        return "id: " + id;
    }
}
