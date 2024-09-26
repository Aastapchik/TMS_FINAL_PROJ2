package myProj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class AppRunner {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(AppRunner.class, args);
	}

}
