package web.service;

import web.model.Car;
import java.util.List;

public interface CarSevice {
    List<Car> index();
    List<Car> show(int id);
}
