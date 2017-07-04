# BigData_Session3_Assignment2


<<<<<<<<<<<<<<<------------- Problem Statement ------------>>>>>>>>>>>>>>>>

We have a dataset of sales of different TV sets across different locations.
Records look like:

Samsung|Optima|14|Madhya Pradesh|132401|14200

The fields are arranged like:

Company Name|Product Name|Size in inches|State|Pin Code|Price
.
Onida|NA|16|Kerala|922401|12200
.
NA|Lucid|18|Uttar Pradesh|232401|16200
.
.

There are some invalid records which contain 'NA' in either Company Name or Product Name.

Associated Data File Provided : television.txt

1. Write a Map Reduce program to filter out the invalid records. Map only job will fit for this context.

<<<<<<<<<<<<<<<------------- SOLUTION ------------>>>>>>>>>>>>>>>>

(i) Two .java files are created:
-> Driver Class: 'MRTask1.java' which controls configuration/properties/attributes of Map file
-> Mapper Class: 'MRMapperTask1.java', which does map processing on input data and generates expected output



(ii) Screenshots 1-9 describe how map processing takes place
 
