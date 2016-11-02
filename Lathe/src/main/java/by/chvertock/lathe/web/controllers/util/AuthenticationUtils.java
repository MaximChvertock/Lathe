package by.chvertock.lathe.web.controllers.util;


import by.chvertock.lathe.hibernate.HibernateUserDetails;
import by.chvertock.lathe.model.entities.user.User;
import by.chvertock.lathe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class AuthenticationUtils {

    @Autowired
    private UserService userService;

    public boolean isUserAuthenticated() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal.getClass() == HibernateUserDetails.class) {
            return true;
        }

        return false;
    }

    public User getAuthenticatedUser() {
        User result = null;
        if (isUserAuthenticated()) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            HibernateUserDetails details = (HibernateUserDetails) principal;

            result = userService.getUserByEMail(details.getUsername());
        }

        return result;
    }

    public String getRemoteAddress() {
        WebAuthenticationDetails details = (WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        return details.getRemoteAddress();
    }
}
