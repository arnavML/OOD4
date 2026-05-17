package Sem3.model.mapper;
import java.util.ArrayList;
import java.util.List;

import Sem3.model.dto.RepairOrderDTO;
import Sem3.model.dto.RepairTaskDTO;
import Sem3.model.domain.RepairOrder;
import Sem3.model.domain.RepairTask;


public class RepairOrderMapper {
    
    public static RepairOrderDTO toDTO(RepairOrder repairOrder) {
        List<RepairTaskDTO> repairTasks = new ArrayList<>();
        for (RepairTask task : repairOrder.getRepairTasks()) {
            repairTasks.add(RepairTaskMapper.toDTO(task));
        }

        return new RepairOrderDTO.Builder(CustomerMapper.toDTO(repairOrder.getCustomer()), repairTasks)
                .setDescription(repairOrder.getDescription())
                .setTotalCost(repairOrder.getTotalCost())
                .setStatus(repairOrder.getStatus())
                .setDate(repairOrder.getDate())
                .setDiagnosticReport(repairOrder.getDiagnosticReport())
                .build();
    }
}
