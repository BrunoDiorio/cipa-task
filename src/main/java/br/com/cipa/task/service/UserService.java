package br.com.cipa.task.service;

import br.com.cipa.task.entity.UserEntity;
import br.com.cipa.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return this.userRepository.findAllUsersBySincronizadoTrue();
    }
}
