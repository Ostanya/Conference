package com.epam.rd.java.finalconf.command;

import com.epam.rd.java.finalconf.service.impl.UserService;
import com.epam.rd.java.finalconf.util.FillForm;
import com.epam.rd.java.finalconf.util.exeption.UserExistExept;
import com.epam.rd.java.finalconf.util.validation.Validation;

import javax.servlet.http.HttpServletRequest;

import static com.epam.rd.java.finalconf.util.Resolver.resolve;

public class Registration implements Command {
    private final UserService userService;
    public static final String REGISTRATION = "registration";

    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            return resolve(REGISTRATION);
        }

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String matchingPassword = request.getParameter("matchingPassword");
        String role = "USER";

        Validation validate = new Validation();

        if (validate.isEmpty(firstName, lastName, email, password, matchingPassword)) {
            request.setAttribute("errors", validate.getErrors());
            FillForm.fillUserCreationForm(request, firstName, lastName, email);
            return resolve(REGISTRATION);
        }
        if (!validate.isValidEmail(email)) {
            request.setAttribute("errors", validate.getErrors());
            FillForm.fillUserCreationForm(request, firstName, lastName, email);
            return resolve(REGISTRATION);
        }

        if (!validate.isPasswordsMatch(password, matchingPassword)) {
            request.setAttribute("errors", validate.getErrors());
            FillForm.fillUserCreationForm(request, firstName, lastName, email);
            return resolve(REGISTRATION);
        }
        try {
            userService.create(firstName, lastName, email, password, role);
        } catch (UserExistExept e) {
            request.setAttribute("userAlreadyExistsMessage", true);
            FillForm.fillUserCreationForm(request, firstName, lastName, email);
            return resolve(REGISTRATION);
        }
        return "redirect:/login";
    }
}
