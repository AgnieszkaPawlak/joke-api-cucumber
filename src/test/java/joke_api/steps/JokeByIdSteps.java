package joke_api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import joke_api.client.OfficialJokeApiClient;
import joke_api.model.Joke;

import static org.assertj.core.api.Assertions.assertThat;

public class JokeByIdSteps {

    private final OfficialJokeApiClient client = new OfficialJokeApiClient();
    private Response response;
    private Joke joke;

    @When("I request a joke by id {int}")
    public void iRequestAJokeById(int id) {
        response = client.getJokeById(id);
        joke = response.as(Joke.class);
    }

    @Then("joke by id response status should be {int}")
    public void jokeByIdResponseStatusShouldBe(int expectedStatus) {
        assertThat(response).isNotNull();
        assertThat(response.statusCode()).isEqualTo(expectedStatus);
    }

    @Then("the returned joke id should be {int}")
    public void theReturnedJokeIdShouldBe(int expectedId) {
        assertThat(response).isNotNull();
        assertThat(joke).isNotNull();
        assertThat(joke.getId()).isEqualTo(expectedId);
        assertThat(joke.getSetup()).isNotBlank();
        assertThat(joke.getPunchline()).isNotBlank();
    }
}
