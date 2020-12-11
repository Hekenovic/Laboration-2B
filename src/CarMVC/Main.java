package CarMVC;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import Cars.*;

public class Main {

    public static void main(String[] args) {

        int X = 800;
        int Y = 800;

        JFrame frame = new JFrame();

        frame.setTitle("CarSim 2.0");
        frame.setPreferredSize(new Dimension(X,Y));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        CarModel model = new CarModel(new Dimension(X, Y-240));
        CarViewer viewer = new CarViewer(model, new Dimension(X, Y-240));

        TextView textView = new TextView(model);

        model.addListeners(viewer);

        frame.add(viewer);

        CarController buttons = new CarController(model, X);

        frame.add(buttons);

        TimeController timer = new TimeController(model);

        AddOrRemoveCarButton addOrRemoveCarButton = new AddOrRemoveCarButton(model, X);
        frame.add(addOrRemoveCarButton);

        model.addCar(new Saab95());
        model.addCar(new Volvo240());

        // Make the frame pack all it's components by respecting the sizes if possible.
        frame.pack();
        model.addListeners(textView);
        frame.add(textView);
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed



        timer.start();
    }
}
