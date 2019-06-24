package com.gaoxiong.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "es_role_permission")
@Data
public class RolePermission implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @Id
  @Column(name = "id", insertable = false, nullable = false)
  private Integer id;

  /**
   * 角色id
   */
  @Column(name = "role_id")
  private Integer roleId;

  /**
   * 权限id
   */
  @Column(name = "permission_id")
  private Integer permissionId;

  
}