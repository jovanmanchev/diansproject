package mk.ukim.finki.hospiproject;

import mk.ukim.finki.hospiproject.repository.dataholder.DataReader;
import mk.ukim.finki.hospiproject.repository.dataholder.Hospital;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getHospitals(){
        return ResponseEntity.ok()
                .body(DataReader.hospitalList);
    }
}
