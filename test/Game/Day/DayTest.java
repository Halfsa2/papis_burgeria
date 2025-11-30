package Game.Day;

import Customer.Customer;
import Game.Day.Burger.Burger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {
    Day day;
    @BeforeEach
    void setUp() {
        day = new Day(2);
    }
    @Test
    void generateCustomer() {
        Assertions.assertEquals(1,day.getCustomers().size());
        day.generateCustomer();
        Assertions.assertEquals(2,day.getCustomers().size());
    }

    @Test
    void isDone() {
        assertFalse(day.isDone());
        day.generateCustomer();
        Assertions.assertTrue(day.isDone());
    }

    @Test
    void addBurger() {
        Burger burger = new Burger();
        day.addBurger(burger);
        List<Burger> expected = new ArrayList<>();
        expected.add(burger);
        Assertions.assertEquals(expected,day.getBurgers());
    }

    @Test
    void increaseIncome() {
        day.increaseIncome(200);
        assertEquals(200,day.getProfit());
    }

    @Test
    void setCurrentCustomer() {
        Customer customer = new Customer(1);
        day.setCurrentCustomer(customer);
        assertEquals(customer,day.getCurrentCustomer());
    }
}