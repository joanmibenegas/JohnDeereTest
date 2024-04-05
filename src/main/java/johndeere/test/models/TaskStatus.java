package johndeere.test.models;

import johndeere.test.models.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatus implements Serializable, BaseDTO {

    private String taskId;
    private String taskName;
    private float percentageComplete;
    private Status status;

    public enum Status {
        SUBMITTED, STARTED, RUNNING, FINISHED, TERMINATED
    }
}
