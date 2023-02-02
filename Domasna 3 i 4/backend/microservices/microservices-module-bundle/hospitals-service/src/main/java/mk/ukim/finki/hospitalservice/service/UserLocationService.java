package mk.ukim.finki.hospitalservice.service;

import mk.ukim.finki.hospitalservice.repository.dataholder.GeoIP;

import java.io.IOException;

public interface UserLocationService {

    GeoIP getUserLocation(String ipAddress) throws IOException;
}
