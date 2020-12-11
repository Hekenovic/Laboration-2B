package CarMVC;

import Cars.Car;
import Cars.Saab95;
import Cars.Scania;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarModel implements ControlInterface, ViewInterface {


    private List<Car> cars;
    private List<UpdateListener> updateListeners = new ArrayList<>();
    private Dimension modelDimension;
    private int y = 0;

    public CarModel(Dimension modelDimension) {
        cars = new ArrayList<>();
        this.modelDimension = modelDimension;
    }

    @Override
    public void addCar(Car car) {
        if (cars.size() < 10) {
            car.setYPosition(y);
            cars.add(car);
            y += 100;
        }
    }

    @Override
    public void removeCar() {
        if (cars.size() > 0)
            cars.remove(cars.get(0));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private void turnAroundIfOutside(Car car) {
        if (car.getXPosition() > modelDimension.getWidth() - 150 || car.getXPosition() < 0) {
            car.turnLeft();
            car.turnLeft();
        }
    }

    public void update() {
        for (Car car : cars) {
            turnAroundIfOutside(car);
            car.move();
        }
        notifyListeners();
    }

    private void notifyListeners() {
        for(UpdateListener listener : updateListeners) {
            listener.update();
        }
    }

    public void addListeners(UpdateListener listener) {
        updateListeners.add(listener);
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars)
            car.brake(brake);
    }

    public void setTurboOn(){
        for (Car car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    public void setTurboOff(){
        for (Car car : cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    public void tiltUp(){
        for (Car car : cars){
            if (car instanceof Scania)
                ((Scania) car).tiltUp();
        }
    }

    public void tiltDown(){
        for (Car car : cars){
            if (car instanceof Scania)
                ((Scania) car).tiltDown();
        }
    }

    public void startEngine(){
        for (Car car : cars)
            if (car.getCurrentSpeed() == 0)
                car.startEngine();
    }

    public void stopEngine(){
        for (Car car : cars)
            car.stopEngine();
    }
}
