# Task API

## Overview

Task API is a simple yet powerful RESTful API designed to manage tasks. Built with Node.js and Koa framework, it leverages Sequelize for ORM and PostgreSQL as the database. This API supports basic CRUD operations for tasks and users, offering a solid foundation for task management applications.

## Getting Started

### Prerequisites

- Node.js (v14 or later recommended)
- PostgreSQL
- Docker & Docker Compose (optional for containerized environments)

### Installation

1. Clone the repository:

```sh
git clone https://github.com/your-repository/task-api.git
cd task-api
```

2. Install dependencies:

```sh
npm install
```

3. Set up environment variables:

Copy [`.env-example`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2F.env-example%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "/home/gustavo/Development/Cesusc/linguagemDeProgramacao2/Tasks-project/apirest/.env-example") to [`.env`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2F.env%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "/home/gustavo/Development/Cesusc/linguagemDeProgramacao2/Tasks-project/apirest/.env") and update the values according to your environment.

```sh
cp .env-example .env
```

4. Initialize the database:

Ensure PostgreSQL is running and the database is created as per the configuration in `.env`.

5. Start the server:

```sh
npm start
```

### Docker Setup (Optional)

If you prefer using Docker, you can easily set up the environment using Docker Compose.

```sh
docker-compose up -d
```

This command builds the Docker image and starts the containers defined in [`docker-compose.yml`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2Fdocker-compose.yml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "/home/gustavo/Development/Cesusc/linguagemDeProgramacao2/Tasks-project/apirest/docker-compose.yml"), including the PostgreSQL database.

## API Documentation

### Endpoints

#### Users

- **POST /users**: Create a new user.
- **GET /users**: Retrieve all users.
- **GET /users/:id**: Retrieve a single user by ID.
- **PUT /users/:id**: Update a user by ID.
- **DELETE /users/:id**: Delete a user by ID.

#### Tasks

- **POST /tasks**: Create a new task.
- **GET /tasks**: Retrieve all tasks.
- **GET /tasks/:id**: Retrieve a single task by ID.
- **PUT /tasks/:id**: Update a task by ID.
- **DELETE /tasks/:id**: Delete a task by ID.
- **POST /tasks/:id/restore**: Restore a previously deleted task.

### Models

#### User

- [`firstName`](command:_github.copilot.openSymbolFromReferences?%5B%7B%22%24mid%22%3A1%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2Fsrc%2Fmodel%2Fuser.model.js%22%2C%22scheme%22%3A%22file%22%7D%2C%7B%22line%22%3A6%2C%22character%22%3A8%7D%5D "src/model/user.model.js"): String (required)
- [`lastName`](command:_github.copilot.openSymbolFromReferences?%5B%7B%22%24mid%22%3A1%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2Fsrc%2Fmodel%2Fuser.model.js%22%2C%22scheme%22%3A%22file%22%7D%2C%7B%22line%22%3A7%2C%22character%22%3A8%7D%5D "src/model/user.model.js"): String (required)
- [`email`](command:_github.copilot.openSymbolFromReferences?%5B%7B%22%24mid%22%3A1%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2Fsrc%2Fmodel%2Fuser.model.js%22%2C%22scheme%22%3A%22file%22%7D%2C%7B%22line%22%3A8%2C%22character%22%3A8%7D%5D "src/model/user.model.js"): String (required, unique)
- [`password`](command:_github.copilot.openSymbolFromReferences?%5B%7B%22%24mid%22%3A1%2C%22path%22%3A%22%2Fhome%2Fgustavo%2FDevelopment%2FCesusc%2FlinguagemDeProgramacao2%2FTasks-project%2Fapirest%2Fsrc%2Fmodel%2Fuser.model.js%22%2C%22scheme%22%3A%22file%22%7D%2C%7B%22line%22%3A9%2C%22character%22%3A8%7D%5D "src/model/user.model.js"): String (required)

#### Task

- `title`: String (required)
- `description`: String
- `status`: Enum ['pending', 'in_progress', 'completed']
- `userId`: Integer (foreign key to User)

## Development

### Environment Variables

- `PORT`: The port on which the server runs (default: 3000)
- `DB_USERNAME`: PostgreSQL username
- `DB_PASSWORD`: PostgreSQL password
- `DB_DATABASE`: PostgreSQL database name
- `DB_HOST`: PostgreSQL host
- `HASH_KEY`: Key for hashing passwords
- `HASH_ROUND`: Bcrypt hash rounds

### Contributing

Contributions are welcome! Please read our contributing guidelines before submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

This README provides a comprehensive guide to setting up and using the Task API. Adjust the repository URL, contributing guidelines, and any other specific details as necessary for your project.
