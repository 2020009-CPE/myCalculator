javac njcalculator.java
javac -d . njcalculator.java
jar -cvfm njcalculator.jar manifest.mf *.class
java -jar njcalculator.jar