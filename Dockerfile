# github action Self runner
FROM debian:latest

ARG TOKEN=not-set

RUN apt-get update && \
    apt-get install -y curl libgtk-dotnet3.0-cil && \
    apt-get clean

# Install any other required packages here

ENV RUNNER_ALLOW_RUNASROOT=1

WORKDIR /runner

RUN curl -o actions-runner-linux-x64-2.314.1.tar.gz -L https://github.com/actions/runner/releases/download/v2.314.1/actions-runner-linux-x64-2.314.1.tar.gz && \
    tar xzf actions-runner-linux-x64-2.314.1.tar.gz && \
    rm actions-runner-linux-x64-2.314.1.tar.gz

RUN ls | echo

RUN ./config.sh --url https://github.com/filipstojakovic/demo-github-actions --token $TOKEN
    # --name linux --work _work --runasservice --disableupdate

CMD ["./run.sh"]
