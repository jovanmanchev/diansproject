package mk.ukim.finki.usersservice.controller;

import mk.ukim.finki.usersservice.repository.dataholder.Message;
import mk.ukim.finki.usersservice.service.RegisterUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final RegisterUserService registerUserService;

    public RegisterController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Message> register(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword) throws IOException {


        String response = this.registerUserService.registerUser(username, password, confirmPassword);

        return ResponseEntity.ok().body(new Message(response));
    }
}
