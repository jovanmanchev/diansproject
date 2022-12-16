package mk.ukim.finki.hospiproject;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.hospiproject.repository.dataholder.DataReader;
import mk.ukim.finki.hospiproject.repository.dataholder.GeoIP;
import mk.ukim.finki.hospiproject.repository.dataholder.Hospital;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.http.RequestEntity;
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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getHospitals(){
        return ResponseEntity.ok()
                .body(DataReader.hospitalList);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/location")
    public ResponseEntity<GeoIP> getUserLocation(@RequestParam(value="ipAddress", required=true) String ipAddress) throws IOException, GeoIp2Exception {

        String dbLocation = "./GeoLite2-City.mmdb";
        File locationsDatabase = new File(dbLocation);
        DatabaseReader dbReader = new DatabaseReader.Builder(locationsDatabase)
                .build();
        InetAddress ip = InetAddress.getByName(ipAddress);
        CityResponse cityResponse = dbReader.city(ip);
        String latitude = cityResponse.getLocation().getLatitude().toString();
        String longitude = cityResponse.getLocation().getLongitude().toString();

        return ResponseEntity.ok()
                .body(new GeoIP(latitude, longitude));

    }
}
