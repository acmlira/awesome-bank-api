# Awesome Bank API

REST API to handle expenses and cash in/out of a bank account.

> [awesome-bank-web](https://github.com/acmlira/awesome-bank-web) implements a client and frontend for this project.

## Goal

This project aims to provide the following requirements:

Model:
- Expense:
  - ID
  - Person name
  - Description
  - Date/time
  - Value
  - Tags

- Tag (_additional_):
  - ID
  - Code

Features:
- Create an expense
- List all expenses
- List an expense by ID

Non-functional:
- Persist in a relational database

## Getting Started

It is highly recommended to use:

```shell
docker-compose up
```
The [requests](/requests) folder has some examples of requests, you can execute them via Intellij in order to test.

## Troubleshooting

In order to make the development easy-understandable for everyone, I present to you some tips.

### Debug in IDE

1. Bring up Postgres container with:
   ```shell
   docker-compose up postgres
   ```
2. Put some breakpoints and run in debug mode.

### Integration tests

1. Bring up Postgres container with:
   ```shell
   docker-compose up postgres
   ```
2. Run integration tests with:
   ```shell
   ./mvnw verify
   ```

### No effect changes

Clean your docker environment (remove images, networks, containers, etc.).

## What can be improved?

I see some improvements:
- Automated integration tests (tradeoff)
- More business rules
