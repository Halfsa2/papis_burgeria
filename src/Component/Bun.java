package Component;

import javax.swing.*;

public class Bun extends Component{
    private boolean top;
    public Bun(boolean top) {
        this.top = top;
        if(top){
            this.img = new ImageIcon(getClass().getResource(this.source +"topBun.png"));
        }else{
            this.img = new ImageIcon(getClass().getResource(this.source+"bottomBun.png"));
        }
    }
    public boolean isTop() {
        return top;
    }
    public String toString(){
        return "Bun";
    }
}
