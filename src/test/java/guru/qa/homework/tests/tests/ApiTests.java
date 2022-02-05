package guru.qa.homework.tests.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import guru.qa.homework.tests.api.ApiMethods;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ApiTests {

  ApiMethods apiMethods = new ApiMethods();

  @Test
  void createUserTest() {
    Response response = apiMethods.postMethodCreateUser();
    response.then()
        .statusCode(201)
        .body("name", equalTo("morpheus"))
        .body("job", equalTo("leader"))
        .body("id", notNullValue())
        .body("createdAt", notNullValue());
  }

  @Test
  void updateUserTest() {
    Response response = apiMethods.putMethodUpdateUser("252");
    response.then()
        .statusCode(200)
        .body("name", equalTo("morpheus"))
        .body("job", equalTo("doctor"))
        .body("updatedAt", notNullValue());
  }

  @Test
  void deleteUserTest() {
    Response response = apiMethods.deleteMethodDeleteUser("252");
    response.then()
        .statusCode(204);
  }

  @Test
  void getUserTest() {
    Response response = apiMethods.getMethodGetUser("2");
    response.then()
        .statusCode(200)
        .body("data.id", equalTo(2));
  }

  @Test
  void getUsersListTest() {
    Response response = apiMethods.getMethodGetUsersList("2");
    response.then()
        .statusCode(200)
        .body("page", equalTo(2));
  }

}
