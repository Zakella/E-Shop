package com.shop.eshop.customer;

import com.shop.eshop.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    List<Customer> getCustomers() {
        return this.customerService.findAll();
    }

    @GetMapping(path = "{id}")
    Customer getCustomer(@PathVariable("id") Long id) {
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
        customerService.saveCustomers(customers);

    }

    @PutMapping()
    public void updateCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Updating customer");
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteById(id);
    }

    @GetMapping(path = "/get")
    Customer getCustomerByPhone(@RequestParam("phone") String phone,
                                @RequestParam("email") String email) {
        return this.customerService.getCustomerByPhone(phone);
    }


}
