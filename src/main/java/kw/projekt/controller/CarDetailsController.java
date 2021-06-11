package kw.projekt.controller;

import kw.projekt.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarDetailsController {

    @Autowired
    private CarService carService;

    @RequestMapping("/car-details/{carId}")
    public String showCarDetailsPage(@PathVariable("carId") int carId, Model model) {
        model.addAttribute("car", carService.getCarDetails(carId));
        return "car-details";
    }
}