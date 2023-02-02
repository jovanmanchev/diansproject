package mk.ukim.finki.hospitalservice.repository.dataholder;

import jakarta.annotation.PostConstruct;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoadData {

    @PostConstruct
    public void init() throws FileNotFoundException, ParseException, IOException {

        DataReader dataReader = new DataReader();
        dataReader.extractDataFromFile();
        dataReader.generateJSONData();

    }
}
