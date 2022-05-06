# heatmap-api
- Simple api with two endpoints to destructure OpenAQ data for heatmap frontend.
## Requirements
- Install Java 

## Steps to run heatmap-api
1. Run "git clone https://github.com/AndresBarreraJ/heatmap-api.git"
2. In your console go to where the project directory is located.
  - Navigate with your console to /heatmap-api
  - Another way of doing it is by right click the folder /heatmap-api and select open in new terminal
3. If you have maven and java installed run "mvn spring-boot:run"
4. If you only have java go to the target folder and run "java -jar oracle-test-0.0.1-SNAPSHOT.jar"

## Summary:
### There are 2 endpoints one that accepts country code and measurment parameters and another that accepts decimal coordinates, radius and measurment parameters.
  - For country and measurment parameters an example request is:
    - curl -X 'GET' 'localhost:8080/heatmap/country?country=US&parameter=pm1'
  - For decimal coordinates, radius and measurment parameters an example request is:
    - curl -X 'GET' 'localhost:8080/heatmap/coords?coordinates=35.300823,-120.659546&parameter=pm10&radius=10000'
### The result of the requests consists of two different objects.
##### For the /country endpoint the object looks like:
```json 
 {
  "minVal":0.0,
  "maxVal":13.077741562638,
  "parameter":"pm1",
  "heatMapData":[
    {
      "value":8.11981466899914,
      "latitude":33.480217,
      "longitude":-86.79633
    }
  ],
  "country":"US"
 }
 ```
 ##### For the /coords endpoint the response looks very similar except with no country information
 ```json
  {
  "minVal":0.0,
  "maxVal":13.077741562638,
  "parameter":"pm1",
  "heatMapData":[
    {
      "value":8.11981466899914,
      "latitude":33.480217,
      "longitude":-86.79633
    }
   ]
 }
 ```
 
