package mk.ukim.finki.hospiproject.repository.dataholder;

import com.maxmind.geoip2.DatabaseReader;

import java.io.File;
import java.io.IOException;

public class DbReaderSingleton {
    private static DatabaseReader databaseReader;
    private DbReaderSingleton(){

    };

    public static DatabaseReader getInstance() throws IOException {
        synchronized (DbReaderSingleton.class) {
            if (databaseReader == null) {
                String dbLocation = "./GeoLite2-City.mmdb";
                File locationsDatabase = new File(dbLocation);
                DbReaderSingleton.databaseReader = new DatabaseReader.Builder(locationsDatabase)
                        .build();
            }
        }

        return databaseReader;
    }
}
