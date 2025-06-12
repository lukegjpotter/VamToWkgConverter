# VAM to WKG Converter

A suite of Spring Boot REST APIs for a VAM to WKG Converter.

[![Deploy to Render](https://render.com/images/deploy-to-render-button.svg)](https://render.com/deploy?repo=https://github.com/lukegjpotter/VamToWkgConverter)

## The Goal

To create a simple tool to convert VAM (Vertical Ascent Meters) to WKG (Watts per Kilo) for Cycling.

## Build, Run and Test

### Gradle Wrapper CLI

You can build and run this application from the Command Line with the Gradle Wrapper with:

    ./gradlew clean build bootRun

For subsequent runs, where you haven't made Source Code changes, you don't need the `clean` and `build` tasks,
so just `./gradlew bootRun` will do the job.

### Docker

Build the Docker Image with the following Command:

    docker build --pull -t vam-to-wkg-converter:latest .

This command presumes that you are in the directory with this application's Dockerfile.  
You can see the built Image with `docker image ls`.  
Later you can remove the Image with `docker image rm <image id sha>`.

Run the Image as a Docker Container with the following Command:

    docker run --name vam-to-wkg-converter \
       -p 8080:8080 \
       -d --rm vam-to-wkg-converter:latest

You can see the Container running with `docker ps` or `docker container ls`,  
Although, the `run` command has the `--rm` flag set, so the container will remove itself after you stop it, so it will
not be shown in `conatiner ls` after you stop the Container.  
Stop it with `docker stop vam-to-wkg-converter`.

## Test with Curl or Postman

### Curl

For both Docker and CLI Gradle Wrapper ways on running this application, you can use `curl` as follows:

    curl -X POST http://localhost:8080/convert \
         -H 'Content-Type: application/json' \
         -d '{
                 "verticalAscentMeters": 1606,
                 "gradient": 8.1,
                 "riderWeight": 68.0
             }' | json

Note that it's `http` and not `https` for running on `localhost`.

Result:

    {
        "wattsPerKilo": 5.72,
        "rawWatts": 388,
        "errorMessage": ""
    }

### Postman

You can use this Postman
Collection, [VAM to WKG Converter](https://www.postman.com/bold-moon-552911/vam-to-wkg-converter/collection/6rjgzjb/vam-to-wkg-converter?action=share&creator=3947605&active-environment=3947605-66239eed-fd66-476f-ae05-56f00b94bf18),
it has the prefilled JSON bodies, and the Render URL configured.

### Spring Doc Open API

Formerly known as Swagger-UI, you can append the `/swagger-ui/index.html` to your URL.

Links: [localhost](http://localhost:8080/swagger-ui/index.html)
or [Render](https://vamtowkgconverter.onrender.com/swagger-ui/index.html).

