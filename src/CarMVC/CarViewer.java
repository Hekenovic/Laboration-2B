package CarMVC;

import Cars.Car;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class CarViewer extends JPanel implements UpdateListener {

    private Map<Car, BufferedImage> imageMap = new HashMap();
    private ViewInterface model;


    public CarViewer(ViewInterface model, Dimension area) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(area);
        this.setBackground(Color.green);
        this.model = model;
    }

    private void updateImages(List<Car> cars) {

        List<Car> unUsedKeys = new ArrayList<>(imageMap.keySet());

        for (Car car : cars) {
            if (!imageMap.containsKey(car))  {
                try {
                    String path = "../pics/" + car.getModelName() + ".jpg"; // fixa detta om det går åt helvete
                    BufferedImage image = ImageIO.read(CarViewer.class.getResourceAsStream(path));
                    imageMap.put(car, image);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            unUsedKeys.remove(car);
        }

        for (Car carKey : unUsedKeys)
            imageMap.remove(carKey);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : imageMap.keySet()) {
            g.drawImage(imageMap.get(car), (int) car.getCurrentPosition().x, (int) car.getCurrentPosition().y,null);
        }
    }

    @Override
    public void update() {
        List<Car> carList = model.getCars();
        updateImages(carList);
        repaint();
    }
}
