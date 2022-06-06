package com.rightstep.figure;

import com.rightstep.figure.install.InstallDataBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Slf4j
@SpringBootApplication
@PropertySource(value = {"file:secured.properties"})
public class FigureApplication {

	public static void main(String[] args) throws IOException {
		new InstallDataBase().start();
		SpringApplication.run(FigureApplication.class, args);
	}

}
