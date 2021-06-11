package kw.projekt;

import kw.projekt.model.authentication.Role;
import kw.projekt.model.authentication.User;
import kw.projekt.model.car.*;
import kw.projekt.service.authentication.RoleService;
import kw.projekt.service.authentication.UserService;
import kw.projekt.service.car.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InitTempData {

    @Autowired
    private StateService stateService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private CarService carService;

    @Autowired
    private TransmissionService transmissionService;

    @Autowired
    private DrivingGearService drivingGearService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public void initDatabaseItems() {
        CreateCar("Manual", 230, "2.3 TDI", 210d, "Disabled", "White", "Diesel", "Cabriolet", "C5 B8", "Audi",
                Arrays.asList("temp-car.jpg", "temp-car-2.jpg", "temp-car-3.jpg"),
                Arrays.asList("ABS", "ASR (traction control)", "ESP"));
        CreateCar("Automat", 120, "4.0 ecopower", 124.5d, "Available", "Black", "PB-98", "SUV", "GLA-45", "Mercedes",
                Arrays.asList("temp-car.jpg", "temp-car-5.jpg"),
                Arrays.asList("ABS", "ASR", "ESP", "Electric windshields", "Driver's airbag", "Power steering",
                        "Front parking sensors", "Reversing camera", "On-board computer", "Speed limiter", "System Start-Stop",
                        "Fog lights", "Cruise control", "CD", "Electrically adjustable mirrors", "Alarm", "Bluetooth",
                        "Parking sensors rear", "AUX socket", "Automatic air conditioning", "GPS navigation",
                        "Heated front seats", "Daytime running lights", "Xenon lights", "Multifunctional steering wheel",
                        "Factory radio", "Immobilizer", "Rain sensor", "Isofix", "Dual zone air conditioning", "Tinted windows"));
        CreateCar("Manual", 180, "Potato 2.0", 238.8d, "Available", "Black", "PB-98", "SUV", "A4", "Audi",
                new ArrayList<>(), Arrays.asList("ABS", "ASR", "Kotek", "Czupakabra"));


        Role role_admin = Role.builder().roleName("ROLE_ADMIN").build();
        roleService.addRole(role_admin);

        userService.addUser(User.builder()
                .username("admin@admin.com")
                .password("passw0rd")
                .roles(Collections.singletonList(role_admin))
                .build()
        );
    }

    private void CreateCar(
            String transName, int hp, String engine, double rentPrice, String statusName, String colorName,
            String fuelTypeName, String typeName, String modelName, String brandName, List<String> imagesNames,
            List<String> equipmentNames) {
        State state = getState(statusName, "Lorem ipsum dolor, sit amet consectetur adipisicing elit.");

        Color color = getColor(colorName);

        FuelType fuelType = getFuelType(fuelTypeName);

        Type type = getType(typeName, "Lorem ipsum dolor, sit amet consectetur adipisicing elit.");

        Model model = getModel(modelName, brandName);

        List<Image> images = getImages(imagesNames);

        List<Equipment> equipment = getEquipment(equipmentNames);

        Transmission transmission = getTransmission(transName);

        DrivingGear drivingGear = getDrivingGear("4x4");

        Random random = new Random();

        Car car = Car.builder()
                .model(model)
                .type(type)
                .fuelType(fuelType)
                .color(color)
                .numberOfDoors(5)
                .state(state)
                .productionDate(new Date())
                .description("Lorem ipsum dolor, sit amet consectetur adipisicing elit. Est eaque magni sit dolores. Nisi, dolor nam modi perspiciatis consequatur soluta.")
                .mileage(111111)
                .fuelCondition(0.5f)
                .rentPrice(rentPrice)
                .images(images)
                .equipment(equipment)
                .horsePower(hp)
                .engine(engine)
                .rating(Rating.builder().economy(random.nextInt(5)).comfort(random.nextInt(5)).power(random.nextInt(5)).build())
                .fullDescription("BMW Series 4, XDrive <br> Gran Coupe Hatchback <br> naped na 4 kola <br> Model MSport <br> 245KM <br> mozliwosc" +
                        "jazdy w 3 trybach: normal, sport (jazda dynamiczna) i economy (tryb oszczedzania paliwa) <br> kolor: biel alpejska" +
                        "+ czarna folia carbo na dachu i lusterkach<br> kola 19\" obrecze ze stopu lekkiego<br> opony RunFlat<br> manualna" +
                        "skrzynia biegow<br> wnetrze: skora Sensatec kolor czarny + listwy wykonczeniowe carbon aluminium z elemenami niebieskimi" +
                        "<br> podgrzewana sportowa kierownica<br> podgrzewane sportowe fotele przednie<br> pakiet dodatkowych schowkow i" +
                        "uchwytow na napoje<br> doskonaly dzwiek dzieki zestawowi HI FI Harman Kardon Surround Sound<br> Head UP" +
                        "<br> Nawigacja" +
                        "<br> Bluetooth, mozliwosc zintegrowania telefonu z systemem glosnomowiacym<br> BMW Connected Drive Advanced<br>" +
                        "<br> Przyciemniana szyba tylna oraz tylne szyby boczne<br> Czujnik parkowania przodu i tylu<br> Kamera cofania<br>Tempomat" +
                        "<br> Czujnik deszczu<br><br> Samochod zakupiony w salonie w Polsce i serwisowany w BMW - ostatni przeglad - sierpien'18" +
                        "<br> Jeden wlasciel, bezwypadkowy<br> Garazowany" +
                        "<br> Auto bardzo dynamiczne i znakomicie trzymajace sie drogi<br> Malo uzywany, przebieg 31 000 km<br>")
                .transmission(transmission)
                .drivingGear(drivingGear)
                .build();

        carService.save(car);
    }


    private List<Equipment> getEquipment(List<String> items) {
        List<Equipment> tempItems = new ArrayList<>();
        for (String itemName : items) {
            Equipment equipment = equipmentService.getEquipmentByItemName(itemName);

            if (equipment == null) {
                equipment = Equipment.builder().itemName(itemName).build();
                equipmentService.save(equipment);
            }
            tempItems.add(equipment);
        }
        return tempItems;
    }


    private DrivingGear getDrivingGear(String drivingGearName) {
        DrivingGear drivingGear = drivingGearService.getDrivingGearByDrivingGearName(drivingGearName);

        if (drivingGear == null) {
            drivingGear = DrivingGear.builder().drivingGearName(drivingGearName).build();
            drivingGearService.save(drivingGear);
        }
        return drivingGear;
    }


    private Transmission getTransmission(String transmissionName) {
        Transmission transmission = transmissionService.getTransmissionByTransmissionName(transmissionName);

        if (transmission == null) {
            transmission = Transmission.builder().transmissionName(transmissionName).build();
            transmissionService.save(transmission);
        }
        return transmission;
    }


    private List<Image> getImages(List<String> images) {
        List<Image> tempImages = new ArrayList<>();
        for (String url : images) {
            Image image = Image.builder().url(url).build();
            tempImages.add(image);
        }
        return tempImages;
    }

    private State getState(String stateName, String description) {
        State state = stateService.getStateByStateName(stateName);
        if (state == null) {
            state = State.builder().stateName(stateName).description(description).build();
            stateService.save(state);
        }
        return state;
    }

    private Color getColor(String colorName) {
        Color color = colorService.getColorByColorName(colorName);

        if (color == null) {
            color = Color.builder().colorName(colorName).build();
            colorService.save(color);
        }
        return color;
    }

    private FuelType getFuelType(String fuelTypeName) {
        FuelType fuelType = fuelTypeService.getFuelTypeByTypeName(fuelTypeName);

        if (fuelType == null) {
            fuelType = FuelType.builder().typeName(fuelTypeName).build();
            fuelTypeService.save(fuelType);
        }
        return fuelType;
    }


    private Type getType(String typeName, String description) {
        Type type = typeService.getTypeByTypeName(typeName);

        if (type == null) {
            type = Type.builder().typeName(typeName).description(description).build();
            typeService.save(type);
        }
        return type;
    }

    private Model getModel(String modelName, String brand_name) {

        Brand brand = brandService.getBrandByBrandName(brand_name);
        if (brand == null) {
            brand = Brand.builder().brandName(brand_name).build();
            brandService.save(brand);
        }

        Model model = modelService.getModelByBrandAndModelName(brand, modelName);
        if (model == null) {
            model = Model.builder().modelName(modelName).brand(brand).build();
            modelService.save(model);
        }

        return model;
    }
}
