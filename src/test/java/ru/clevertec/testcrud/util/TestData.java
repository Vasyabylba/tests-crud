package ru.clevertec.testcrud.util;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import ru.clevertec.testcrud.domain.Car;
import ru.clevertec.testcrud.entity.CarEntity;
import ru.clevertec.testcrud.helper.DateSupplier;

import java.util.List;
import java.util.Random;

public class TestData {
    private static final DateSupplier DATE_SUPPLIER = new DateSupplierTestImpl();

    public static Car generateCar() {
        return Car.builder()
                .id(1L)
                .make("Lamborghini")
                .model("Aventador")
                .releaseDate(DATE_SUPPLIER.getCurrentDateTime())
                .build();
    }

    public static List<Car> generateCars() {
        Car car = TestData.generateCar();
        return List.of(car, car, car);
    }

    public static CarEntity generateCarEntity() {
        return CarEntity.builder()
                .id(1L)
                .make("Lamborghini")
                .model("Aventador")
                .releaseDate(DATE_SUPPLIER.getCurrentDateTime())
                .build();
    }

    public static List<CarEntity> generateCarEntities() {
        CarEntity carEntity = TestData.generateCarEntity();
        return List.of(carEntity, carEntity, carEntity);
    }

    public static Car generateRandomCar() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.randomize(FieldPredicates.named("id"), () -> new Random().nextLong(0, Long.MAX_VALUE));
        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(Car.class);
    }

    public static List<Car> generateRandomCars() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.randomize(FieldPredicates.named("id"), () -> new Random().nextLong(0, Long.MAX_VALUE));
        EasyRandom generator = new EasyRandom(parameters);
        return generator.objects(Car.class, 10).toList();
    }

    public static CarEntity generateRandomCarEntity() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.randomize(FieldPredicates.named("id"), () -> new Random().nextLong(0, Long.MAX_VALUE));
        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(CarEntity.class);
    }

    public static List<CarEntity> generateRandomCarEntities() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.randomize(FieldPredicates.named("id"), () -> new Random().nextLong(0, Long.MAX_VALUE));
        EasyRandom generator = new EasyRandom(parameters);
        return generator.objects(CarEntity.class, 10).toList();
    }
}
