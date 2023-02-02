package mk.ukim.finki.hospiproject.controller;

import mk.ukim.finki.hospiproject.repository.dataholder.Message;
import mk.ukim.finki.hospiproject.service.LoginUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginUserService loginUserService;

    public LoginController(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Message> login(@RequestParam String username, @RequestParam String password) throws IOException {
        
        return ResponseEntity.ok().body(new Message(this.loginUserService.loginUser(username, password)));
    }
}
