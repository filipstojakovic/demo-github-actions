## Setting Up Self-Hosted GitHub Runner with Docker

### Prerequisites

- Docker installed on your machine.
- GitHub repository where you want to use the self-hosted runner.
- Docker Hub account for pushing Docker images.

### Steps

#### 1. Create Repository Secrets

Add the following secrets in your GitHub repository settings:

- `DOCKER_USERNAME`: Your Docker Hub username.
- `DOCKER_PASSWORD`: Your Docker Hub generated token (used for authentication).

#### 2. Build the Runner Docker Image

```cmd
docker build . -t runner-with-docker --build-arg TOKEN=<YOUR_RUNNER_TOKEN> -f runner.Dockerfile
```

Replace <YOUR_RUNNER_TOKEN> with your GitHub runner token obtained from your repository's settings (Settings > Actions > Add Runner).

#### 3. Run the Docker Container

```cmd
docker run -v //var/run/docker.sock:/var/run/docker.sock runner-with-docker
```
This command starts the Docker container named runner-with-docker and mounts the host's Docker socket into the container, allowing the runner to interact with the host's Docker daemon.

### Important Notes
* Ensure that your Docker Hub credentials (DOCKER_USERNAME and DOCKER_PASSWORD) are correctly set as repository secrets in GitHub to enable Docker image push.
* The runner.Dockerfile should be tailored to your specific runner needs, ensuring that necessary tools and dependencies are installed.
* Replace placeholders like <YOUR_RUNNER_TOKEN> with actual values as per your configuration.
