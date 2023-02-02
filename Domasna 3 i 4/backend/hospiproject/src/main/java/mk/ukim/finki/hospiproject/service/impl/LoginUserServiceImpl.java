package mk.ukim.finki.hospiproject.service.impl;

import mk.ukim.finki.hospiproject.repository.dataholder.FileReaderSingleton;
import mk.ukim.finki.hospiproject.repository.dataholder.Message;
import mk.ukim.finki.hospiproject.service.LoginUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Override
    public String loginUser(String username, String password) throws IOException {
        BufferedReader bufferedReader = FileReaderSingleton.getFileReader();
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.split(" ")[0].equals(username) && s.split(" ")[1].equals(password))
                return "OK";
            s = bufferedReader.readLine();
        }
        return "NOT FOUND";
    }
}
