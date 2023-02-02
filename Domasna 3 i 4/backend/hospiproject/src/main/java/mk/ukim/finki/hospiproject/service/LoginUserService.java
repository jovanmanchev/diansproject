package mk.ukim.finki.hospiproject.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LoginUserService {

    String loginUser(String username, String password) throws IOException;
}
