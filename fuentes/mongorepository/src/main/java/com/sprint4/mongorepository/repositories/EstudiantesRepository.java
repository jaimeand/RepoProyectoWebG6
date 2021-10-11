package com.sprint4.mongorepository.repositories;

import com.sprint4.mongorepository.models.Estudiantes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiantesRepository extends MongoRepository<Estudiantes,String> {
}
