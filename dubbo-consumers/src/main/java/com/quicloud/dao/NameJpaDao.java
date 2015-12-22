package com.quicloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:58 PM Information:
 */
@Transactional
public interface NameJpaDao extends JpaRepository<Name, Long> {

}

