package wordcount;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class WordCountKeyComparator extends WritableComparator {
	
	public WordCountKeyComparator() {
		super(Text.class, true);
	}	
	
	public int compare(WritableComparable o1, WritableComparable o2) {
		Text key1 = (Text) o1;
		Text key2 = (Text) o2;

		// TODO Order by A -> a -> B -> b ....
		char c1 = key1.toString().toCharArray()[0];
		char c2 = key2.toString().toCharArray()[0];
		
		if(c1==c2)
			return 0;
		else if(Character.toUpperCase(c1)== Character.toUpperCase(c2))
			return Character.compare(c1, c2);
		else
			return Character.compare(Character.toUpperCase(c1), Character.toUpperCase(c2));

	}
}
