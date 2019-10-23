package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.entities.ItemGroup.ItemGroupDtoRequest;
import be.tomstockmans.eurder.domain.entities.Order.OrderDtoRequest;
import be.tomstockmans.eurder.domain.entities.Order.OrderDtoResponse;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoRequest;
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

    private ItemDtoResponse postItem(ItemDtoRequest itemDtoRequest) {
        return RestAssured
                .given()
                .body(itemDtoRequest)
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
        ItemDtoResponse item1 = postItem(new ItemDtoRequest("abc", "cde", 10, 5));
        ItemDtoResponse item2 = postItem(new ItemDtoRequest("fgh", "ijk", 5, 2));
        OrderDtoRequest orderDtoRequest = new OrderDtoRequest(userId,Arrays.asList(new ItemGroupDtoRequest(item1.id,2),new ItemGroupDtoRequest(item2.id,3)));

        OrderDtoResponse orderDtoResponse =

                RestAssured
                        .given()
                        .body(orderDtoRequest)
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .when()
                        .port(port)
                        .post(OrderController.ORDER_CONTROLLER_RESOURCE_URL)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(OrderDtoResponse.class);


        Assertions.assertEquals(35,orderDtoResponse.totalPrice);
        Assertions.assertEquals(2,orderDtoResponse.items.size());

        Assertions.assertEquals(2, orderDtoResponse.items.get(0).amount);
        Assertions.assertEquals(3, orderDtoResponse.items.get(1).amount);

        Assertions.assertEquals(LocalDate.now().plusDays(1), orderDtoResponse.items.get(0).shippingDate);
        Assertions.assertEquals(LocalDate.now().plusDays(7), orderDtoResponse.items.get(1).shippingDate);

        Assertions.assertEquals(item1, orderDtoResponse.items.get(0).item);
        Assertions.assertEquals(item2, orderDtoResponse.items.get(1).item);

        Assertions.assertTrue(orderDtoResponse.id != null);
    }
}