package com.raycloud.express.boss.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:58 PM Information:
 */
@Transactional
public interface NamePageDao extends PagingAndSortingRepository<Name, Long> {

}

