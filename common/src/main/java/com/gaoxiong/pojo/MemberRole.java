package com.gaoxiong.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "es_member_role")
public class MemberRole implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  /**
   * 会员id
   */
  @Column(name = "member_id")
  private Integer memberId;

  /**
   * 角色id
   */
  @Column(name = "role_id")
  private Integer roleId;

  
}