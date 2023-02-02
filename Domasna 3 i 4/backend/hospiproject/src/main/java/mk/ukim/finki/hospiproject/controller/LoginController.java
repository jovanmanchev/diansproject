package mk.ukim.finki.hospiproject.controller;

import mk.ukim.finki.hospiproject.repository.dataholder.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Message> login(@RequestParam String username, @RequestParam String password) throws IOException {

        FileReader fileReader = new FileReader("./users.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.split(" ")[0].equals(username) && s.split(" ")[1].equals(password))
                return ResponseEntity.ok().body(new Message("OK"));
            s = bufferedReader.readLine();
        }
        return ResponseEntity.ok().body(new Message("NOT FOUND"));
    }
}
