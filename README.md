# Joke API - REST API Test Automation (Java + Cucumber)

REST API automation framework for the Official Joke API.

Target API:
- https://official-joke-api.appspot.com

## Repository Deliverables

- Framework code: `src/main/java` and `src/test/java`
- Cucumber features: `src/test/resources/features`
- Project documentation: `README.md`
- Development log: `DEVLOG.md`

## Tech Stack

- Java 17
- Gradle (Groovy DSL)
- JUnit 5 (platform) + JUnit 4 Cucumber runner (via Vintage engine)
- Cucumber (Gherkin)
- RestAssured
- AssertJ

## Project Structure

```text
src/main/java/joke_api
  config/ApiConfig.java
  client/OfficialJokeApiClient.java
  model/Joke.java

src/test/java/joke_api
  runner/CucumberTest.java
  steps/RandomJokeSteps.java
  steps/JokeByIdSteps.java
  steps/JokeContractSteps.java

src/test/resources/features
  random_joke.feature
  joke_by_id.feature
  joke_contract.feature
```

## Implemented Cucumber Techniques

1. `Scenario`
- `random_joke.feature`

2. `Scenario Outline + Examples`
- `joke_by_id.feature`

3. `Background + Data Table + Tags`
- `joke_contract.feature`

## Prerequisites

- JDK 17 available in PATH (`java -version`)
- Gradle wrapper from repo (`gradlew.bat`)

## How To Run

### Run all tests

`<project-root>` means the directory that contains `build.gradle` and `gradlew.bat`.

```powershell
Set-Location "<project-root>"
.\gradlew.bat clean test
```

### Run tests by tag (PowerShell)

Important for PowerShell: use `--%` before JVM props.

```powershell
.\gradlew.bat --% clean test -Dcucumber.filter.tags=@smoke
.\gradlew.bat --% clean test -Dcucumber.filter.tags=@id
.\gradlew.bat --% clean test -Dcucumber.filter.tags=@contract
```

Tag meaning:
- `@smoke`: quick sanity checks across endpoints
- `@id`: `/jokes/{id}` scenarios
- `@contract`: response contract validation scenario

## Sample Test Run Output

Example console output from a successful local run:

```text
BUILD SUCCESSFUL in 15s
5 actionable tasks: 5 executed
```

## Reports

After test execution:

- Cucumber HTML report:
  - `build/reports/cucumber/cucumber.html`
- Cucumber JSON report:
  - `build/reports/cucumber/cucumber.json`
- Gradle/JUnit report:
  - `build/reports/tests/test/index.html`

## Test Stability Note

Tests hit a public external API, so temporary network/API issues can occasionally cause flaky failures.

## Notes About Configuration

Base URI is centralized in:
- `src/main/java/joke_api/config/ApiConfig.java`

Default value:
- `https://official-joke-api.appspot.com`

Optional override via environment variable:
- `JOKE_API_BASE_URI`

## AI Usage Disclosure

This project was prepared with AI assistance (GitHub Copilot / GPT-5.3-Codex) for:
- scaffolding code structure,
- generating initial step definitions and feature drafts,
- troubleshooting build/test issues.

All generated content was reviewed, adjusted, and validated manually through local test runs.
