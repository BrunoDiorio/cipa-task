package br.com.cipa.task.service;

import br.com.cipa.task.entity.Users;
import br.com.cipa.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
    	Assert.notNull(userRepository, "Repository must not be null!");
        this.userRepository = userRepository;
    }

    public Page<Users> findAllUsersToSave(Pageable pageable) {
    	return this.userRepository.findAllUsersBySincronizadoFalseAndIdIsNull(pageable);
    }

    public Page<Users> findAllUsersToUpdate(Pageable pageable) {
    	return this.userRepository.findAllUsersBySincronizadoFalseAndIdIsNotNull(pageable);
    }

    public void updateUsers() {
    	Page<Users> usersPage;
    	int page = 0;
    	do {
    		Pageable pageable = PageRequest.of(page, 5, Sort.Direction.ASC, "externalId");
    		usersPage = findAllUsersToUpdate(pageable);
    		usersPage.forEach(System.out::println);
            page++;
    	} while(usersPage.hasNext());
    }
}
