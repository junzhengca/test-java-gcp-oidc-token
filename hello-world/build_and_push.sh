#!/bin/bash

# Build the Docker image
docker build -t us-docker.pkg.dev/test-impersonation-438218/test-hello-world/test-hello-world:latest .

# Push the Docker image to the Docker Hub repository
docker push us-docker.pkg.dev/test-impersonation-438218/test-hello-world/test-hello-world:latest
