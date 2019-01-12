package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner<Text, IntWritable> {
	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		// customize which <K ,V> will go to which reducer
		Character c = key.toString().toCharArray()[0];
		if(Character.toUpperCase(c)>'G')
			return 1;
		return 0;
	}
}
