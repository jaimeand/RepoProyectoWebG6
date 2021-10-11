package com.sprint4.mongorepository;

import com.sprint4.mongorepository.models.Estudiantes;
import com.sprint4.mongorepository.models.Proyectos;
import com.sprint4.mongorepository.repositories.EstudiantesRepository;
import com.sprint4.mongorepository.repositories.ProyectosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongorepositoryApplication implements CommandLineRunner {

	private final EstudiantesRepository estudiantesRepository;
	private final ProyectosRepository proyectosRepository;

	@Autowired
	public MongorepositoryApplication(EstudiantesRepository estudiantesRepository, ProyectosRepository proyectosRepository){
		this.estudiantesRepository = estudiantesRepository;
		this.proyectosRepository =proyectosRepository;
	}



	public static void main(String[] args) {
		SpringApplication.run(MongorepositoryApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {


			estudiantesRepository.save(new Estudiantes("Manuel","Giraldo","32",
					"manuel123@gmail.com","3214235658","Ciencias Sociales"));
			estudiantesRepository.save(new Estudiantes("Carolina","Gonzales","32",
					"manuel123@gmail.com","3214235658","Ciencias Sociales"));

		//			proyectosRepository.save(new Proyectos("facturacion", "crear sistema facturacion",
//					"sistema facturacion supermercado", "500000", "14 octubre", "23 noviembre",
//					"francisco","ejecucion","1"));


//		}for (Estudiantes Estudiantes : estudiantesRepository.findAll()){
//			System.out.println(Estudiantes);

	}

}
