package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Collections.shuffle;

@Repository
public class DAOCarlmpl implements DAOCar {
    private List<Car> car;
    private static int CAR_COUNT;

    public DAOCarlmpl(List<Car> car) {
        this.car = car;
        car.add(new Car("Porshe","Carrera",CAR_COUNT++));
        car.add(new Car("Ferrari","Tusca",CAR_COUNT++));
        car.add(new Car("Maseratti","Borla",CAR_COUNT++));
        car.add(new Car("Aston Martin","Vanquish",CAR_COUNT++));
        car.add(new Car("Alfa Romeo","Brerra",CAR_COUNT++));

    }
    @Override
    public List<Car> index() {
        return car;
    }

    @Override
    public List<Car> show(int id) {
        Collections.shuffle(car);
        return (id>=1&&id<=5)?car.subList(0, id):car;
    }
}
