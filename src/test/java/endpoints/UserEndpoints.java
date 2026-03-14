package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.UserPayload;

public class UserEndpoints {

    public static Response getAllUsers(RequestSpecification request) {

        return request
                .when()
                .get("/users");

    }

    public static Response getUser(RequestSpecification request, int id) {

        return request
                .when()
                .get("/users/" + id);

    }

    public static Response createUser(RequestSpecification request, UserPayload payload) {

        return request
                .body(payload)
                .when()
                .post("/users");

    }

    public static Response updateUser(RequestSpecification request, int id, UserPayload payload) {

        return request
                .body(payload)
                .when()
                .put("/users/" + id);

    }

    public static Response deleteUser(RequestSpecification request, int id) {

        return request
                .when()
                .delete("/users/" + id);

    }

}