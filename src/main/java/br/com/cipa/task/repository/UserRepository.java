package br.com.cipa.task.repository;

import br.com.cipa.task.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAllUsersBySincronizadoTrue();
}
