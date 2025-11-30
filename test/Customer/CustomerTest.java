package Customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void orderNullByDefault(){
        Customer customer = new Customer(1);
        Assertions.assertNull(customer.getOrder());
    }
    @Test
    void placeOrder() {
        Customer customer = new Customer(1);
        customer.placeOrder();
        Assertions.assertNotNull(customer.getOrder());
    }
}