package hexlet.code.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.List;

@Getter
@Setter
public class TaskUpdateDTO {
    @NotBlank
    private JsonNullable<String> title;

    private JsonNullable<Integer> index;

    private JsonNullable<String> content;

    @NotNull
    private JsonNullable<String> status;

    private JsonNullable<Long> assigneeId;

    private JsonNullable<List<Long>> taskLabelIds;
}
