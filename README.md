# atmlocator

1.	I created a Spring rest service to fetech all the ATMs of passed city in URL.
Below the URL to get the ATM list of city.

http://localhost:8080/atmLocator/atm/city/cityName

Just pass the city name and it will return all the ATM’s list in JSON format.
a.	I have created coupld of Helper and Domain objects for data processing.
b.	RestTemplate used to fetech the all ATM list.
c.	Spring Caching can be used to saved the ATM list but it’s later implementation.
d.	Spring Exception Hanlding also need to implement.

2.	I never used Apache Camel so it’s time consuming for me to integrate Spring Rest with Camel. By the time I understand Camel routing, it’s bit late as I need to choose either Restlet or Spark-rest for my rest API development. But now I understand Camel and can integrate with Rest. 
3.	I created a another rest service AtmLocationService to integrate with Camel and try to write the routing code. I used the same classes to fetch the ATM list which I used with Spring REST.
4.	I used REST DSL with java to route the service.

