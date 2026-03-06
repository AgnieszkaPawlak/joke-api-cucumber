package joke_api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import joke_api.client.OfficialJokeApiClient;
import joke_api.config.ApiConfig;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JokeContractSteps {

    private final OfficialJokeApiClient client = new OfficialJokeApiClient();
    private Response response;
    private Map<String, Object> payload;

    @Given("I use the Official Joke API base url")
    public void iUseTheOfficialJokeApiBaseUrl() {
        assertThat(ApiConfig.baseUri()).isNotBlank();
    }

    @When("I request random joke for contract validation")
    public void iRequestRandomJokeForContractValidation() {
        response = client.getRandomJoke();
        payload = response.jsonPath().getMap("$");
    }

    @Then("contract response status should be {int}")
    public void contractResponseStatusShouldBe(int expectedStatus) {
        assertThat(response).isNotNull();
        assertThat(response.statusCode()).isEqualTo(expectedStatus);
    }

    @Then("response should contain required fields:")
    public void responseShouldContainRequiredFields(DataTable table) {
        assertThat(payload).isNotNull();

        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String field = row.get("field");
            assertThat(payload).containsKey(field);
            assertThat(payload.get(field)).isNotNull();
        }
    }

    @Then("response fields should match patterns:")
    public void responseFieldsShouldMatchPatterns(DataTable table) {
        assertThat(payload).isNotNull();

        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String field = row.get("field");
            String pattern = row.get("pattern");
            Object rawValue = payload.get(field);

            assertThat(rawValue).as("Missing value for field: " + field).isNotNull();
            assertThat(String.valueOf(rawValue)).matches(pattern);
        }
    }
}