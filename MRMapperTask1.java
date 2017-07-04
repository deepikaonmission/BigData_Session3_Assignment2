//********* Mapper Task ********* //

package com.acadgild.mapreducetask1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;

//***** MRMapperTask1 class description *****//
//first two arguments of Mapper class work for input, and last two arguments work for output
public class MRMapperTask1 extends Mapper <LongWritable, Text, Text, Text>
{
	//***** setup() method description *****//
	//used to setup connection with DB like in case of jdbc, here we don't need to override this method
	
	public void setup() {}  

	//***** map() method description *****//
	//Input to map method is in the form of key-value pair,
	//Therefore, key is taken as LongWritable and whole value is taken as Text
	//context (object of Context class) here works to match the value generated by the map method to match correctly with Mapper class last two arguments i.e. Text and Text

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String[] lineArray = value.toString().split("\\|");  //this line of code splits the values of a record on the basis  of "|" delimiter, since | has predefined meaning,therefore \\ is used to escape from its predefined meaning and split values are stored in lineArray
		String compName = new String(lineArray[0]); //this line of code fetches first value of lineArray, i.e. company_name 
		String prodName = new String(lineArray[1]); //this line of code fetches second value of lineArray i.e. product_name
		String valNA = new String("NA");  //this line of code creates String object with value NA
		
		if ((compName.equals(valNA)) || (prodName.equals(valNA)))  //this line of code compares compName and prodName with valNA (i.e. "NA"), if value of either matches with valNA, then this if block executes
		{
			Text outputText = new Text("Invalid Record: ");  //this line of creates Text object with value "Invalid Record" 
			context.write(outputText, value);  //this line of code writes output ( e.g. Invalid Record: Onida|NA|16|Kerala|922401|12200) to local fs of map machine 
		}
		
	}
	public void cleanup() {} //this method cleans up the resources used by the program, here we don't need to override this method
}