package hexlet.code.app.dto.task;

import hexlet.code.app.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class TaskParamsDTO {
    private String titleCont;
    private Long assigneeId;
    private TaskStatus status;
    private Long labelId;
}
