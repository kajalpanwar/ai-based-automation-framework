# API Automation Framework

A scalable Java automation framework for API testing using **TestNG** and **RestAssured**.

## Architecture (Separation of Concerns)

```
src/
├── main/java/com/automation/framework/
│   ├── config/          # Configuration management
│   │   ├── Config.java
│   │   └── ApiConfig.java
│   ├── models/          # Request/Response DTOs
│   │   ├── Post.java
│   │   ├── User.java
│   │   └── ApiResponse.java
│   ├── api/             # API clients (one per resource)
│   │   ├── BaseApiClient.java
│   │   ├── PostsApiClient.java
│   │   └── UsersApiClient.java
│   └── utils/           # Utilities
│       ├── Constants.java
│       └── JsonUtils.java
│
└── test/java/com/automation/framework/
    ├── base/             # Base test setup
    │   └── BaseTest.java
    └── tests/            # Test classes
        ├── PostsApiTest.java
        └── UsersApiTest.java
```

## Layers

| Layer | Responsibility |
|-------|----------------|
| **Config** | Base URL, timeouts, environment properties |
| **Models** | Data structures for API payloads |
| **API** | HTTP operations, request/response handling |
| **Utils** | Constants, JSON helpers |
| **Base** | TestNG setup, shared API clients |
| **Tests** | Test logic only; assertions |

## Prerequisites

- Java 21+
- Maven 3.8+

## Run Tests

```bash
mvn clean test
```

## Configuration

Override settings via `src/main/resources/config/application.properties` or environment variables:

```bash
export API_BASE_URL=https://your-api.com
mvn test
```

## Adding New Endpoints

1. Add model in `models/` if needed
2. Add methods in `ApiClient` (or create new client extending `BaseApiClient`)
3. Add tests in `tests/`
