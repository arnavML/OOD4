package Sem3.model.mapper;
import Sem3.model.dto.BikeDTO;
import Sem3.model.domain.Bike;

/**
 * A mapper class for converting between Bike domain objects and BikeDTO data transfer objects.
 * This class provides a static method to convert a Bike object into a BikeDTO, which can be used for transferring bike data between different layers of the application.
 */
public class BikeMapper {
   
    /**
    * Converts a Bike domain object into a BikeDTO.
    * @param bike The Bike object to convert.
    * @return A BikeDTO containing the details of the bike.
    */
    public static BikeDTO toDTO(Bike bike) {
        return new BikeDTO(bike.getBrand(), bike.getModel(), bike.getSerialNumber(), bike.getOrderNumber());
    }
}
