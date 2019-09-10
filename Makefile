LOCAL_ENV_DOCKER_COMPOSE_FILE = dockerfiles/dev/docker-compose.yml

run_mysql:
	docker-compose -f ${LOCAL_ENV_DOCKER_COMPOSE_FILE} up -d --build mysql

run_lite-tms:
	docker-compose -f ${LOCAL_ENV_DOCKER_COMPOSE_FILE} stop lite-tms
	docker-compose -f ${LOCAL_ENV_DOCKER_COMPOSE_FILE} rm -f lite-tms
	mvn clean package -Dmaven.test.skip=true
	cp -f target/lite-tms.war dockerfiles/dev/lite-tms
	docker-compose -f ${LOCAL_ENV_DOCKER_COMPOSE_FILE} up -d --build lite-tms

dev_env: stop_dev_env run_mysql run_lite-tms

stop_dev_env:
	docker-compose -f ${LOCAL_ENV_DOCKER_COMPOSE_FILE} down


