package web.DAO;

import web.model.Car;
import java.util.List;

public interface DAOCar {
    List<Car> index();
    List<Car> show(int id);
}
