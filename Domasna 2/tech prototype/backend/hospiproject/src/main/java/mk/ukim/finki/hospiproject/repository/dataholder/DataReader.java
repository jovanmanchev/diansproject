package mk.ukim.finki.hospiproject.repository.dataholder;

import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    private final String FILE_PATH = "./hospitals.txt";
    public static List<JSONObject> jsonObjects = new ArrayList<>();
    private File file;

    public static List<Hospital> hospitalList;
    public DataReader(){
        file = new File(FILE_PATH);
        hospitalList = new ArrayList<>();
    }
    public void extractDataFromFile() throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        hospitalList = bufferedReader.lines()
                .map(Hospital::createHospital)
                .collect(Collectors.toList());


    }

    public void generateJSONData() throws IOException {


        jsonObjects = this.hospitalList.stream().map(hospital -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", hospital.getHospitalId());
            jsonObject.put("lon", hospital.getLon());
            jsonObject.put("lat", hospital.getLat());
            jsonObject.put("name", hospital.getName());
            return jsonObject;
        }).collect(Collectors.toList());




    }
}
