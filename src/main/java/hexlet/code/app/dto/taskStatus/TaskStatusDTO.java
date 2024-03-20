package hexlet.code.app.dto.taskStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Сущность Статусов")
public class TaskStatusDTO {

    private Long id;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Слаг")
    private String slug;

    @Schema(description = "Дата создания")
    private LocalDate createdAt;
}
