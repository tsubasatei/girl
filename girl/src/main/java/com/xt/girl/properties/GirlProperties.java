package com.xt.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with xt.
 * Date: 2018/3/14
 * Time: 12:23
 * Description:
 */
@Component
@ConfigurationProperties(prefix="girl")
public class GirlProperties {
    private String cupSize; //罩杯
    private Integer age; //年龄

    public String getCupSize() {
        return cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
