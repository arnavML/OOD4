package Sem4.model.mapper;
import java.util.ArrayList;
import java.util.List;

import Sem4.model.domain.RepairOrder;
import Sem4.model.domain.RepairTask;
import Sem4.model.dto.RepairOrderDTO;
import Sem4.model.dto.RepairTaskDTO;

/**
 * A mapper class for converting between RepairOrder domain objects and RepairOrderDTO data transfer objects.
 * This class provides a static method to convert a RepairOrder object into a RepairOrderDTO, which can be used for transferring repair order data between different layers of the application.
 */
public class RepairOrderMapper {
    
    /**
     * Converts a RepairOrder domain object into a RepairOrderDTO.
     * @param repairOrder The RepairOrder object to convert.
     * @return A RepairOrderDTO containing the details of the repair order.
     */
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
