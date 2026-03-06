package joke_api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import joke_api.client.OfficialJokeApiClient;
import joke_api.model.Joke;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomJokeSteps {

    private final OfficialJokeApiClient client = new OfficialJokeApiClient();
    private Response response;
    private Joke joke;

    @When("I request a random joke")
    public void iRequestARandomJoke() {
        response = client.getRandomJoke();
        joke = response.as(Joke.class);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertThat(response).isNotNull();
        assertThat(response.statusCode()).isEqualTo(statusCode);
    }

    @Then("the joke should contain id, type, setup and punchline")
    public void theJokeShouldContainExpectedFields() {
        assertThat(joke).isNotNull();
        assertThat(joke.getId()).isGreaterThan(0);
        assertThat(joke.getType()).isNotBlank();
        assertThat(joke.getSetup()).isNotBlank();
        assertThat(joke.getPunchline()).isNotBlank();
    }
}
