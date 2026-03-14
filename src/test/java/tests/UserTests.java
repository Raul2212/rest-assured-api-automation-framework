package tests;

import base.BaseTest;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import payloads.UserPayload;

public class UserTests extends BaseTest {

    @BeforeMethod
    public void init() {
        setup();
    }

    @Test
    public void testGetAllUsers() {

        Response response = UserEndpoints.getAllUsers(request);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testGetSingleUser() {

        Response response = UserEndpoints.getUser(request, 1);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testCreateUser() {

        UserPayload payload = new UserPayload();

        payload.name = "Rahul";
        payload.username = "rahul123";
        payload.email = "rahul@test.com";

        Response response = UserEndpoints.createUser(request, payload);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void testUpdateUser() {

        UserPayload payload = new UserPayload();

        payload.name = "Rahul Updated";
        payload.username = "rahulupdated";
        payload.email = "rahulupdated@test.com";

        Response response = UserEndpoints.updateUser(request, 1, payload);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testDeleteUser() {

        Response response = UserEndpoints.deleteUser(request, 1);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}