package com.gaoxiong.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "es_member")
public class Member implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 会员id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  /**
   * 会员名
   */
  @Column(name = "member_name")
  private String memberName;

  /**
   * 密码
   */
  @Column(name = "password")
  private String password;

  /**
   * 电子邮箱
   */
  @Column(name = "email")
  private String email;

  /**
   * 性别 1男0女
   */
  @Column(name = "sex")
  private Integer sex;

  /**
   * 手机号
   */
  @Column(name = "mobile")
  private String mobile;

  /**
   * 出生日
   */
  @Column(name = "birthday")
  private Date birthday;

  /**
   * 注册日期
   */
  @Column(name = "createTime")
  private Date createTime;

  
}