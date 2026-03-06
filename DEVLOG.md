# DEVLOG

## Scope

Built a lightweight REST API test automation framework for Official Joke API using Java 17, Gradle, Cucumber, RestAssured, JUnit, and AssertJ.

## Implementation Steps

1. Initialized Gradle Java project in VS Code.
2. Flattened default `app` module structure to root-level `build.gradle` + `src`.
3. Added dependencies for Cucumber, RestAssured, AssertJ, JUnit Platform, and JSON deserialization.
4. Added API config and simple API client.
5. Added Cucumber runner and report output (HTML/JSON).
6. Implemented three feature files with required Cucumber techniques:
   - `Scenario`
   - `Scenario Outline + Examples`
   - `Background + Data Table + Tags`
7. Added step definitions and fixed collisions/ambiguity in shared step wording.
8. Added tag-based execution support and verified tags locally.
9. Added project documentation (`README.md`) with run instructions and report paths.

## Issues Encountered and Fixes

- Gradle could not load JUnit Platform launcher:
  - Added `junit-platform-launcher` runtime dependency.
- `rest-assured` classes missing in `main` source set:
  - Changed dependency scope to `implementation`.
- Cucumber test discovery issues:
  - Switched runner setup to a stable JUnit4 Cucumber runner with Vintage engine.
- JSON deserialization error for `response.as(Joke.class)`:
  - Added `jackson-databind` dependency.
- Step mismatch across features:
  - Made joke-by-id status step text unique.
- Feature file structure issue:
  - Ensured one `Feature` block per `.feature` file.

## AI Usage

AI tooling (GitHub Copilot / GPT-5.3-Codex) was used to:
- draft initial project scaffolding,
- generate draft feature files and step definitions,
- troubleshoot dependency/discovery/build issues.

All generated content was reviewed and adjusted manually, then validated by local test runs.
