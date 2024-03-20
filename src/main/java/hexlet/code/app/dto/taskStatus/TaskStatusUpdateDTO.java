package hexlet.code.app.dto.taskStatus;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

@Getter
@Setter
public class TaskStatusUpdateDTO {

    @Column(unique = true)
    @NotBlank
    private JsonNullable<String> name;

    @Column(unique = true)
    @NotBlank
    private JsonNullable<String> slug;
}
