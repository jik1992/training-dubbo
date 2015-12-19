package com.quicloud.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:58 PM Information:
 */
@Transactional
public interface NameDao extends CrudRepository<Name, Long> {

  List<Name> findByName(String name);

  Iterator<Name> findByName(String name, Sort sort);

  Page<Name> findByName(String name, Pageable page);

//  @Query("select a from name a where a.id = ?1")
//  Name findByAccountId(Long id);


}

