# Fantasy Cycling League Tools

A suite of Spring Boot REST APIs for a Fantasy Cycling League.

[![Deploy to Render](https://render.com/images/deploy-to-render-button.svg)](https://render.com/deploy?repo=https://github.com/lukegjpotter/VamToWkgConverter)

## The Goal

To create a simple tool to convert VAM (Vertical Ascent Meters) to WKG (Watts per Kilo) for Cycling.

## Deployed on Render

This service is deployed live on Render: [VAM to WKG Converter](https://www.postman.com/bold-moon-552911/vam-to-wkg-converter/collection/3947605-f4ce653e-e072-43bc-9d02-46ebebcb466e/?action=share&creator=3947605&active-environment=3947605-66239eed-fd66-476f-ae05-56f00b94bf18).  
It has a prefilled JSON Body ready to recieve your inputs.

Alternatively, you can use `curl`:

    curl -X POST https://vamtowkgconverter.onrender.com/convert \
         -H 'Content-type:application/json' \
         -d '{"verticalAscentMeters": 1606, "gradient": 8.1, "riderWeight": 68.0}' | json

Ensure that you install the `json` tool to format/pretty print the Response.

    sudo npm i -g json

You should get a response that looks like this:

    {
      "wattsPerKilo": 5.72,
      "rawWatts": 388,
      "errorMessage": ""
    }

## Swagger / Spring-Doc / OpenDoc

To view the Swagger UI, click this link to view it on Render: [Swagger UI](https://vamtowkgconverter.onrender.com/swagger-ui/index.html).

## Build, Run and Test

To Do
