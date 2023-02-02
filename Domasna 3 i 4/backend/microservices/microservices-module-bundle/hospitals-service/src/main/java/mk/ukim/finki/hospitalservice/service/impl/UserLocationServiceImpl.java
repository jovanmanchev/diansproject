package mk.ukim.finki.hospitalservice.service.impl;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import mk.ukim.finki.hospitalservice.repository.dataholder.DbReaderSingleton;
import mk.ukim.finki.hospitalservice.repository.dataholder.GeoIP;
import mk.ukim.finki.hospitalservice.service.UserLocationService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;

@Service
public class UserLocationServiceImpl implements UserLocationService {
    @Override
    public GeoIP getUserLocation(String ipAddress) throws IOException {
        DatabaseReader databaseReader = DbReaderSingleton.getInstance();


        InetAddress ip = null;
        CityResponse cityResponse = null;
        try{
            ip = InetAddress.getByName((String)ipAddress);
            cityResponse = databaseReader.city(ip);
        }catch (GeoIp2Exception e){
            return new GeoIP("41.6058", "21.7453");
        }

        String latitude = cityResponse.getLocation().getLatitude().toString();
        String longitude = cityResponse.getLocation().getLongitude().toString();
        return new GeoIP(latitude, longitude);
    }
}
