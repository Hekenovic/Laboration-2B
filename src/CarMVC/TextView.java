
package CarMVC;
import Cars.Car;

import javax.swing.*;
import java.util.List;

public class TextView extends JLabel implements UpdateListener{

    private final ViewInterface viewInterface;

    public TextView(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void update() {

        List<Car> cars = viewInterface.getCars();
        String carInfoText = "";
        for (Car car : cars) {
            carInfoText += car.getModelName() + ": " + car.getCurrentSpeed() + ", ";
        }
        this.setText(carInfoText);
    }
}
