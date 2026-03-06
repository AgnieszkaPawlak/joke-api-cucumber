package joke_api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import joke_api.config.ApiConfig;

public class OfficialJokeApiClient {

    public Response getRandomJoke() {
        return RestAssured
                .given()
                .baseUri(ApiConfig.baseUri())
                .when()
                .get("/random_joke")
                .then()
                .extract()
                .response();
    }

    public Response getJokeById(int id) {
        return RestAssured
                .given()
                .baseUri(ApiConfig.baseUri())
                .pathParam("id", id)
                .when()
                .get("/jokes/{id}")
                .then()
                .extract()
                .response();
    }
}
