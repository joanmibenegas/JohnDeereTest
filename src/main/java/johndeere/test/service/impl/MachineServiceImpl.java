package johndeere.test.service.impl;

import johndeere.test.entity.MachineEntity;
import johndeere.test.repository.MachineRepository;
import johndeere.test.service.MachineService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log
public class MachineServiceImpl implements MachineService {
    private final Logger logger = LoggerFactory.getLogger(MachineServiceImpl.class);
    final MachineRepository machineRepository;

    MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public void createMachine(String machineId) {
        MachineEntity machineEntity = new MachineEntity(machineId);
        machineRepository.save(machineEntity);
        logger.info("Session created: " + machineEntity);
    }

    @Override
    public Optional<MachineEntity> findMachineById(String idMachine) {
        return machineRepository.findById(idMachine);
    }
}
