package hexlet.code.app.controller.api;


import hexlet.code.app.dto.taskStatus.TaskStatusCreateDTO;
import hexlet.code.app.dto.taskStatus.TaskStatusDTO;
import hexlet.code.app.dto.taskStatus.TaskStatusUpdateDTO;
import hexlet.code.app.service.TaskStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Статусы", description = "Методы для работы со статусами")
public class TaskStatusController {

    @Autowired
    private TaskStatusService taskStatusService;

    @GetMapping("/task_statuses")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Вывод всех статусов")
    public ResponseEntity<List<TaskStatusDTO>> index() {
        var taskStatus = taskStatusService.getAllTaskStatus();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(taskStatus.size()))
                .body(taskStatus);
    }

    @GetMapping("/task_statuses/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получение статуса по идентификатору")
    public TaskStatusDTO show(@PathVariable Long id) {
        return taskStatusService.getTaskStatusById(id);
    }

    @PostMapping("/task_statuses")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание нового статуса")
    public TaskStatusDTO create(@Valid @RequestBody TaskStatusCreateDTO statusData) {
        return taskStatusService.createTaskStatus(statusData);
    }

    @PutMapping("/task_statuses/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Обновление статуса")
    public TaskStatusDTO update(@RequestBody @Valid TaskStatusUpdateDTO statusData, @PathVariable Long id) {
        return taskStatusService.updateTaskStatus(statusData, id);
    }

    @DeleteMapping("/task_statuses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление статуса")
    public void delete(@PathVariable Long id) {
        taskStatusService.delete(id);
    }
}
