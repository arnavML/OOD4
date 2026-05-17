package Sem3.model.mapper;
import Sem3.model.dto.BikeDTO;
import Sem3.model.domain.Bike;

public class BikeMapper {
    
    public static BikeDTO toDTO(Bike bike) {
        return new BikeDTO(bike.getBrand(), bike.getModel(), bike.getSerialNumber(), bike.getOrderNumber());
    }
}
