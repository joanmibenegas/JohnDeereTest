package johndeere.test.service;

import johndeere.test.entity.MachineEntity;

import java.util.Optional;

public interface MachineService {
    void createMachine(String machineId);

    Optional<MachineEntity> findMachineById(String idMachine);
}
