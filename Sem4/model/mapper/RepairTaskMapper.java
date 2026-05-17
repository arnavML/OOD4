package Sem4.model.mapper;
import Sem4.model.domain.RepairTask;
import Sem4.model.dto.RepairTaskDTO;

/**
 * A mapper class for converting between RepairTask domain objects and RepairTaskDTO data transfer objects.
 * This class provides a static method to convert a RepairTask object into a RepairTaskDTO, which can be used for transferring repair task data between different layers of the application.
 */
public class RepairTaskMapper {
   
    /**
    * Converts a RepairTask domain object into a RepairTaskDTO.
    * @param repairTask The RepairTask object to convert.
    * @return A RepairTaskDTO containing the details of the repair task.
    */
    public static RepairTaskDTO toDTO(RepairTask repairTask) {
        return new RepairTaskDTO(repairTask.getDescription(), repairTask.getCost());
    }
}
