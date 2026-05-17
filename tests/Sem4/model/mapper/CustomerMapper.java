package Sem4.model.mapper;
import Sem4.model.domain.Customer;
import Sem4.model.dto.CustomerDTO;
/**
 * A mapper class for converting between Customer domain objects and CustomerDTO data transfer objects.
 * This class provides a static method to convert a Customer object into a CustomerDTO, which can be used for transferring customer data between different layers of the application.
 */
public class CustomerMapper {
    
    /**
     * Converts a Customer domain object into a CustomerDTO.
     * @param customer The Customer object to convert.
     * @return A CustomerDTO containing the details of the customer.
     */
    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getName(), customer.getOrderNumber(), customer.getEmail(), BikeMapper.toDTO(customer.getBike()));
    }
}
