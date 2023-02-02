package mk.ukim.finki.usersservice.controller;

import mk.ukim.finki.usersservice.repository.dataholder.Message;
import mk.ukim.finki.usersservice.service.LoginUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

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
