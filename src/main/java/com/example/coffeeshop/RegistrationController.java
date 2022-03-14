package com.example.coffeeshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.coffeeshop.Services.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @ModelAttribute
    private Registration getRegistration() {
        return new Registration();
    }

    @GetMapping("/registrations")
    public String view() {
        return "vip";
    }

    @PostMapping("/registrations")
    public String register(@Valid
            @ModelAttribute Registration registration,
            BindingResult bindingResult) {
                if (bindingResult.hasErrors()) {
                    return "vip";
                }
        registrationService.addVip(registration);
        return "redirect:/index";
    }

    /* @PostMapping("registrations")
    public ModelAndView registerUserAccount(
    @ModelAttribute("user") @Valid Registration registration,
    HttpServletRequest request,
    Errors errors) {
        
        try {
            Registration registered = RegistrationService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
    }

    // rest of the implementation
}
 */
   /*  public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            LOGGER.error("Error while login ", e);
        }
    } */

}
