package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import java.net.URI;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BreweryClientTest {

  @Autowired
  BreweryClient client;

  @Test
  void getBeerById() {
    BeerDto dto = client.getBeerById(UUID.randomUUID());

    assertNotNull(dto);
  }

  @Test
  void saveNewBeer() {
    //given

    BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

    URI uri = client.saveNewBeer(beerDto);

    assertNotNull(uri);

    System.out.println(uri.toString());
  }

  @Test
  void updateBeer() {
    //given
    BeerDto beerDto = BeerDto.builder().beerName("bew Beer").build();

    client.updateBeer(UUID.randomUUID(), beerDto);
  }

  @Test
  void deleteBeer() {
    //given
    client.deleteBeer(UUID.randomUUID());
  }

  @Test
  void getCustomerById() {
    CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());

    assertNotNull(customerDto);
  }

  @Test
  void saveNewCustomer() {
    //given

    CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();

    URI uri = client.saveNewCustomer(customerDto);

    assertNotNull(uri);

    System.out.println(uri.toString());
  }

  @Test
  void updateCustomer() {
    //given
    CustomerDto customerDto = CustomerDto.builder().name("New Custoemr").build();

    client.updateCustomer(UUID.randomUUID(), customerDto);
  }

  @Test
  void deleteCustomer() {
    //given
    client.deleteCustomer(UUID.randomUUID());
  }
}