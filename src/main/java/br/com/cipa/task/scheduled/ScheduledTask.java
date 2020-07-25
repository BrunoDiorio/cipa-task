package br.com.cipa.task.scheduled;

import br.com.cipa.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private final UserService userService;

    @Autowired
    public ScheduledTask(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedRate = 1000)
    private void test() {
//        userService.updateUsers();
    }
}
