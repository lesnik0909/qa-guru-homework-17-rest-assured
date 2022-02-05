package guru.qa.homework.tests.api;

import static guru.qa.homework.tests.config.EndPoints.CREATE_USERS;
import static guru.qa.homework.tests.config.EndPoints.DELETE_USERS;
import static guru.qa.homework.tests.config.EndPoints.GET_USERS;
import static guru.qa.homework.tests.config.EndPoints.GET_USERS_LIST;
import static guru.qa.homework.tests.config.EndPoints.UPDATE_USERS;
import static io.restassured.RestAssured.given;

import guru.qa.homework.tests.utils.Specifications;
import io.restassured.response.Response;

public class ApiMethods {

  public Response postMethodCreateUser() {
    return given()
        .spec(Specifications.requestSpec())
        .body("{\n"
            + "    \"name\": \"morpheus\",\n"
            + "    \"job\": \"leader\"\n"
            + "}")
        .post(CREATE_USERS);
  }

  public Response putMethodUpdateUser(String id) {
    return given()
        .spec(Specifications.requestSpec())
        .body("{\n"
            + "    \"name\": \"morpheus\",\n"
            + "    \"job\": \"doctor\"\n"
            + "}")
        .put(UPDATE_USERS, id);
  }

  public Response deleteMethodDeleteUser(String id) {
    return given()
        .spec(Specifications.requestSpec())
        .delete(DELETE_USERS, id);
  }

  public Response getMethodGetUser(String id) {
    return given()
        .spec(Specifications.requestSpec())
        .get(GET_USERS, id);
  }

  public Response getMethodGetUsersList(String pageId) {
    return given()
        .spec(Specifications.requestSpec())
        .queryParam("page", pageId)
        .get(GET_USERS_LIST);
  }

}
