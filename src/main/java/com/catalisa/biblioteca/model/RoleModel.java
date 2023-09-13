package com.catalisa.biblioteca.model;

import com.catalisa.biblioteca.enums.RoleEnum;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "TB_ROLE")
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleEnum role;

    @Override
    public String getAuthority() {
        return this.role.toString();
    }
}
