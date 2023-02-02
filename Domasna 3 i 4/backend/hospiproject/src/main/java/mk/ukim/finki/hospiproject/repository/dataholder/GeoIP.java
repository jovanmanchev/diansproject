package mk.ukim.finki.hospiproject.repository.dataholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoIP {

    private String latitude;
    private String longitude;
}
