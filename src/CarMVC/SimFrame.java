package CarMVC;

import javax.swing.*;
import java.awt.*;

public class SimFrame extends JFrame {
    public SimFrame(int X, int Y) {
        this.setTitle("CarSim 2.0");
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }
}
