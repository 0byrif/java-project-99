package hexlet.code.app.util;

import hexlet.code.app.model.Task;
import hexlet.code.app.model.TaskStatus;
import hexlet.code.app.model.User;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import net.datafaker.Faker;
import org.instancio.Instancio;
import org.instancio.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.instancio.Model;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ModelGenerator {

    private Model<User> userModel;

    private Model<TaskStatus> statusModel;

    private Model<Task> taskModel;

    @Autowired
    private Faker faker;

    @PostConstruct
    private void init() {
        userModel = Instancio.of(User.class)
                .ignore(Select.field(User::getId))
                .supply(Select.field(User::getFirstName), () -> faker.name().firstName())
                .supply(Select.field(User::getLastName), () -> faker.name().lastName())
                .supply(Select.field(User::getEmail), () -> faker.internet().emailAddress())
                .toModel();

        taskModel = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getName), () -> faker.gameOfThrones().house())
                .supply(Select.field(Task::getDescription), () -> faker.gameOfThrones().quote())
                .toModel();

        statusModel = Instancio.of(TaskStatus.class)
                .ignore(Select.field("id"))
                .ignore(Select.field("tasks"))
                .supply(Select.field("name"), () -> faker.animal().name())
                .supply(Select.field("slug"), () -> faker.lorem().word())
                .toModel();

    }
}
