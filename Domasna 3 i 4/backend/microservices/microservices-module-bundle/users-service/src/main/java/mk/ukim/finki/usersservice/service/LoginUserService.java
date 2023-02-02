package mk.ukim.finki.usersservice.service;

import java.io.IOException;

public interface LoginUserService {

    String loginUser(String username, String password) throws IOException;
}
