#OKHOME solution test 1
1. We have 1 interface need to be implemented
```java
public interface JobCurator {
	void put (Date date) ;
	List<Date> get (Date after) ;
}
```
2. There are 3 inputs: number of services, the date services, and denoting today's date (or current date services).

Solution
1. create a project package and main class file
2. in main class file create a class called JobRun to implement JobCurator interface
3. in class JobRun we override get and put, get to get the dates services and return as list available service date.
4. create a function to convert string to date (string2Date) if date is valid then convert else system exit.
5. create a run function to run the input and print out the result
6. Declare the class JobRun and run in Main class.
