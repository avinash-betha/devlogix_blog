package com.devlogix.devlogix_blog.userrole.entity;

import com.devlogix.devlogix_blog.user.entity.UserEntity;
import com.devlogix.devlogix_blog.role.entity.RoleEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    // JPA requires no-args constructor
    protected UserRoleEntity() {
    }

    public UserRoleEntity(UserEntity user, RoleEntity role) {
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public RoleEntity getRole() {
        return role;
    }

    // Equality based on identifier only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleEntity)) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                '}';
    }
}
