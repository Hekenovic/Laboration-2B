package CarMVC;

import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOrRemoveButtonView extends JPanel {

    private final JButton addSaabButton = new JButton("Add New Saab");
    private final JButton addVolvoButton = new JButton("Add New Volvo");
    private final JButton addScaniaButton = new JButton("Add New Scania");
    private final JButton RemoveCarButton = new JButton("Remove Car");

    public AddOrRemoveButtonView(int X) {
        initializeButtons(X);
    }

    private void initializeButtons(int X) {

        addSaabButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addSaabButton);

        addVolvoButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addVolvoButton);

        addScaniaButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(addScaniaButton);

        RemoveCarButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(RemoveCarButton);
    }

    public void addListenerToSaabButton(ActionListener listener) {
        addSaabButton.addActionListener(listener);
    }

    public void addListenerToVolvoButton(ActionListener listener) {
        addVolvoButton.addActionListener(listener);
    }

    public void addListenerToScaniaButton(ActionListener listener) {
        addScaniaButton.addActionListener(listener);
    }

    public void addListenerToRemoveButton(ActionListener listener) {
        RemoveCarButton.addActionListener(listener);
    }
}
