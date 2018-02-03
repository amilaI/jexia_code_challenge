# Jexia Code Challenge | Back-end Start Trek Test
***********************************************

Author: Amila Iddamalgoda, Colombo, Sri Lanka
*********************************************

Task Brief Overview
-------------------
The task is to translate a name written in English to Klingon and find out its species using ​ http://stapi.co​ .

Run Project
-----------
./jexia_app.sh <Input Argument>
Example :-
./jexia_app.sh Spock


Technical Essentials
********************

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

./jexia_app.sh Spock

Name : Spock
Species : [Human, Vulcan]

-------------------------
./jexia_app.sh Nyota Uhura

Name : Nyota Uhura
Species : [Human]

-------------------------
./jexia_app.sh Amila

No result found for your query Amila

-------------------------
./jexia_app.sh Terrina

Sorry! No species found for Terrina

-------------------------
./jexia_app.sh Leonard

Name : Leonard McCoy
Species : [Terran]

-------------------------
./jexia_app.sh Bareil Antos

Name : Bareil Antos
Species : [Bajoran]
