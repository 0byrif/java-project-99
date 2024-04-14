package hexlet.code.specification;


import hexlet.code.dto.task.TaskParamsDTO;
import hexlet.code.model.Task;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TaskSpecification {

    public Specification<Task> build(TaskParamsDTO params) {
        return withTaskId(params.getAssigneeId())
                .and(withTaskLabelId(params.getLabelId())
                        .and(withTitleCont(params.getTitleCont())))
                .and(withStatus(params.getStatus()));

    }

    private Specification<Task> withTaskId(Long taskId) {
        return (root, query, cb) -> taskId == null
                ? cb.conjunction()
                : cb.equal(root.get("assignee").get("id"), taskId);
    }

    private Specification<Task> withTaskLabelId(Long taskId) {
        return (root, query, cb) -> taskId == null
                ? cb.conjunction()
                : cb.equal(root.get("labels").get("id"), taskId);
    }

    private Specification<Task> withTitleCont(String string) {
        return (root, query, cb) -> string == null
                ? cb.conjunction()
                : cb.like(cb.lower(root.get("name")), "%" + string.toLowerCase() + "%");
    }

    private Specification<Task> withStatus(String status) {
        return (root, query, cb) -> status == null
                ? cb.conjunction()
                : cb.equal(root.get("taskStatus").get("slug"), status);
    }
}
