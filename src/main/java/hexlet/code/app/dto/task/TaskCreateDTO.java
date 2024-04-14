package hexlet.code.app.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TaskCreateDTO {

    private Integer index;

    private Set<Long> taskLabelIds;

    @NotBlank
    @Size(min = 1)
    private String title;

    private String content;

    @NotNull
    private String status;

    @NotNull
    @JsonProperty("assignee_id")
    private Long assigneeId;
}
