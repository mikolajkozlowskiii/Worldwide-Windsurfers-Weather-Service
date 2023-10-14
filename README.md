# Worldwide-Windsurfers-Weather-Service
REST API exposing endpoints to find the best windsurfing location.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Running the application locally
```shell
 mvn spring-boot:run -Dspring-boot.run.arguments=--WEATHERBIT_API_KEY=<YOUR_API_KEY>
```
In `<YOUR_API_KEY>` you need to insert key from [weatherbit api](https://www.weatherbit.io/).\
Alternatively, you can set the WEATHERBIT_API_KEY environment variable with the appropriate key, and then use:
```shell
 mvn spring-boot:run 
```


## Explore Rest API
### Finding best windsurfing location.
| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET   | /api/v1/best  | currently best location for windsurfing | [JSON](#best) |

## Sample Valid JSON Request Body
##### <a id="best">Currently best location -> /api/v1/best</a>
```json
{
  "city_name": "Jastarnia",
  "country_code": "PL",
  "temp": 17.5,
  "wind_spd": 9.341141
}
```
