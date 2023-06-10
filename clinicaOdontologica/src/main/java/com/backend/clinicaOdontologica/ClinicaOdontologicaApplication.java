package com.backend.clinicaOdontologica;

import com.backend.clinicaOdontologica.dao.H2Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicaOdontologicaApplication.class);

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		H2Connection.crearBd();
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		LOGGER.info("Proyecto integrador is now running ...");
	}

}