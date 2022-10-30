package org.example;


import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        try {
            dataReader.extractDataFromFile();
        }catch (IOException fileNotFoundException){
            System.out.println(fileNotFoundException.getMessage());
        }


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
    private final String FILE_PATH = "../hospitals.txt";
    private final String FILE_OUTPUT_PATH = "./hospitals.json";
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
       generateJSONFile();

    }

    private void generateJSONFile() throws IOException {

        List<JSONObject> jsonObjects = new ArrayList<>();


        jsonObjects = this.hospitalList.stream().map(hospital -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", hospital.getHospitalId());
            jsonObject.put("lon", hospital.getLon());
            jsonObject.put("lat", hospital.getLat());
            jsonObject.put("name", hospital.getName());
            return jsonObject;
        }).collect(Collectors.toList());

        FileWriter fileWriter = new FileWriter(FILE_OUTPUT_PATH);

        for(JSONObject jsObject: jsonObjects){
            System.out.println(jsObject);
            fileWriter.write(jsObject.toJSONString());
        }


    }
}