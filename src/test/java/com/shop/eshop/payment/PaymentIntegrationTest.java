package com.shop.eshop.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.eshop.customer.Customer;
import com.shop.eshop.customer.CustomerRegistrationRequest;
import com.shop.eshop.customer.CustomerRepository;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import static com.shop.eshop.payment.Currency.USD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.web.servlet.function.ServerResponse.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentIntegrationTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldCreatePaymentSuccessfully() throws Exception {
        //given

        Customer customer = new Customer("Joe", "Doe",
                "07929666", "joe@gmail.com", "454545");

        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest(customer);

        String jsonCustomerRequest = objectToJson(customerRegistrationRequest);

        ResultActions customerRegResultActions= mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/customers-registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(jsonCustomerRequest))
        );

        Customer savedCustomer = customerRepository.findCustomerByPhone(customer.getPhone()).get();

        System.out.println(customerRegResultActions);
        //when
        Payment payment = new Payment(
                1L,
                savedCustomer.getId(),
                new BigDecimal("150.00"),
                USD,
                "card123xx",
                "Donation");
        PaymentRequest paymentRequest = new PaymentRequest(payment);

        ResultActions paymentResultActions = mockMvc.perform(post("/api/v1/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(objectToJson(paymentRequest)))
        );


        //then

        customerRegResultActions.andExpect(MockMvcResultMatchers.status().isOk());
        paymentResultActions.andExpect(MockMvcResultMatchers.status().isOk());

        assertThat(paymentRepository.findById(1L))
                .isPresent()
                .hasValueSatisfying(p -> assertThat(p).isEqualTo(payment));

    }

    private String objectToJson(Object object) {
        try{
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            fail("file to serialize object to Json");
            return null;
        }
    };
}
