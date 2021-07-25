package by.teachmeskills.diplom.controller;

import by.teachmeskills.diplom.entity.User;
import by.teachmeskills.diplom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
       return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }

//    @GetMapping("/reg")
//    public ModelAndView registration(Model model){
//        model.addAttribute("user", new User());
//        return new ModelAndView("reg");
//    }
//
//    @PostMapping("/reg")
//    public ModelAndView registration(@ModelAttribute("user") User user, Model model) {
//        try {
//            userService.saveUser(user);
//            return new ModelAndView("auth");
//        } catch (RuntimeException e) {
//            model.addAttribute("message", e.getMessage());
//            return new ModelAndView("reg");
//        }
//    }
}
