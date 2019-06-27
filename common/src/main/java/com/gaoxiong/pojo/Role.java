package com.gaoxiong.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "es_role")
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 角色id
   */
  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  /**
   * 角色名称
   */
  @Column(name = "role_name")
  private String roleName;

  /**
   * 是否有效 1是 0否
   */
  @Column(name = "valid")
  private Integer valid;

  /**
   * 创建日期
   */
  @Column(name = "createTime")
  private Date createTime;

  /**
   * 更新日期
   */
  @Column(name = "updateTime")
  private Date updateTime;

  
}