package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.entities.item.ItemDtoRequest;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
abstract class AbstractControllerTest {

    @Value("${server.port}")
    protected int port;




}
