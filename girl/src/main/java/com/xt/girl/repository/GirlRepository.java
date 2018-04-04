package com.xt.girl.repository;

import com.xt.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with xt.
 * Date: 2018/3/14
 * Time: 15:16
 * Description:
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);
}
