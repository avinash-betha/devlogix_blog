package com.devlogix.devlogix_blog.role.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "role_code",
            nullable = false,
            unique = true,
            length = 50
    )
    private String roleCode;

    @Column(name = "description")
    private String description;

    // JPA requires no-args constructor
    protected RoleEntity() {
    }

    public RoleEntity(String roleCode, String description) {
        this.roleCode = roleCode;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Entity equality based ONLY on identifier
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity)) return false;
        RoleEntity that = (RoleEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
