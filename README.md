# Rental-Property-Management-System
## Authors
* Ahmed Waly
* Kai Wang
* Jaxson Waterstreet
* Dylan Windsor
* Mohamed Yassin

## Purpose & How We Built It
The purpose of this application is to create a platform that landlords, property managers and renters can simultaneously use to manage their real estate needs. It is important for us that the users have a simple, yet intuitive interface to use, and so we built a consistent, easy-to-use GUI using Swing and applied error checking and hints wherever needed. As well, most data is stored and manipulated using Java and MySQL so that we can easily link tables of data between various stages of the application. Lastly, we used this application as an opportunity to apply design principles and patterns to build a modular and well-documented application that can be improved at any time, some prominent examples are Class, Sequence and Transition diagrams in the design phase, as well as the Singleton design pattern and Model-View-Controller pattern in the implementation phase.

## Steps to Compile and Run the Application:
  1. Clone The Repository on your local device.
  2. If your local device already has a mysql table that is named "mydb", drop it.
  3. Source the sql file on the MySQL Command Line(make sure to include your full path in the command)
  4. Open the jar file or follow the following steps to run from your command line
  5. Navigate to the src folder in your compiler
  6. To Compile Run The following command line in your compiler ```javac -cp .;../lib/mysql-connector-java-8.0.23.jar;.GUI/*.java controller/*.java model/*.java```
  7. To Run, ```java -cp .;../lib/mysql-connector-java-8.0.23.jar;. GUI/MainGUIClass```
## Sample Screenshots 
### Main Menu:

![image](https://user-images.githubusercontent.com/73013959/145513864-858438ab-718b-4216-8284-137f5fe194db.png)

### Registered Renter Screen:

![image](https://user-images.githubusercontent.com/73013959/145513919-0062375b-dcca-4802-972f-a5d0be899bb8.png)

### Landlord Screen:

![image](https://user-images.githubusercontent.com/67707288/145515253-bb32773d-a0f9-439c-87a3-5642bf3361f6.png)

### Email System:

![image](https://user-images.githubusercontent.com/73013959/145513939-c49b4bce-4e34-42ad-874e-03ecb87dd385.png)

### Landlord Register-A-Property Screen:

![image](https://user-images.githubusercontent.com/73013959/145514039-00b68727-94c6-41fb-a21d-0048a095db05.png)

### Unregistered Renter (Guest) Screen

![image](https://user-images.githubusercontent.com/67707288/145514385-9d89e2e0-debb-4e13-8fd2-dafefe815db8.png)

### Manager Screen

![image](https://user-images.githubusercontent.com/67707288/145514491-b47f1e8d-617e-41ba-944b-773d55b57824.png)
