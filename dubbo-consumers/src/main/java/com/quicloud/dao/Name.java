package com.quicloud.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by ZuoYun on 12/18/15. Time: 2:57 PM Information:
 */
@Entity
@Table(name = "name")
public class Name {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  String name;

  public Long getId() {
    return id;
  }

  public Name setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Name setName(String name) {
    this.name = name;
    return this;
  }
}
