package hexlet.code.util;

import hexlet.code.model.Label;
import hexlet.code.model.Task;
import hexlet.code.model.TaskStatus;
import hexlet.code.model.User;
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
    private Model<Label> labelModel;


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

        statusModel = Instancio.of(TaskStatus.class)
                .ignore(Select.field("id"))
                .ignore(Select.field("tasks"))
                .supply(Select.field("name"), () -> faker.animal().name())
                .supply(Select.field("slug"), () -> faker.lorem().word())
                .toModel();

        taskModel = Instancio.of(Task.class)
                .ignore(Select.field("id"))
                .ignore(Select.field("taskStatus"))
                .ignore(Select.field("assignee"))
                .ignore(Select.field("labels"))
                .supply(Select.field("name"), () -> faker.beer().name())
                .supply(Select.field("index"), () -> faker.number().positive())
                .supply(Select.field("description"), () -> faker.beer().brand())
                .toModel();

        labelModel = Instancio.of(Label.class)
                .ignore(Select.field("id"))
                .ignore(Select.field("tasks"))
                .supply(Select.field("name"), () -> faker.lorem().characters(3, 1000))
                .toModel();
    }
}
