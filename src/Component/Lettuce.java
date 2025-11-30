package Component;

import javax.swing.*;

public class Lettuce extends Component{
    public Lettuce() {
        img = new ImageIcon(getClass().getResource(source+"lettuce.png"));
    }
    public String toString(){
        return "Lettuce";
    }
}
