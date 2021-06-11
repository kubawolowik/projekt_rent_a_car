package kw.projekt.controller;

import kw.projekt.model.car.projection.OurCarsPageCar;
import kw.projekt.service.car.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OurCarsController {

    // default request parameters value
    private static final String DEFAULT_PAGE = "1";
    private static final String DEFAULT_TYPE = "All";
    private static final String DEFAULT_BRAND = "All";
    private static final String DEFAULT_MODEL = "All";
    private static final String DEFAULT_FUEL = "All";
    private static final String DEFAULT_SORT = "price";
    private static final String DEFAULT_DIR = "desc";
    private static final String DEFAULT_STATE = "All";

    // dependencies
    private final CarService carService;
    private final TypeService typeService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final FuelTypeService fuelTypeService;

    @Autowired
    public OurCarsController(CarService carService, TypeService typeService, BrandService brandService, ModelService modelService, FuelTypeService fuelTypeService) {
        this.carService = carService;
        this.typeService = typeService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.fuelTypeService = fuelTypeService;
    }

    @RequestMapping("/our-cars")
    public String showOurCarsPage(
            @RequestParam(name = "page", defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(name = "type", defaultValue = DEFAULT_TYPE) String carType,
            @RequestParam(name = "brand", defaultValue = DEFAULT_BRAND) String carBrand,
            @RequestParam(name = "model", defaultValue = DEFAULT_MODEL) String carModel,
            @RequestParam(name = "fuel", defaultValue = DEFAULT_FUEL) String carFuelType,
            @RequestParam(name = "sort", defaultValue = DEFAULT_SORT) String sortBy,
            @RequestParam(name = "dir", defaultValue = DEFAULT_DIR) String sortDirection,
            @RequestParam(name = "state", defaultValue = DEFAULT_STATE) String carState,
            Model model) {

        // Check for negative page
        if (page < 1) page = 1;

        // Get page of cars
        Page<OurCarsPageCar> pageCars = carService.getOurCarsPageCars(
                carType.toLowerCase(), carBrand.toLowerCase(),
                carModel.toLowerCase(), carFuelType.toLowerCase(),
                sortBy.toLowerCase(), sortDirection.toLowerCase(),
                carState.toLowerCase(), page - 1);

        // Get list of cars from page
        List<OurCarsPageCar> content = pageCars.getContent();

        // Get number of cars, available cars and not available cars
        long total = carService.getNumberOfCars();
        long available = carService.getNumberOfAvailableCars();
        long nonAvailable = total - available;

        // Add number to model
        model.addAttribute("all_results", total);
        model.addAttribute("available", available);
        model.addAttribute("nonAvailable", nonAvailable);
        model.addAttribute("allPages", pageCars.getTotalPages());

        // Add request parameters into model (check if param is equals its default value and add result into model)
        model.addAttribute("pageParam", new Parameter("" + page, DEFAULT_PAGE, ("" + page).toLowerCase().equals(DEFAULT_PAGE.toLowerCase())));
        model.addAttribute("typeParam", new Parameter(carType, DEFAULT_TYPE, carType.toLowerCase().equals(DEFAULT_TYPE.toLowerCase())));
        model.addAttribute("brandParam", new Parameter(carBrand, DEFAULT_BRAND, carBrand.toLowerCase().equals(DEFAULT_BRAND.toLowerCase())));
        model.addAttribute("modelParam", new Parameter(carModel, DEFAULT_MODEL, carModel.toLowerCase().equals(DEFAULT_MODEL.toLowerCase())));
        model.addAttribute("fuelParam", new Parameter(carFuelType, DEFAULT_FUEL, (carFuelType.toLowerCase().equals(DEFAULT_FUEL.toLowerCase()))));
        model.addAttribute("sortParam", new Parameter(sortBy, DEFAULT_SORT, (sortBy.toLowerCase().equals(DEFAULT_SORT.toLowerCase()))));
        model.addAttribute("dirParam", new Parameter(sortDirection, DEFAULT_DIR, (sortDirection.toLowerCase().equals(DEFAULT_DIR.toLowerCase()))));
        model.addAttribute("stateParam", new Parameter(carState, DEFAULT_STATE, (carState.toLowerCase().equals(DEFAULT_STATE.toLowerCase()))));

        // Add cars list into model
        model.addAttribute("cars", content);

        // Add to model list of available items for searching
        model.addAttribute("carTypes", typeService.getOurCarsPageTypes());
        model.addAttribute("carBrands", brandService.getOurCarsPageBrands());
        model.addAttribute("carModels", modelService.getOurCarsPageModels(carBrand));
        model.addAttribute("carFuel", fuelTypeService.getOurCarsPageFuelTypes());

        return "our-cars";
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public class Parameter {
        private String value;
        private String defaultValue;
        private boolean equalsDefaultValue;
    }
}
