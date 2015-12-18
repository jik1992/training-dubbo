package com.quicloud.dao;

import com.quicloud.domain.Name;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:58 PM Information:
 */
@Transactional
public interface NameDao extends CrudRepository<Name, Long> {

  Name findByName(String name);

}

