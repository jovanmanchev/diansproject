package mk.ukim.finki.hospiproject.repository.dataholder;

import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hospital {
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

