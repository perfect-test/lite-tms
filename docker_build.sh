#!/usr/bin/env bash
# Build Java-project and package it to war-file
mvn clean package -Dmaven.test.skip=true

# Get variables from config-file
source ./docker.properties

# Copy packaged war-file to docker directory
if ! [ -f target/${APP_NAME}.war ]; then
    echo "There is not '$APP_NAME.war' file in target directory."
    exit 1
fi
cp -f target/$APP_NAME.war dockerfiles/dev/lite-tms

# Build docker image
#docker build -t registry.rtty.in/${REPOSITORY}/${APP_NAME}:${VERSION}  .
docker build -f dockerfiles/dev/lite-tms/Dockerfile -t registry.rtty.in/${REPOSITORY}/${APP_NAME}:${VERSION} -t registry.rtty.in/${REPOSITORY}/${APP_NAME}:latest ./dockerfiles/dev/lite-tms/

# Push docker image to registry
#docker push registry.rtty.in/${REPOSITORY}/${APP_NAME}:${VERSION}
#docker push registry.rtty.in/${REPOSITORY}/${APP_NAME}:latest

