package CarMVC;

import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrRemoveCarButton {

    private final ControlInterface model;

    public AddOrRemoveCarButton(AddOrRemoveButtonView view, ControlInterface model, int X) {
        this.model = model;
        initializeButtons(view, X);
    }

    private void initializeButtons(AddOrRemoveButtonView view, int X) {

        view.addListenerToSaabButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar(new Saab95());
            }
        });

        view.addListenerToVolvoButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar(new Volvo240());
            }
        });

        view.addListenerToScaniaButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar(new Scania());
            }
        });

        view.addListenerToRemoveButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeCar();
            }
        });
    }

}
