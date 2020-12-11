package CarMVC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimeController implements ActionListener {
    private Timer timer;
    private ControlInterface model;

    public TimeController(ControlInterface model) {
        timer = new Timer(20, this);
        this.model = model;
    }

    public void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();
    }
}
