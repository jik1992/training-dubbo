package com.quicloud.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:58 PM Information:
 */
@Transactional
public interface NamePageDao extends PagingAndSortingRepository<Name, Long> {

}

