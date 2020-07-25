package br.com.cipa.task.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cipa.task.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Page<Users> findAllUsersBySincronizadoFalseAndIdZendeskIsNull(Pageable pageable);
    
    Page<Users> findAllUsersBySincronizadoFalseAndIdZendeskIsNotNull(Pageable pageable);
}
