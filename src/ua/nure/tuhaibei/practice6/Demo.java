package ua.nure.tuhaibei.practice6;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import ua.nure.tuhaibei.practice6.part1.Part1;
import ua.nure.tuhaibei.practice6.part2.Part2;
import ua.nure.tuhaibei.practice6.part3.Part3;
import ua.nure.tuhaibei.practice6.part4.Part4;
import ua.nure.tuhaibei.practice6.part5.Part5;
import ua.nure.tuhaibei.practice6.part6.Part6;

public class Demo {
	 static final InputStream STD_IN = System.in;

	    public static void main(String[] args) throws Exception {
	    	   System.out.println("~~~~~~~~~~~~Part1");
	           ByteArrayInputStream in = new ByteArrayInputStream("asd 43 asdf asd 43 434 asdf kasdf asdf stop asdf stop".getBytes());
	           System.setIn(in);
	           Part1.main(args);
	           System.setIn(STD_IN);
	           System.out.println("~~~~~~~~~~~~Part2");
	           Part2.main(args);
	           System.out.println("~~~~~~~~~~~~Part3");
	           Part3.main(args);
	           System.out.println("~~~~~~~~~~~~Part4");
	           Part4.main(args);
	           System.out.println("~~~~~~~~~~~~Part5");
	           Part5.main(args);
	           System.out.println("~~~~~~~~~~~~Part6");
	           Part6.main(new String[] {"-i", "part6.txt", "-t", "frequency"});
	           Part6.main(new String[] {"--input", "part6.txt", "--task", "length"});
	           Part6.main(new String[] {"--input", "part6.txt", "--task", "duplicates"});
	    }
}