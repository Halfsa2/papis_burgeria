package Component;

import javax.swing.*;

public class Tomato extends Component{
    public Tomato(){
        img = new ImageIcon(getClass().getResource(source+"tomato.png"));
    }
    public String toString(){
        return "Tomato";
    }
}
