package ru.elikhanov.theatre.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.elikhanov.theatre.DTO.ClientDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.Client;
import ru.elikhanov.theatre.repositories.ClientRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private Mapper mapper;
    private ClientServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new ClientServiceImpl(clientRepository, mapper);
    }


    @Test
    void willThrowWhenEmailsIsTaken(){
        //given
        ClientDTO client = new ClientDTO("TestName","testName",16,"testall@gmail.com","89771406098");

        given(clientRepository.selectExistsEmail(client.getEmail()))
                .willReturn(true);

        //when
        //then
        assertThatThrownBy(()->underTest.createClient(client))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Сlient with this email already exists");
        verify(clientRepository, never()).save(any());
    }

    @Test
    void willThrowWhenPhoneNumberIsTaken(){
        //given
        ClientDTO client = new ClientDTO("TestName","testName",16,"testall@gmail.com","89771406098");

        given(clientRepository.selectExistsPhoneNumber(client.getPhoneNumber()))
                .willReturn(true);

        //when
        //then
        assertThatThrownBy(()->underTest.createClient(client))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Сlient with this phoneNumber already exists");
        verify(clientRepository, never()).save(any());
    }

    @Test
    void willThrowWhenEmailAndPhoneNumberIsTaken(){
        //given
        ClientDTO client = new ClientDTO("TestName","testName",16,"testall@gmail.com","89771406098");

        given(clientRepository.selectExistsPhoneNumber(client.getPhoneNumber()))
                .willReturn(true);
        given(clientRepository.selectExistsEmail(client.getEmail()))
                .willReturn(true);

        //when
        //then
        assertThatThrownBy(()->underTest.createClient(client))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Сlient with this email and phoneNumber already exists");
        verify(clientRepository, never()).save(any());
    }

    @Test
    void canGetAllCities() {
        //when
        underTest.getAllClients();

        //then
        verify(clientRepository).findAll();
    }


}