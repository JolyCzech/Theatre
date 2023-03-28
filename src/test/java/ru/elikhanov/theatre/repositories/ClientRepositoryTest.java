package ru.elikhanov.theatre.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.elikhanov.theatre.models.Client;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;



    @Test
    void itShouldCheckIfClientExistsEmail() {
        //given
        Client client = new Client();
        client.setFirstName("test1");
        client.setLastName("test1");
        client.setAge(19);
        client.setEmail("ajlsdhj@gmail.ru");
        clientRepository.save(client);

        //when
        boolean em = clientRepository.selectExistsEmail(client.getEmail());

        //then
        assertThat(em).isFalse();

        clientRepository.deleteById(client.getId());

    }

    @Test
    void itShouldCheckIfClientExistsPhoneNumber() {
        //given
        Client client = new Client();
        client.setFirstName("test1");
        client.setLastName("test1");
        client.setAge(19);
        client.setEmail("ajlsdhj@gmail.ru");
        client.setPhoneNumber("89771406222");
        clientRepository.save(client);

        //when
        boolean pn = clientRepository.selectExistsPhoneNumber(client.getPhoneNumber());

        //then
        assertThat(pn).isTrue();

        clientRepository.deleteById(client.getId());
    }
}