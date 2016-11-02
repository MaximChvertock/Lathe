package by.chvertock.lathe.hibernate;

import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HibernateUserDetails implements UserDetails {

    private User user;

//    private static Set<SimpleGrantedAuthority> testRoles = new HashSet<SimpleGrantedAuthority>();
//
//    static {
//        testRoles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }

    HibernateUserDetails(User user) throws NullPointerException {
        if (user == null) {
            throw new NullPointerException();
        }
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.toString()));
        }
        return roles;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getEmail();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "HibernateUserDetails{" +
                "user=" + user +
                '}';
    }
}
