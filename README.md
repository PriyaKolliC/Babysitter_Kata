## Babysitter Kata


## Problem statement

This kata simulates a babysitter working and getting paid for one night.  The rules are pretty straight forward:

The babysitter 
- starts no earlier than 5:00PM
- leaves no later than 4:00AM
- gets paid $12/hour from start-time to bedtime
- gets paid $8/hour from bedtime to midnight
- gets paid $16/hour from midnight to end of job
- gets paid for full hours (no fractional hours)

Feature:
As a babysitter
In order to get paid for 1 night of work
I want to calculate my nightly charge

## Key Points
- The exercise is solved using Java.
- I also present some JUnit tests to validate the functionality of modules (test driven code).
- Please refer **Understanding Problem Statement** file to understand the objective and find key takeaways to solve the problem.

#### Input
- Three **integer** inputs holding start time, bed time, and end time in order.

#### Output
- The total pay for 1 night of work

#### Usage
- Download the project and open it in package explorer in IDE (used Eclipse).
- Create a new class and create an instance of **Babysitter_Dev** class to be able to call the method to calculate the total pay.
- Call the method **getTotalPay()** with three integer inputs being start time, bed time and end time respectively. 
- E.g. **getTotalPay(5, 10, 2)** where 5 pm is the start time, 10 pm is the bed time and 2 am is the end time.
