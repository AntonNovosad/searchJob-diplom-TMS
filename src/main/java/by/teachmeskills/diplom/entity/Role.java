package by.teachmeskills.diplom.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public enum Role implements GrantedAuthority {
    USER,ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> permissions = new HashSet<>();
        permissions.add(new SimpleGrantedAuthority(this.name()));
        return permissions;
    }
}
