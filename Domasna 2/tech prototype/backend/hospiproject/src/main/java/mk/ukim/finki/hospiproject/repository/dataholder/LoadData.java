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
        System.out.println(DataReader.jsonObjects);
    }
}
class Hospital{
    private Long hospitalId;
    private Double lon;
    private Double lat;
    private String name;

    public Hospital(Long hospitalId, Double lon, Double lat, String name) {
        this.hospitalId = hospitalId;
        this.lon = lon;
        this.lat = lat;
        this.name = name;
    }
    public Hospital(Long hospitalId, Double lon, Double lat){
        this.hospitalId = hospitalId;
        this.lon = lon;
        this.lat = lat;
    }
    public static Hospital createHospital(String line){
        String [] parts = line.split("\t");
        if(parts.length == 3)
            return new Hospital(Long.valueOf(parts[0]), Double.valueOf(parts[1]), Double.valueOf(parts[2]));

        return new Hospital(Long.valueOf(parts[0]), Double.valueOf(parts[1]), Double.valueOf(parts[2]), parts[3]);
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }

    public String getName() {
        return name;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", lon=" + lon +
                ", lat=" + lat +
                ", name='" + name + '\'' +
                '}';
    }
}

class DataReader{
    private final String FILE_PATH = "./hospitals.txt";
    public static List<JSONObject> jsonObjects = new ArrayList<>();
    private File file;

    private List<Hospital> hospitalList;
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