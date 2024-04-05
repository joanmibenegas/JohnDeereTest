package johndeere.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineSessionIdKey implements Serializable {
    private SessionEntity session;
    private MachineEntity machine;
}
