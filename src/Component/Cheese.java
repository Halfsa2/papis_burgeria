package Component;

import javax.swing.*;

public class Cheese extends Component{
    public Cheese(){
        img = new ImageIcon(getClass().getResource(source +"cheese.png"));
    }
    public String toString(){
        return "Cheese";
    }
}
