package com.example.RestAPI.repository;

import com.example.RestAPI.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    // Métodos de CRUD já estão disponíveis
    //findAll, findById, save, deleteById

    List<UserEntity> findByNomeIgnoreCase(String nome);
    List<UserEntity> findByEmailIgnoreCase(String email);

    List<UserEntity> findByNomeAndEmailAllIgnoreCase(String nome, String email);

    List<UserEntity> findByNomeStartingWithIgnoreCase(String prefix);

    List<UserEntity> findByNomeContainingIgnoreCase(String substring);

}
