package CarMVC;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController{

    private final ControlInterface model;
    private int gasAmount = 0;

    // Constructor
    public CarController(CarButtonView view, ControlInterface model, int X){
        this.model = model;
        initComponents(view, X);
    }

    // Sets everything in place and fits everything
    private void initComponents(CarButtonView view, int X) {

        view.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        view.addListenerGasButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(gasAmount);
            }
        });

        view.addListenerBrakeButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        view.addListenerTurboOnButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTurboOn();
            }
        });

        view.addListenerTurboOffButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTurboOff();
            }
        });

        view.addListenerLiftBedButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.tiltUp();
            }
        });

        view.addListenerLowerBedButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.tiltDown();
            }
        });

        view.addListenerStartButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startEngine();
            }
        });

        view.addListenerStopButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopEngine();
            }
        });
    }
}
