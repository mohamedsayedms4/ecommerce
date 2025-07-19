package org.example.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Represents an application user.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    /** User's unique identifier */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** User's email (also used as username) */
    @NotBlank
    @Email
    private String email;

    /** User's password */
    @NotBlank
    private String password;

    /** The user's cart */
    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private Cart cart;

    /** User role (USER or ADMIN) */
    @Enumerated(EnumType.STRING)
    private Role role;

    /** Whether the user's email is confirmed */
    private boolean emailConfirmation;

    /** Code used for email confirmation */
    private String confirmationCode;

    /** Enum for user roles */
    public enum Role {
        USER, ADMIN
    }

    /** Returns user authorities (used by Spring Security) */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
