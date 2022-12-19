package mk.ukim.finki.hospiproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public String getLoginPage() {
        return "login-page";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public String login(HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        FileReader fileReader = new FileReader("./users.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.split(" ")[0].equals(username) && s.split(" ")[1].equals(password))
                return "redirect:http://localhost:4200/main";
            s = bufferedReader.readLine();
        }
        return "redirect:/login";
    }
}
