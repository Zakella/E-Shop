package com.shop.eshop.customer;

import com.shop.eshop.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerService customerService,
                              CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    List<Customer> getCustomers() {
        System.out.println("get all customers");
        return this.customerService.findAll();
    }

    @GetMapping(path = "{id}")
    Customer getCustomer(@PathVariable("id") Long id) {
        System.out.println("get customer");
        return this.customerService.getCustomer(id);
    }

    @GetMapping(path = "{id}/exception")
    Customer getCustomerException(@PathVariable("id") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for customer  " + id
        );
    }

    @PostMapping()
    public void createCustomer(@Valid @RequestBody List<Customer> customers) {
        System.out.println("Post customer");
        customerService.saveCustomers(customers);

    }

    @PutMapping()
    public void updateCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Updating customer");
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteById(id);
        System.out.println("Deleting customer width" + id);
    }

    @GetMapping(path = "/get")
    Customer getCustomerByPhone(@RequestParam("phone") String phone,
                                @RequestParam("email") String email) {
        System.out.println("phone");
        return this.customerService.getCustomerByPhone(phone);
    }

    @GetMapping(path = "generateCustomers")
    public void generateCustomers() {
        this.customerService.generateCustomers();

    }

    @GetMapping(path = "pageCustomers")
    public void pageCustomers() {
        this.customerService.pageCustomers();

    }


//    @GetMapping("/{email}")
//    public Customer getCustomerByEmail(@PathVariable("email")  String email) {
//        System.out.println("email");
//        return this.customerService.getCustomerByEmail(email);
//    }
}
