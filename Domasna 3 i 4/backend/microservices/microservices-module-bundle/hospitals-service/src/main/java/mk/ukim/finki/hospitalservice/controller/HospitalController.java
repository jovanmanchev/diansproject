package mk.ukim.finki.hospitalservice.controller;

import mk.ukim.finki.hospitalservice.repository.dataholder.DataReader;
import mk.ukim.finki.hospitalservice.repository.dataholder.GeoIP;
import mk.ukim.finki.hospitalservice.repository.dataholder.Hospital;
import mk.ukim.finki.hospitalservice.service.UserLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

@RestController
public class HospitalController {

    private final UserLocationService userLocationService;

    public HospitalController(UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getHospitals(){
        return ResponseEntity.ok()
                .body(DataReader.hospitalList);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/location")
    public ResponseEntity<GeoIP> getUserLocation(@RequestParam(value="ipAddress") Object ipAddress) throws IOException {


        return ResponseEntity.ok()
                .body(this.userLocationService.getUserLocation((String)ipAddress));

    }
}
