package com.raycloud.express.boss.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:58 PM Information:
 *
 * 框架在进行方法名解析时，会先把方法名多余的前缀截取掉，比如 find、findBy、read、readBy、get、getBy
 *
 * 如果方法的最后一个参数是 Sort 或者 Pageable 类型
 */
@Transactional
public interface NameDao extends CrudRepository<Name, Long> {

  List<Name> findByName(String name);

  Iterator<Name> findByName(String name, Sort sort);

  Page<Name> findByName(String name, Pageable page);

//  @Query("select * from Name a  where a.id = ?1")
//  Name findById(Long id);
//
//  @Modifying
//  @Query("update AccountInfo a set a.salary = ?2 where a. ")
//  Name updateNameById(String name, Long id);


}

