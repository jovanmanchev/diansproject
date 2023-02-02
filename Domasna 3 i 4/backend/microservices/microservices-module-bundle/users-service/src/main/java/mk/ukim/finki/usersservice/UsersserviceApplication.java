package mk.ukim.finki.usersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class UsersserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersserviceApplication.class, args);
	}

}
