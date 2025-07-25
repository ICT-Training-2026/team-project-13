package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.UserSession;
import com.example.demo.entity.Login;
import com.example.demo.entity.LoginResult;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final UserSession userSession;
    
    
    

    @GetMapping({"/login","/"})
    public String showLoginTop() {
        return "login";
    }
    
   /* @GetMapping("/top1")
    public String returnLoginTopModel model) {
        model.addAttribute("username", userSession.getId());
        model.addAttribute("authority", userSession.getAuthority());
        return "top";
    }*/

    
    
    
    @PostMapping("/top")
    public String checkLogin(
            @RequestParam String id,
            @RequestParam String pass,
            Model model) {
        Login login = new Login(id, pass);
        LoginResult lr = loginService.checkLogin(login);
        if (lr.isActive()) {
            userSession.setId(id);  // ユーザーIDをセッションに設定
            userSession.setAuthority(lr.getAuthority());  // 認可情報をセッションに設定
            model.addAttribute("authority", lr.getAuthority());
            model.addAttribute("id", id);
            return "top";  // 成功時の遷移先
        } else {
            model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
            return "login";  // 失敗時に戻る遷移先
        }
    }

    
    
    
    /*@GetMapping("/getUsername")
    public String getUsername(Model model) {
        model.addAttribute("username", userSession.getId());
        model.addAttribute("authority", userSession.getAuthority());
        return "displayUsername";  // ユーザー名と権限を表示するビューを指定
    }*/
}