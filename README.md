# spring-ai-chat-llm

A lightweight Spring Boot service that exposes a simple Chat endpoint powered by Spring AI and an OpenAI-compatible provider (default configured for Groq). It accepts a prompt and returns a generated response.

## Features
- REST API: POST /chat returns an AI-generated reply for a given prompt
- Spring AI integration with OpenAI-compatible APIs (Groq by default)
- Simple configuration via application.yml and environment variables
- Swagger UI for interactive testing

## Tech Stack
- Java 17
- Spring Boot 3.3
- Spring AI (OpenAI starter)
- Maven

## Prerequisites
- Java 17+
- Maven 3.9+
- An API key for an OpenAI-compatible provider (e.g., Groq)

## Configuration
Default configuration is in `src/main/resources/application.yml`.

Key properties:
- Server port: `8082`
- Base URL: `spring.ai.openai.base-url` (defaults to `https://api.groq.com/openai`)
- API key: `spring.ai.openai.api-key` (read from `GROQ_API_KEY` environment variable)
- Model: `spring.ai.openai.chat.options.model` (defaults to `llama-3.1-8b-instant`)

Set your API key as an environment variable before running:

macOS/Linux:
```
export GROQ_API_KEY=your_api_key_here
```
Windows (PowerShell):
```
setx GROQ_API_KEY "your_api_key_here"
```

You can also override any property via environment variables or JVM system properties if desired.

## Build and Run
Using Maven (recommended during development):
```
mvn spring-boot:run
```

Build a jar:
```
mvn clean package
```
Run the jar:
```
java -jar target/spring-ai-chat-llm-0.0.1-SNAPSHOT.jar
```

The application starts on `http://localhost:8082` by default.

## API Usage
Endpoint:
- Method: POST
- Path: `/chat`
- Consumes: `application/json`
- Produces: `application/json`

Request body:
```json
{
  "prompt": "Say hello in Arabic"
}
```

Response (plain JSON string):
```json
"مرحبا! كيف يمكنني مساعدتك اليوم؟"
```

Curl example:
```
curl -X POST \
  http://localhost:8082/chat \
  -H "Content-Type: application/json" \
  -d '{"prompt": "Write a haiku about the sea"}'
```

### Swagger UI
Once the app is running, open:
- Swagger UI: http://localhost:8082/swagger-ui.html

## Project Structure (high level)
```
spring-ai-chat-llm/
├─ src/
│  ├─ main/java/com/example/jareerai/
│  │  ├─ JareerAiApplication.java     # Spring Boot entry point
│  │  ├─ config/AiConfig.java         # AI-related configuration
│  │  ├─ controller/ChatController.java# REST controller exposing /chat
│  │  ├─ service/ChatService.java     # Service calling the AI client
│  │  └─ dto/ChatRequest.java         # DTO with the prompt field
│  └─ main/resources/application.yml  # App configuration (port, AI settings)
├─ pom.xml                            # Maven configuration
└─ .gitignore
```

## Notes
- Do not commit real API keys. Use environment variables or a secure secret manager.
- The repository `.gitignore` is configured to exclude build outputs (e.g., `target/`) and common IDE files.

## License
This repository does not currently specify a license. Add one if you plan to share or distribute the code.
