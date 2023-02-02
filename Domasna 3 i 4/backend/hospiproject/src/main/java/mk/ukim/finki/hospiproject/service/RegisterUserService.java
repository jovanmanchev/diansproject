package mk.ukim.finki.hospiproject.service;

import java.io.IOException;

public interface RegisterUserService {

    String registerUser(String username, String password, String confirmPassword) throws IOException;
}
