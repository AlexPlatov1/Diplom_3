package api;

import Base.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserSteps extends BaseTest {
    @Step ("Создаем нового уникального пользователя")
    public Response createNewUser (User user){
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post("/api/auth/register");
    }

    @Step("Логин существующего пользователя")
    public Response loginUser(User user) {
        User userForLogin = User.forLogin(user.getEmail(), user.getPassword());
        return given()
                .spec(getBaseSpec())
                .body(userForLogin)
                .when()
                .post("/api/auth/login");
    }

    @Step ("Удаляем пользователя")
    public void deleteUser(String accessToken, User user) {
        given()
                .spec(getBaseSpec())
                .header("Authorization", accessToken)
                .body(user)
                .when()
                .delete("/api/auth/user")
                .then()
                .statusCode(202);
    }

    @Step("Получаем токен Access token")
    public String getAccessToken (Response response){
        return response.jsonPath().getString("accessToken");
    }

}