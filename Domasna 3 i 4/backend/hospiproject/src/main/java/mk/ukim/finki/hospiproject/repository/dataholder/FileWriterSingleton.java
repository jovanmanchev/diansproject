package mk.ukim.finki.hospiproject.repository.dataholder;

import java.io.*;

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
