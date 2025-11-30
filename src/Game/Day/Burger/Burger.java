package Game.Day.Burger;

import Component.Component;
import Component.Bun;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Burger implements Serializable {
    private List<Component> components;
    public Burger() {
        components = new ArrayList<>();
        components.add(new Bun(false));
    }
    public List<Component> getComponents() {
        return components;
    }
    public void addComponent(Component component) {
        components.add(component);
    }
    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
