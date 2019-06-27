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
@Table(name = "es_permission")
public class Permission implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 权限id
   */
  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  /**
   * 方法类型
   */
  @Column(name = "method")
  private String method;

  /**
   * 网关前缀
   */
  @Column(name = "zuul_prefix")
  private String zuulPrefix;

  /**
   * 服务前缀
   */
  @Column(name = "service_prefix")
  private String servicePrefix;

  /**
   * 请求路径
   */
  @Column(name = "uri")
  private String uri;

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