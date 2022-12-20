package mk.ukim.finki.hospiproject;

import mk.ukim.finki.hospiproject.repository.dataholder.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/register")
public class RegisterController {


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Message> register(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword) throws IOException {

        if (username.isEmpty() || username == null || password.isEmpty() || password == null || confirmPassword.isEmpty() || confirmPassword == null) {
            return ResponseEntity.ok().body(new Message("ALL INPUTS ARE REQUIRED"));
        }

        if (!password.equals(confirmPassword)) {
            return ResponseEntity.ok().body(new Message("PASSWORDS DO NOT MATCH"));
        }

        FileReader fileReader = new FileReader("./users.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.split(" ")[0].equals(username)) {
                return ResponseEntity.ok().body(new Message("USERNAME ALREADY EXISTS"));
            }
            s = bufferedReader.readLine();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("./users.txt", true));
        writer.write('\n' + username + " " + password);
        return ResponseEntity.ok().body(new Message("OK"));
    }
}
