# Jexia Code Challenge | Back-end Start Trek Test
***********************************************

Author: Amila Iddamalgoda, Colombo, Sri Lanka
*********************************************

Task Brief Overview
-------------------
The task is to translate a name written in English to Klingon and find out its species using ​ http://stapi.co​ .

Run Project
-----------
./jexia_app.sh your_query

Example :-

./jexia_app.sh Spock


Technical Essentials
--------------------

Programming Language used to solve this problem
-----------------------------------------------
Java

Other libraries used
--------------------
Apache Maven for dependency management (apache-maven-3.3.9)

Java 8 (1.8.0_77)

Google gson serialization/deserialization library to convert Java Objects into JSON and back (gson-2.8.2)

Apache commons-lang3 library as an advanced Java util.


Build Project (Project is already built with dependencies.
----------------------------------------------------------
cd code

mvn clean install package


Program Arguments Samples
*************************

amilai@amilai-Latitude-E6440:~/jexia/jexia_code_challenge$ ./jexia_app.sh Nyota Uhura

Welcome to Jexia Code Challenge | Back-end Start Trek Test

Processing... Please Wait! :) 

0xF8DB  0xF8E8  0xF8DD  0xF8E3  0xF8D0    0x0020  0xF8E5  0xF8D6  0xF8E5  0xF8E1  0xF8D0
Yeah! Result found in 6 seconds. :) 

Name : Nyota Uhura
Species : [Human]

-----------------------------------------------------------------------------------------------

./jexia_app.sh Bareil Antos

Welcome to Jexia Code Challenge | Back-end Start Trek Test

Processing... Please Wait! :) 

0xF8D1  0xF8D0  0xF8E1  0xF8D4  0xF8D7  0xF8D9    0x0020  0xF8D0  0xF8DB  0xF8E3  0xF8DD  0xF8E2 
Yeah! Result found in 4 seconds. :) 

Name : Bareil Antos
Species : [Bajoran]




