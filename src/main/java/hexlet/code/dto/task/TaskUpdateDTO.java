package hexlet.code.app.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.List;

@Getter
@Setter
public class TaskUpdateDTO {

    private JsonNullable<List<Long>> taskLabelIds;

    private JsonNullable<Long> assigneeId;

    @NotBlank
    private JsonNullable<String> title;

    private JsonNullable<String> content;

    private JsonNullable<Integer> index;

    @NotNull
    private JsonNullable<String> status;
}