## Development tips

In order to make the development easy-understandable for everyone, I present to you some tips:

1. Bring up Postgres container with:
   ```shell
   docker-compose up postgres
   ```
2. Run integration tests with:
   ```shell
   ./mvnw verify
   ```