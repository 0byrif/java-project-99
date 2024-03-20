package hexlet.code.app.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Schema(description = "Сущность Задач")
public class TaskDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String title;

    private int index;

    private String content;

    private String status;

    private Set<Long> taskLabelIds;

    @JsonProperty("assignee_id")
    private Long assigneeId;

    private LocalDate createdAt;
}
