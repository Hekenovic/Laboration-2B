package CarMVC;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarButtonView  extends JPanel {

    private final JPanel controlPanel = new JPanel();

    private final JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private final JLabel gasLabel = new JLabel("Amount of gas");
    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Scania Lift Bed");
    private final JButton lowerBedButton = new JButton("Lower Lift Bed");
    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarButtonView(int X){
        initComponents(X);
    }

    private void initComponents(int X) {

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        100);//step
        gasSpinner = new JSpinner(spinnerModel);

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);
    }

    public void addChangeListener(ChangeListener listener) {
        gasSpinner.addChangeListener(listener);
    }

    public void addListenerStopButton(ActionListener listener) {
        stopButton.addActionListener(listener);
    }

    public void addListenerStartButton(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void addListenerGasButton(ActionListener listener) {
        gasButton.addActionListener(listener);
    }

    public void addListenerTurboOnButton(ActionListener listener) {
        turboOnButton.addActionListener(listener);
    }

    public void addListenerLiftBedButton(ActionListener listener) {
        liftBedButton.addActionListener(listener);
    }

    public void addListenerBrakeButton(ActionListener listener) {
        brakeButton.addActionListener(listener);
    }

    public void addListenerTurboOffButton(ActionListener listener) {
        turboOffButton.addActionListener(listener);
    }

    public void addListenerLowerBedButton(ActionListener listener) {
        lowerBedButton.addActionListener(listener);
    }
}
