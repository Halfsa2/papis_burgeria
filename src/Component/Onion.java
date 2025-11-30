package Component;

import javax.swing.*;

public class Onion extends Component{
    public Onion(){
        img = new ImageIcon(getClass().getResource(source+"onion.png"));
    }
    public String toString(){
        return "Onion";
    }
}
