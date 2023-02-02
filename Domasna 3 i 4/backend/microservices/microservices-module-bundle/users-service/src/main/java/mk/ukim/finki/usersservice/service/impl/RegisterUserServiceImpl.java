package mk.ukim.finki.usersservice.service.impl;

import mk.ukim.finki.usersservice.repository.dataholder.FileReaderSingleton;
import mk.ukim.finki.usersservice.repository.dataholder.FileWriterSingleton;
import mk.ukim.finki.usersservice.service.RegisterUserService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
    @Override
    public String registerUser(String username, String password, String confirmPassword) throws IOException {
        BufferedReader bufferedReader = FileReaderSingleton.getFileReader();

        if (username.isEmpty() || username == null || password.isEmpty() || password == null || confirmPassword.isEmpty() || confirmPassword == null) {
            return "ALL INPUTS ARE REQUIRED";
        }

        if (!password.equals(confirmPassword)) {
            return "PASSWORDS DO NOT MATCH";
        }
        String s = bufferedReader.readLine();
        while (s != null) {
            if (s.split(" ")[0].equals(username)) {
                return "USERNAME ALREADY EXISTS";
            }
            s = bufferedReader.readLine();
        }

        BufferedWriter writer = FileWriterSingleton.getFileWriter();
        writer.write('\n' + username + " " + password);
        writer.flush();
        writer.close();

        return "OK";
    }
}
