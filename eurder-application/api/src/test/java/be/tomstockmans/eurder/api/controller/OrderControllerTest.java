package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoRequest;
import be.tomstockmans.eurder.domain.entities.Order.CreateOrderDto;
import be.tomstockmans.eurder.domain.entities.Order.OrderCreatedDto;
import be.tomstockmans.eurder.domain.entities.item.CreateItemDtoRequest;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

class OrderControllerTest extends AbstractControllerTest {

    private ItemDtoResponse postItem(CreateItemDtoRequest createItemDtoRequest) {
        return RestAssured
                .given()
                .body(createItemDtoRequest)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .port(port)
                .post(ItemController.ITEM_CONTROLLER_RESOURCE_URL)
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ItemDtoResponse.class);
    }

    @Test
    void whenAddingNewOrder_newOrderIsAddedAndCorrectlyReturned() {
        UUID userId = UUID.randomUUID();
        ItemDtoResponse item1 = postItem(new CreateItemDtoRequest("abc", "cde", 10, 5));
        ItemDtoResponse item2 = postItem(new CreateItemDtoRequest("fgh", "ijk", 5, 2));
        CreateOrderDto createOrderDto = new CreateOrderDto(userId,Arrays.asList(new ItemGroupDtoRequest(item1.id,2),new ItemGroupDtoRequest(item2.id,3)));

        OrderCreatedDto orderCreatedDto =

                RestAssured
                        .given()
                        .body(createOrderDto)
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .when()
                        .port(port)
                        .post(OrderController.ORDER_CONTROLLER_RESOURCE_URL)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(OrderCreatedDto.class);


        Assertions.assertEquals(35, orderCreatedDto.totalPrice);
        Assertions.assertEquals(2, orderCreatedDto.items.size());

        Assertions.assertEquals(2, orderCreatedDto.items.get(0).amount);
        Assertions.assertEquals(3, orderCreatedDto.items.get(1).amount);

        Assertions.assertEquals(LocalDate.now().plusDays(1), orderCreatedDto.items.get(0).shippingDate);
        Assertions.assertEquals(LocalDate.now().plusDays(7), orderCreatedDto.items.get(1).shippingDate);

        Assertions.assertEquals(item1.name, orderCreatedDto.items.get(0).item.name);
        Assertions.assertEquals(item1.description, orderCreatedDto.items.get(0).item.description);
        Assertions.assertEquals(item1.price, orderCreatedDto.items.get(0).item.price);

        Assertions.assertEquals(item2.name, orderCreatedDto.items.get(1).item.name);
        Assertions.assertEquals(item2.description, orderCreatedDto.items.get(1).item.description);
        Assertions.assertEquals(item2.price, orderCreatedDto.items.get(1).item.price);

        Assertions.assertTrue(orderCreatedDto.id != null);
    }
}