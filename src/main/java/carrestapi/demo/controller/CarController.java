package carrestapi.demo.controller;

import carrestapi.demo.Car;
import carrestapi.demo.CarRepository;
import carrestapi.demo.CarService;
import carrestapi.demo.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        if (car == null) {
            throw new ApiException("Invalid car data", HttpStatus.BAD_REQUEST);
        }
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCar(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/cars/deleteAll")
    public ResponseEntity<Void> removeAllCars() {
        carService.deleteAllCars();
        return ResponseEntity.noContent().build();
    }
}
