package br.com.cipa.task.repository;

import br.com.cipa.task.dto.UsersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cipa.task.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<UsersDTO, Long> {

    Page<Users> findAllUsersBySincronizadoFalseAndIdIsNull(Pageable pageable);

    Page<Users> findAllUsersBySincronizadoFalseAndIdIsNotNull(Pageable pageable);
}
