package Component;

import javax.swing.*;

public class Pickle extends Component{
    public Pickle(){
        img = new ImageIcon(getClass().getResource(source+"pickle.png"));
    }
    public String toString(){
        return "Pickle";
    }
}
