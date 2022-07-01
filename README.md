task01:
runcode: from target folder
java -jar task01-1.0-SNAPSHOT.jar <CSV file> <template file>
Example:
java -jar task01-1.0-SNAPSHOT.jar "D:/VisaWorkshop/SDFA/task01/src/main/java/myApp/tour_packages.csv" "D:/VisaWorkshop/SDFA/task01/src/main/java/myApp/tour_packages.txt"

java -jar task01-1.0-SNAPSHOT.jar "D:/VisaWorkshop/SDFA/task01/src/main/java/myApp/thankyou.csv" "D:/VisaWorkshop/SDFA/task01/src/main/java/myApp/thankyou.txt"     

Main Class:
VTTP-SDF-Assessment/task01/src/main/java/myApp/Merge

task01: 
runcode:
mvn compile exec:java -Dexec.mainClass="myApp.Client"
