package mk.ukim.finki.hospiproject.repository.dataholder;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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
