# txodds-collatz testing
## Summary
Written in java utilising a junit test harness, using an Eclipse IDE.
## Usage (how to run)
For each java test suite (runner class) you need to restart the server (java -jar HttpCollatz.jar)
From the Eclipse IDE you can select Run when focus is either on the Test Suite or a Test Case.


## Caveates/excuses
I didn't get time to create a command line version.
I didn't get time to work out how to parse SSE continuous stream, although I did manage to stream the data.
The very basic performance baseline test seems to crash the server on my machine (as I expected).
I didn't run out of tests to write just time to write them.
There appears to be lots of issues with the server functionality.



## Test Suites (Test cycles/Test runner classes)
````
1. RunBasics
Here I created approx 22 tests and some things failed as expected (negative tests), and some thing should have failed (like negative numbers for the starting number or increment).
I have attempted to document the test cases in situ. Hope they are clear.
````
````
2. RunHttpClientSSE
Managed to create a class that captured the streaming events but couldn't work out how parse them once I had them.
I had intended to use this to test the collatz conjecture.
But didn't get that far, I left may attempt there. 

````
````
3. RunPerformanceBaseline
Attempt to get a baseline by creating 9223372036854775807 machines and then destroying the machines. 
Taking the nanosecond time both before and after and then diffing the time.
But it seems to crash the server (likely my machine isn't powerful enough) and I have ran out of time trying to develop a reliable performance baseline.
````


## Test cases
````
TestCase000BoundaryChecks
tc000-boundary checks (negative tests)
m/c id cannot be less than 1
m/c id MAX = 9223372036854775807
m/c id MAX + 1 = -9223372036854775808 Should not be allowed
start number = -1 cannot be less than 1 (collatz cannot be -ve number).
start number cannot be max long value 9223372036854775807 as calculations produce -ve results
increment = -1 cannot be less than 1 (collatz cannot be -ve number).
increment cannot be max long value 9223372036854775807 as calculations produce -ve results
````
````
TestCase000Create
tc000-post-create-missing start number (negative test)
curl -X POST "http://127.0.0.1:8080/create/1"

````
````
TestCase000Destroy
tc000-post-destroy-non-existing machine id (negative tests)
curl -X POST "http://127.0.0.1:8080/destroy/1"

````
````
TestCase000Increment
tc000-post-increment-non-existing machine id (negative tests)
curl -X POST "http://127.0.0.1:8080/destroy/1"

````
````
TestCase001
tc001-post-create-odd-1-3 	
curl -X POST "http://127.0.0.1:8080/create/1/3"

````
````
TestCase002
tc002-post-destroy-odd-1-3 	
curl -X POST "http://127.0.0.1:8080/destroy/1"

````
````
TestCase003
tc003-post-create-even-1-4	
curl -X POST "http://127.0.0.1:8080/create/1/4"

````
````
TestCase004
tc004-post-destroy-even-1-4	
curl -X POST "http://127.0.0.1:8080/destroy/1"

````
````
TestCase005
tc005-post-create-increment-destroy-odd
curl -X POST "http://127.0.0.1:8080/create/1/3"
curl -X POST "http://127.0.0.1:8080/increment/1/9"
curl -X POST "http://127.0.0.1:8080/destroy/1"

````
````
TestCase006
tc006-post-create-increment-destroy-even
curl -X POST "http://127.0.0.1:8080/create/1/8"
curl -X POST "http://127.0.0.1:8080/increment/1/20"
curl -X POST "http://127.0.0.1:8080/destroy/1"

````