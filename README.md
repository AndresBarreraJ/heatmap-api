# heatmap-api
Simple api with two endpoints to destructure OpenAQ data for heatmap frontend.

Steps to run heatmap-api
1. git clone https://github.com/AndresBarreraJ/heatmap-api.git
2. In your console to where the project directory is located.
3. mvn spring-boot:run

Summary:
There are 2 endpoints one that accepts country code and measurment parameters and another that accepts decimal coordinates, radius and measurment parameters.
  - For country and measurment parameters the curl is:
    - curl -X 'GET' 'localhost:8080/heatmap/country?country=US&parameter=pm1'
  - For decimal coordinates, radius and measurment parameters the curl is:
    - curl -X 'GET' 'localhost:8080/heatmap/coords?coordinates=35.300823,-120.659546&parameter=pm10&radius=10000'
