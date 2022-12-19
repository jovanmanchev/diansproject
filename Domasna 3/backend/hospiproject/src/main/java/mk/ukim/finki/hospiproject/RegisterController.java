package mk.ukim.finki.hospiproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public String getLoginPage() {
        return "register-page";
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public String login(HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirmPassword");
        if (username.isEmpty() || username == null || password.isEmpty() || password == null) {
            return "redirect:/register";
        }


        FileReader fileReader = new FileReader("./users.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.split(" ")[0].equals(username)) {
                return "redirect:/register";
            }
            s = bufferedReader.readLine();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("./users.txt", true));
        writer.write('\n' + username + " " + password);
        return "redirect:/login";
    }
}
