# Lite tms

The most lite and cool test management system you've ever seen

## Run

For local run use command:
```
make dev_env
```

Which do next:
 * `make run_mysql` - run mysql
	  
 * `make run_events_logger` - compile and package war file and run docker container with tms

To run only application:
```
make run_events_logger
```  

To run only container run:
```
docker run --rm -p 80:80 -p 443:4443 -p 8080:8080 --name lite-tms perfect-test/lite-tms:latest 
```



