package joke_api.config;

public final class ApiConfig {
    private static final String DEFAULT_BASE_URI = "https://official-joke-api.appspot.com";

    private ApiConfig() {
    }

    public static String baseUri() {
        String fromEnv = System.getenv("JOKE_API_BASE_URI");
        if (fromEnv == null || fromEnv.isBlank()) {
            return DEFAULT_BASE_URI;
        }
        return fromEnv;
    }
}
