package Game.Day.Order;

import Component.Component;
import Component.Bun;
import Burger.Burger;
import Order.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void compareBurgerToOrder() {
        Order order = new Order(1);
        Burger burger = new Burger();
        List<Component> components = new ArrayList<>(order.getBurger().getComponents());
        components.removeLast();
        components.add(new Bun(false));
        Collections.reverse(components);
        burger.setComponents(components);
        int score = order.compareBurgerToOrder(burger);
        assertEquals(burger.getComponents().size()-1, score);

    }
}