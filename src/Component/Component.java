package Component;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class Component implements Serializable {
    public String source = "/images/components/";
    protected transient ImageIcon img;
    public Component(){    }
    public Image getImg(){
        return img.getImage();
    }
    public abstract String toString();
}
