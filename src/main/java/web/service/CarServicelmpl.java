package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.DAOCar;
import web.DAO.DAOCarlmpl;
import web.model.Car;
import java.util.List;
@Service
public class CarServicelmpl implements CarSevice {
    @Autowired
    private DAOCar daoCar;
    @Override
    public List<Car> index() {
        return daoCar.index();
    }

    @Override
    public List<Car> show(int id) {
        return daoCar.show(id);
    }
}
