# AI Agent Instructions for Sports Maven Project

## Project Overview
This is a Java Maven project in the `dam.m6.uf2` namespace. The project is structured following standard Maven conventions with separate source and test directories.

## Project Structure
```
sports/
├── src/
│   ├── main/java/dam/m6/uf2/     # Main source code
│   └── test/java/dam/m6/uf2/     # Test code
└── pom.xml                       # Maven configuration
```

## Build & Test
- **Build**: `mvn clean package`
- **Run Tests**: `mvn test`
- **Run Application**: `mvn exec:java -Dexec.mainClass="dam.m6.uf2.App"`

## Development Environment
- Java version: 1.7 (configured in pom.xml)
- Test framework: JUnit 4.11
- Character encoding: UTF-8

## Key Files
- `src/main/java/dam/m6/uf2/App.java`: Main application entry point
- `src/test/java/dam/m6/uf2/AppTest.java`: Unit test examples
- `pom.xml`: Project dependencies and build configuration

## Maven Configuration
- Group ID: `dam.m6.uf2`
- Artifact ID: `sports`
- Version: `1.0-SNAPSHOT`

## Testing Practices
Tests are written using JUnit 4 and located in the `src/test/java` directory. Test classes should:
- Follow the naming pattern `*Test.java`
- Be placed in the same package structure as the classes they test
- Example: `AppTest.java` demonstrates basic test structure

## Project Dependencies
Currently minimal dependencies:
- JUnit 4.11 (test scope)

## Build Lifecycle
The project uses standard Maven plugins for its build lifecycle:
- clean: maven-clean-plugin
- compile: maven-compiler-plugin
- test: maven-surefire-plugin
- package: maven-jar-plugin
- install: maven-install-plugin
- deploy: maven-deploy-plugin

---
Note: This is a basic Maven project template. When extending it, follow the established package structure under `dam.m6.uf2` and update dependencies in `pom.xml` as needed.