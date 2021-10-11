package com.sprint4.mongorepository.repositories;

import com.sprint4.mongorepository.models.Proyectos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends MongoRepository<Proyectos,String> {
}
