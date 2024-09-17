package tsn;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;

import checker.checker;
import parser.stream;
import parser.topology;
import results.result;
import parser.parser;

public class main {

	
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
    	System.out.println("Program Start");
    	  Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    	  System.out.println("Enter  path of Streams file ");
    	 String streams = myObj.nextLine();
    	  System.out.println("Enter  path of Topolgy file ");
     	 String tpath = myObj.nextLine();
		JSONParser parser = new JSONParser();
		parser pass = new parser();
		ArrayList<stream> output =  pass.parsestream(streams);
		topology outtop = pass.parsestopology(tpath);
		System.out.println("Parsing Complete");
		System.out.println("Choose an Option to  Execute");
		 Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
			System.out.println("1.Check Parsing  - 2.Procces Tsn Resualts");
        	 String option = myObj.nextLine();
        	 if (option.equals("1"))
        	 {
        			System.out.println("Cheking Proccing");

        			checker ch = new checker();
        			ch.checkstreams(streams);
        			ch.checktop(tpath);

        	 }
        	 else {
        		 if (option.equals("2"))
            	 {
            			System.out.println("TSN Hericstic  Proccing");

            			result tsnresults = new result();
            			tsnresults.result(streams, tpath);           
          

            	 } else {
         			System.out.println("Choose vailed option");

            	 }
        	 }
		
	}

}
