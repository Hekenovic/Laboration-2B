package CarMVC;

import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrRemoveCarButton extends JPanel {

    private final ControlInterface model;


    private final JButton addSaabButton = new JButton("Add New Saab");
    private final JButton addVolvoButton = new JButton("Add New Volvo");
    private final JButton addScaniaButton = new JButton("Add New Scania");
    private final JButton RemoveCarButton = new JButton("Remove Car");

    public AddOrRemoveCarButton(ControlInterface model, int X) {
        this.model = model;
        initializeButtons(X);
    }

    private void initializeButtons(int X) {

        addSaabButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addSaabButton);
        addSaabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar(new Saab95());
            }
        });

        addVolvoButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addVolvoButton);
        addVolvoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar(new Volvo240());
            }
        });

        addScaniaButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addScaniaButton);
        addScaniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar(new Scania());
            }
        });

        RemoveCarButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(RemoveCarButton);
        RemoveCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeCar();
            }
        });
    }

}
