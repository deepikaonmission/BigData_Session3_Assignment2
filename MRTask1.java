//Program which controls configuration/properties/attributes of Mapper and Reducer (Here we are not dealing with reducer)

package com.acadgild.mapreducetask1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;


import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;




public class MRTask1 {

	public static void main(String[] args) throws Exception 
	{
		
		Configuration conf = new Configuration(); //provides access to configuration details of Mapper and Reducer
		Job job = Job.getInstance(conf, "MRJobTask1");  //Job class object is created which is given a job name "MRJobTask1", and in further lines properties are set using the "job" object
		
		job.setJarByClass(MRTask1.class);  //Main class file is included in jar
		
		job.setMapOutputKeyClass(Text.class); //Mapper output key is set to Text
		job.setMapOutputValueClass(Text.class); //Mapper output value is set to Text
		
		job.setMapperClass(MRMapperTask1.class); //Mapper class name is provided
		
		job.setNumReduceTasks(0); //As the given problem statement does not need reducer, so no. of reducers are set to 0
		
		job.setInputFormatClass(TextInputFormat.class);  // Input format of input file is set, as we are dealing with text file which contains words with spaces and delimiters (|)
		//job.setOutputFormatClass(TextInputFormat.class); //do not need to set output format of class as we are not dealing with reducer over here
		
		FileInputFormat.addInputPath(job, new Path(args[0]));  //input path of text file is added, whose value will be given at command prompt, thereby will be used by mapper as input data 
		FileOutputFormat.setOutputPath(job, new Path(args[1])); //output path of directory is set, where mapper will store its final output
		
		job.waitForCompletion(true); //submits the job and waits for completion of job
		
	}
}
