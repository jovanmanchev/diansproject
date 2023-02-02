package mk.ukim.finki.usersservice.repository.dataholder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderSingleton {

    private static BufferedReader bufferedReader;

    public static BufferedReader getFileReader() throws FileNotFoundException {

        synchronized (FileReaderSingleton.class){
            if(bufferedReader == null){
                FileReader fileReader = new FileReader("./users.txt");
                FileReaderSingleton.bufferedReader = new BufferedReader(fileReader);
            }
        }

        return bufferedReader;
    }
}
