package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.entity.User;
import com.epam.rd.java.finalconf.service.impl.ServiceSecurity;
import com.epam.rd.java.finalconf.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

import static com.epam.rd.java.finalconf.util.Resolver.resolve;

public class Login implements Command {
    private final UserService userService;
    private final ServiceSecurity securityService;
    public static final String LOGIN = "login";


    public Login(UserService userService, ServiceSecurity securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            return resolve(LOGIN);
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(Objects.isNull(email) || Objects.isNull(password) ||
                email.isEmpty() || password.isBlank()) {
            request.setAttribute("login_error", "valid.login.not.empty");
            return resolve(LOGIN);
        }

        Optional<User> user = userService.findByEmail(email);
        if (user.isEmpty()) {
            request.setAttribute("login_error", "valid.login.login.failure");
            return resolve(LOGIN);
        }

        if (!securityService.passwordIsValid(password, user.get())) {
            request.setAttribute("login_error", "valid.login.password.failure");
            return resolve(LOGIN);
        }

        securityService.storeLoggedUser(request.getSession(), user.get());
        String uri = securityService.setUriByRole(request);
        return "redirect:" + uri;
    }
}
