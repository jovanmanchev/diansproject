package mk.ukim.finki.usersservice.repository.dataholder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterSingleton {

    private static BufferedWriter bufferedWriter;

    public static BufferedWriter getFileWriter() throws IOException {

        synchronized (FileReaderSingleton.class){
            if(bufferedWriter == null){
                FileWriter fileWriter = new FileWriter("./users.txt", true);
                FileWriterSingleton.bufferedWriter = new BufferedWriter(fileWriter);
            }
        }

        return bufferedWriter;
    }
}
