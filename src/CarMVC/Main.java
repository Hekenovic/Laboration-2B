package CarMVC;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import Cars.*;

public class Main {

    public static void main(String[] args) {

        int X = 800;
        int Y = 800;

        SimFrame frame = new SimFrame(X, Y);

        CarModel model = new CarModel(new Dimension(X, Y-240));
        CarViewer viewer = new CarViewer(model, new Dimension(X, Y-240));

        TextView textView = new TextView(model);

        model.addListeners(viewer);

        frame.add(viewer);

        CarButtonView buttonView = new CarButtonView(X);
        CarController buttons = new CarController(buttonView, model, X);

        frame.add(buttonView);

        TimeController timer = new TimeController(model);

        AddOrRemoveButtonView addOrRemoveButtonView = new AddOrRemoveButtonView(X);

        AddOrRemoveCarButton addOrRemoveCarButton = new AddOrRemoveCarButton(addOrRemoveButtonView, model, X);
        frame.add(addOrRemoveButtonView);

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
