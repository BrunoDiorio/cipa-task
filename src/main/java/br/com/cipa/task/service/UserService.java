package br.com.cipa.task.service;

import br.com.cipa.task.client.ZendeskClient;
import br.com.cipa.task.dto.UsersDTO;
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
    private final ZendeskClient zendeskClient;

    @Autowired
    public UserService(final UserRepository userRepository, final ZendeskClient zendeskClient) {
    	Assert.notNull(userRepository, "Repository must not be null!");
        this.userRepository = userRepository;
        this.zendeskClient = zendeskClient;
    }

    public Page<UsersDTO> findAllUsersToSave(Pageable pageable) {
    	return this.userRepository.findAllUsersBySincronizadoFalseAndIdIsNull(pageable);
    }

    public Page<UsersDTO> findAllUsersToUpdate(Pageable pageable) {
    	return this.userRepository.findAllUsersBySincronizadoFalseAndIdIsNotNull(pageable);
    }

    public void updateUsers() {
    	Page<UsersDTO> usersPage;
    	do {
    		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.ASC, "externalId");
    		usersPage = findAllUsersToUpdate(pageable);
            if (usersPage.isEmpty()) break;

            zendeskClient.saveUsers(usersPage.getContent());
            usersPage.forEach(Users::wasSync);
            this.userRepository.saveAll(usersPage);
            usersPage.forEach(System.out::println);
    	} while(usersPage.hasNext());
    }
}
