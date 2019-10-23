package be.tomstockmans.eurder.api.controller;

import be.tomstockmans.eurder.domain.entities.item.ItemDtoRequest;
import be.tomstockmans.eurder.domain.entities.item.ItemDtoResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import io.restassured.RestAssured;


class ItemControllerTest extends AbstractControllerTest{

    private ItemDtoResponse postItem(ItemDtoRequest itemDtoRequest){
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
    void whenNewItemIsCreated_thenTheItemIsSavedAndReturned(){
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest("abc","cdef",2.5,10);

        ItemDtoResponse itemDtoResponseReturned = postItem(itemDtoRequest);


        Assertions.assertEquals(itemDtoRequest.name, itemDtoResponseReturned.name);
        Assertions.assertEquals(itemDtoRequest.description, itemDtoResponseReturned.description);
        Assertions.assertEquals(itemDtoRequest.price, itemDtoResponseReturned.price);
        Assertions.assertEquals(itemDtoRequest.amount, itemDtoResponseReturned.amount);
        Assertions.assertTrue(itemDtoResponseReturned.id != null);

    }

    @Test
    void whenNewItemIsUpdated_thenTheItemIsCorrectlyChanged(){
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest("abc","cdef",2.5,10);
        ItemDtoResponse itemDtoResponseReturned = postItem(itemDtoRequest);

        ItemDtoRequest itemToUpdate = new ItemDtoRequest("abcd","cdefg",3,15);
        ItemDtoResponse itemDtoResponseReturnedUpdated = RestAssured
                        .given()
                        .body(itemToUpdate)
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .when()
                        .port(port)
                        .put(ItemController.ITEM_CONTROLLER_RESOURCE_URL + "/" + itemDtoResponseReturned.id.toString())
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .as(ItemDtoResponse.class);

        Assertions.assertEquals(itemDtoResponseReturned.id, itemDtoResponseReturnedUpdated.id);
        Assertions.assertEquals("abcd", itemDtoResponseReturnedUpdated.name);
        Assertions.assertEquals("cdefg", itemDtoResponseReturnedUpdated.description);
        Assertions.assertEquals(3, itemDtoResponseReturnedUpdated.price);
        Assertions.assertEquals(15, itemDtoResponseReturnedUpdated.amount);


    }

}