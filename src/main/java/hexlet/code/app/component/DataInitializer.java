package hexlet.code.app.component;

import hexlet.code.app.model.Label;
import hexlet.code.app.model.TaskStatus;
import hexlet.code.app.model.User;
import hexlet.code.app.repository.LabelRepository;
import hexlet.code.app.repository.TaskStatusRepository;
import hexlet.code.app.repository.UserRepository;
import hexlet.code.app.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) {

        if (userRepository.findByEmail("hexlet@example.com").isEmpty()) {
            User userData = new User();
            userData.setEmail("hexlet@example.com");
            userData.setPasswordDigest("qwerty");
            userService.createUser(userData);
        }


        if (taskStatusRepository.count() == 0) {
            createAndSaveStatus("Draft", "draft");
            createAndSaveStatus("To Review", "to_review");
            createAndSaveStatus("To Be Fixed", "to_be_fixed");
            createAndSaveStatus("To Publish", "to_publish");
            createAndSaveStatus("Published", "published");
        }

        if (labelRepository.count() == 0) {
            createAndSaveLabel("feature");
            createAndSaveLabel("bug");
        }
    }

    private void createAndSaveStatus(String name, String slug) {
        TaskStatus status = new TaskStatus();
        status.setName(name);
        status.setSlug(slug);
        taskStatusRepository.save(status);
    }

    private void createAndSaveLabel(String name) {
        Label label = new Label();
        label.setName(name);
        labelRepository.save(label);
    }
}
