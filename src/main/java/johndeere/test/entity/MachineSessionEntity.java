package johndeere.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@IdClass(MachineSessionIdKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineSessionEntity implements Serializable {
    @Id
    @ManyToOne
    private MachineEntity machine;

    @Id
    @ManyToOne
    private SessionEntity session;
}
