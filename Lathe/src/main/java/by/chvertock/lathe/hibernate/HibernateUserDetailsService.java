package by.chvertock.lathe.hibernate;


import by.chvertock.lathe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

class HibernateUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HibernateUserDetails userDetails;
        try {
            userDetails = new HibernateUserDetails(userService.getUserByEMail(username));
        } catch (NullPointerException ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }catch (Exception ex ) {
            throw new UsernameNotFoundException(ex.getMessage());
        }

        return userDetails;
    }
}
