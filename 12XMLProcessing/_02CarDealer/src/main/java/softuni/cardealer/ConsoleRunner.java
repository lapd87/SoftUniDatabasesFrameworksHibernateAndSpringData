package softuni.cardealer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import softuni.cardealer.io.reader.Reader;
import softuni.cardealer.io.writer.Writer;
import softuni.cardealer.model.dto.binding.CarSeedDto;
import softuni.cardealer.model.dto.binding.CustomerSeedDto;
import softuni.cardealer.model.dto.binding.PartSeedDto;
import softuni.cardealer.model.dto.binding.SupplierSeedDto;
import softuni.cardealer.model.dto.view.CarMakerDto;
import softuni.cardealer.model.dto.view.CustomerGetAllDto;
import softuni.cardealer.model.dto.view.SupplierPartsCountDto;
import softuni.cardealer.services.car.CarService;
import softuni.cardealer.services.customer.CustomerService;
import softuni.cardealer.services.part.PartService;
import softuni.cardealer.services.sale.SaleService;
import softuni.cardealer.services.supplier.SupplierService;


import java.math.BigDecimal;
import java.util.*;

import static softuni.cardealer.util.beans.BeanRegister.getGson;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.4.2018 г.
 * Time: 16:16 ч.
 */

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    public static final String IODelimiter = System.lineSeparator()
            + new String(new char[30]).replace("\0", "-")
            + System.lineSeparator();


    private final String PROJECT_PATH = System.getProperty("user.dir");
    private final String RECOURCE_PATH = "\\src\\main\\resources";

    private final String CARS_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\cars.json";
    private final String CUSTOMERS_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\customers.json";
    private final String PARTS_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\parts.json";
    private final String SUPPLIERS_FILE_PATH = PROJECT_PATH + RECOURCE_PATH
            + "\\JsonInput\\suppliers.json";

    private static final Set<Double> DISCOUNTS = new HashSet<>(Arrays
            .asList(0.0, 0.05, 0.1, 0.15, 0.2, 0.3, 0.4, 0.5));

    private static final Gson gson = getGson();

    private final Reader reader;
    private final Writer writer;

    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;

    @Autowired
    public ConsoleRunner(Reader reader,
                         Writer writer,
                         CarService carService,
                         CustomerService customerService,
                         PartService partService,
                         SaleService saleService,
                         SupplierService supplierService) {
        this.reader = reader;
        this.writer = writer;
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
    }


    @Override
    public void run(String... args) throws Exception {

        seedSuppliers(SUPPLIERS_FILE_PATH);
        seedParts(PARTS_FILE_PATH);
        seedCars(CARS_FILE_PATH);
        seedCustomers(CUSTOMERS_FILE_PATH);
        seedSales(DISCOUNTS);

//        getAllCustomersOrderByBirthDate();

//        getAllCarsByMaker();

        getLocalSuppliers();

    }

    private void getLocalSuppliers() {

        Set<SupplierPartsCountDto> suppliersPartsCountDto = this.supplierService
                .getLocalSuppliersWithPartsCount();

        String jsonOutput = gson.toJson(suppliersPartsCountDto);

        String outputFile = PROJECT_PATH + RECOURCE_PATH + "\\JsonOuput\\local-suppliers.json";

        this.writer.writeAll(jsonOutput, outputFile);


    }

    private void getAllCarsByMaker() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(IODelimiter + "Enter maker:");
        String maker = scanner.nextLine();

        List<CarMakerDto> carsMakerDto = this.carService
                .getAllByMakerOrderByModelThenTravelledDistance(maker);

        String jsonOutput = gson.toJson(carsMakerDto);

        String outputFile = PROJECT_PATH + RECOURCE_PATH + "\\JsonOuput\\toyota-cars.json";

        this.writer.writeAll(jsonOutput, outputFile);
    }

//    private void getAllCustomersOrderByBirthDate() {
//
//        List<CustomerGetAllDto> customersGetAllDto = this.customerService
//                .getAllOrderByBirthDate();
//
//
//    }

    private void seedSales(Set<Double> discounts) {

        this.saleService
                .saveWithRandomCarCustomerDiscount(DISCOUNTS);
    }

    private void seedCustomers(String filePath) {

        String jsonInput = this.reader.readAll(filePath);

        CustomerSeedDto[] customersSeedDto = gson
                .fromJson(jsonInput, CustomerSeedDto[].class);

        this.customerService
                .save(Arrays.asList(customersSeedDto));
    }

    private void seedCars(String filePath) {

        String jsonInput = this.reader.readAll(filePath);

        CarSeedDto[] carsSeedDto = gson
                .fromJson(jsonInput, CarSeedDto[].class);

        this.carService
                .saveWithRandomParts(Arrays.asList(carsSeedDto));
    }

    private void seedParts(String filePath) {

        String jsonInput = this.reader.readAll(filePath);

        PartSeedDto[] partsSeedDto = gson
                .fromJson(jsonInput, PartSeedDto[].class);

        this.partService
                .saveWithRandomSupplier(Arrays.asList(partsSeedDto));
    }

    private void seedSuppliers(String filePath) {

        String jsonInput = this.reader.readAll(filePath);

        SupplierSeedDto[] suppliersSeedDto = gson
                .fromJson(jsonInput, SupplierSeedDto[].class);

        this.supplierService
                .save(Arrays.asList(suppliersSeedDto));
    }
}