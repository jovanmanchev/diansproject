package mk.ukim.finki.hospiproject.repository;

import mk.ukim.finki.hospiproject.repository.dataholder.DataReader;
import mk.ukim.finki.hospiproject.repository.dataholder.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalRepository {

    public List<Hospital> getAllHospitals(){
        return DataReader.hospitalList;
    }
}
