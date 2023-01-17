phpTravel registration  Automation Task 
This project is a testng , maven project using POM design pattern with excel to read data.
Project consists of pages and test packages where pages have all included elements and test have test cases to run
Pagebase: where it has all common between all other pages working as parent class (driver,the scroll down, the wait for elements )
There are other 3 pages (login, registration, welcome) each of them has its own element and a method for each element to do its function correctly based on elements type

Testbase: where it has all common between all other testcases working as parent class, also it contains methods needed to run before and after execution of test case in the form of annotations before each method, it has 2 browsers to run any one of them you can change it from the testing.xml by writing “chrome” or “firefox” in the value field.
All test cases are having @test annotation before the method working as a testcase, contains a method  for reading data from excel file ,which is added as a file in the project, it uses data provider annotation.
A report is handled with screenshots using extent report 
After failure of any test case the browser closes and report is generated 
