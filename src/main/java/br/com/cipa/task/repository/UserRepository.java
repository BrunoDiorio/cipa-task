package br.com.cipa.task.repository;

import br.com.cipa.task.dto.UsersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersDTO, Long> {

    Page<UsersDTO> findAllUsersBySincronizadoFalseAndIdIsNull(Pageable pageable);

    Page<UsersDTO> findAllUsersBySincronizadoFalseAndIdIsNotNull(Pageable pageable);
}
