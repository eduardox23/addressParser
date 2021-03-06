# addressParser

# Problem:

Addressline

An address provider returns addresses only with concatenated street names and numbers. Our own system on the other hand has separate fields for street name and street number.

Input: string of address

Output: string of street and string of street-number as JSON object

Write a simple program that does the task for the most simple cases, e.g.

"Winterallee 3" -> {"street": "Winterallee", "housenumber": "3"}
"Musterstrasse 45" -> {"street": "Musterstrasse", "housenumber": "45"}
"Blaufeldweg 123B" -> {"street": "Blaufeldweg", "housenumber": "123B"}
Consider more complicated cases

"Am Bächle 23" -> {"street": "Am Bächle", "housenumber": "23"}
"Auf der Vogelwiese 23 b" -> {"street": "Auf der Vogelwiese", "housenumber": "23 b"}
BONUS: Consider other countries (complex cases)

"4, rue de la revolution" -> {"street": "rue de la revolution", "housenumber": "4"}
"200 Broadway Av" -> {"street": "Broadway Av", "housenumber": "200"}
"Calle Aduana, 29" -> {"street": "Calle Aduana", "housenumber": "29"}
"Calle 39 No 1540" -> {"street": "Calle 39", "housenumber": "No 1540"}

-----------------------------------------------------------------------
# Solution:

Instructions

To compile and run this project you will need:

**Java 8 (JDK8)**
**Maven 3.6 or grater**

To start the app
```bash
mvn spring-boot:run
```
To access the app
The base path for the app endpoins is: **/address**

Application default port **:8080**

To test the app via browser:  **/address?address=param**
Where **param** is the address string desired to be parsed 

To run all unit and integration tests use the command bellow
```bash
mvn test
```
