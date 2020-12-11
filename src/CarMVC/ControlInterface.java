package CarMVC;

import Cars.Car;
import Cars.Saab95;
import Cars.Scania;

public interface ControlInterface {

    void gas(int amount);

    void brake(int amount);

    void setTurboOn();

    void setTurboOff();

    void tiltUp();

    void tiltDown();

    void startEngine();

    void stopEngine();

    void update();

    void addCar(Car car);

    void removeCar();

}
