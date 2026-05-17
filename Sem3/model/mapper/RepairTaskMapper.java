package Sem3.model.mapper;
import Sem3.model.dto.RepairTaskDTO;
import Sem3.model.domain.RepairTask;

public class RepairTaskMapper {
    
    public static RepairTaskDTO toDTO(RepairTask repairTask) {
        return new RepairTaskDTO(repairTask.getDescription(), repairTask.getCost());
    }
}
