package mk.ukim.finki.hospiproject.service;

import com.maxmind.geoip2.model.CityResponse;
import mk.ukim.finki.hospiproject.repository.dataholder.GeoIP;

import java.io.IOException;

public interface UserLocationService {

    GeoIP getUserLocation(String ipAddress) throws IOException;
}
