package edu.cofc.cs.csci230;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class TestHashing {
	
	
	
	public static String removeAllNumbers(String text){
		text = text.replaceAll("\\d","");
		return text;	
	}

	public static String removeAllBadSpaces(String text){
		text = text.replace("\n", " ");
		text = text.trim().replaceAll(" +", " ");
		return text;
	}

	public static String removeSpecialCharacters(String text){
		text = text.replaceAll("[^\\w\\s]", "");
		return text;
	}
	
	public static int countDup(String word, String[] list){
		int count =0;
		for (int i = 0; i < list.length ; i++){
			if(list[i].equals(word)){
				count++;
			}
		}
		return count-1;
		
	}
	
	public static String[] removeAllDups(String[] text){
		int noOfUniqueElements = text.length;
        for (int i = 0; i < noOfUniqueElements; i++) {
            for (int j = i+1; j < noOfUniqueElements; j++) {  
                if(text[i].equals(text[j])){    
                	text[j] = text[noOfUniqueElements-1];
                	noOfUniqueElements--;         
                    j--;
                }
            }
        }      
        
        String[] processedText = Arrays.copyOf(text, noOfUniqueElements);
		return processedText;
	}

	public static String[] processText(String rawText){
		String[] wordListNoDup=null;
		rawText = rawText.toLowerCase();
		rawText = removeAllNumbers(rawText);
		rawText = removeAllBadSpaces(rawText);
		rawText = removeSpecialCharacters(rawText);
		wordListNoDup = removeAllDups(rawText.split("\\s+"));
		return wordListNoDup;
	}
	
	public static String fileToString(String fileName){
		File file = new File(fileName);
		Scanner scanner;
		String rawText = "There is an error.";
		try {
			scanner = new Scanner(file);
			rawText = "";
			while(scanner.hasNextLine()){
				rawText+= scanner.nextLine()+ "\n";
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return rawText;	
		
	}

	public static void main( String[] args ){
		String test1File = "winemake.txt";
		//String test2File = "library.txt";
		
		
		
		
		
		
		
		//Test 1
		System.out.println("|=================================|");
		System.out.println("|=============TEST 1==============|");
		System.out.println("|=================================|");
		System.out.println("|---File: " +test1File + "-------------|");
		System.out.println("|---------------------------------|\n");
		String processedWordList[] = processText( fileToString(test1File));	
		
		ClosedHashing closedhash = new ClosedHashing(processedWordList.length, 0);
		OpenHashing openhash = new OpenHashing(processedWordList.length, 0);
		
		
		
		for(int i =0; i<processedWordList.length/2; i++){	
			closedhash.insert(processedWordList[i]);
			openhash.insert(processedWordList[i]);
			
		}
		
		
		//closed  function1 success
		String CsucessfullTime = "";
		for(int i =0; i<processedWordList.length/2; i++){
			long start = System.nanoTime();
			closedhash.search(processedWordList[i]);
			
			long end = System.nanoTime();
			long duartionSucessfullTimetion = end - start;
			
			CsucessfullTime+= duartionSucessfullTimetion+ "\n";
		}
		
		
		//closed  function1 unsuccess
		String CunsucessfullTime = "";
		for(int i =processedWordList.length/2; i<processedWordList.length; i++)	{
			
			
			long start1 = System.nanoTime();
			
			closedhash.search(processedWordList[i]);
			
			long end1 = System.nanoTime();
			long durationUnsucessfullTime = end1 - start1;
			
			CunsucessfullTime+= durationUnsucessfullTime+ "\n";
			
			
		}
			
		
		
		//open  function1 success
		String OsucessfullTime = "";
		for(int i =0; i<processedWordList.length/2; i++){
			long start = System.nanoTime();
			openhash.search(processedWordList[i]);
		
			long end = System.nanoTime();
			long duartionSucessfullTimetion = end - start;
			
			OsucessfullTime+= +duartionSucessfullTimetion+ "\n";
		}
		
		
			
			
		
		//open  function1 unsuccess
		String OunsucessfullTime = "";
		for(int i =processedWordList.length/2; i<processedWordList.length; i++)	{
			
			
			long start1 = System.nanoTime();
			openhash.search(processedWordList[i]);
			
			long end1 = System.nanoTime();
			long durationUnsucessfullTime = end1 - start1;
			
			OunsucessfullTime+= durationUnsucessfullTime+ "\n";
			
			
		}
	
		
		
		
		System.out.println("|------ClosedHash Function 1------|\n");
		System.out.println(closedhash.getTests());
		
		System.out.println("|-------OpenHash Function 1-------|\n");
		System.out.println(openhash.getTests());
	
		
		
		
		
		ClosedHashing closedhash1 = new ClosedHashing(processedWordList.length, 1);
		OpenHashing openhash1 = new OpenHashing(processedWordList.length, 1);
		
		for(int i =0; i<processedWordList.length/2; i++){	
			closedhash1.insert(processedWordList[i]);
			openhash1.insert(processedWordList[i]);
		}
		
		
		
		//closed  function1 success
		String CsucessfullTime1 = "";
		for(int i =0; i<processedWordList.length/2; i++){
			long start = System.nanoTime();
			closedhash1.search(processedWordList[i]);
			
			long end = System.nanoTime();
			long duartionSucessfullTimetion = end - start;
			CsucessfullTime1+=duartionSucessfullTimetion+ "\n";
		}
				
				
		//closed  function1 unsuccess
		String CunsucessfullTime1 = "";
		for(int i =processedWordList.length/2; i<processedWordList.length; i++)	{
			long start1 = System.nanoTime();
			closedhash1.search(processedWordList[i]);
			
			long end1 = System.nanoTime();
			long durationUnsucessfullTime = end1 - start1;
			CunsucessfullTime1+=durationUnsucessfullTime+ "\n";
		}
					
				
				
		//open  function1 success
		String OsucessfullTime1 = "";
		for(int i =0; i<processedWordList.length/2; i++){
			long start = System.nanoTime();
			openhash1.search(processedWordList[i]);
			long end = System.nanoTime();
			long duartionSucessfullTimetion = end - start;
			OsucessfullTime1+= duartionSucessfullTimetion+ "\n";
		}
				
				
					
					
				
		//open  function1 unsuccess
		String OunsucessfullTime1 = "";
		for(int i =processedWordList.length/2; i<processedWordList.length; i++)	{
			long start1 = System.nanoTime();
			openhash1.search(processedWordList[i]);
			long end1 = System.nanoTime();
			long durationUnsucessfullTime = end1 - start1;
			OunsucessfullTime1+= durationUnsucessfullTime+ "\n";
		}
		
		System.out.println("|------ClosedHash Function 2------|\n");
		System.out.println(closedhash1.getTests());
		System.out.println("|-------OpenHash Function 2-------|\n");
		System.out.println(openhash1.getTests());
		System.out.println("|=================================|");
		System.out.println("|=================================|");
		System.out.println("|=================================|");
		System.out.println("|=================================|");
		System.out.println("----Closed Function 1 success ---- ");
		System.out.println(CsucessfullTime);
		System.out.println("-----------------------------------");
		System.out.println("---Closed Function 1 Unsuccess --- ");
		System.out.println(CunsucessfullTime);
		System.out.println("-----------------------------------");
		System.out.println("----Open Function 1 success ---- ");
		System.out.println(OsucessfullTime);
		System.out.println("-----------------------------------");
		System.out.println("---Open Function 1 Unsuccess --- ");
		System.out.println(OunsucessfullTime);
		
		
		
		System.out.println("-----------------------------------");
		System.out.println("----Closed Function 2 success ---- ");
		System.out.println(CsucessfullTime1);
		System.out.println("-----------------------------------");
		System.out.println("---Closed Function 2 Unsuccess --- ");
		System.out.println(CunsucessfullTime1);
		System.out.println("-----------------------------------");
		System.out.println("----Open Function 2 success ---- ");
		System.out.println(OsucessfullTime1);
		System.out.println("-----------------------------------");
		System.out.println("---Open Function 2 Unsuccess --- ");
		System.out.println(OunsucessfullTime1);
		System.out.println("-----------------------------------");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//test 2
//		System.out.println("\n\n\n\n\n\n\n|=================================|");
//		System.out.println("|=============TEST 2==============|");
//		System.out.println("|=================================|");
//		System.out.println("|---File: " +test2File + "-------------|");
//		System.out.println("|---------------------------------|\n");
//		String processedWordList1[] = processText( fileToString(test2File));	
//		
//		ClosedHashing closedhash2 = new ClosedHashing(processedWordList1.length *2, 0);
//		OpenHashing openhash2 = new OpenHashing(processedWordList1.length, 0);
//		
//		
//		
//		for(int i =0; i<processedWordList1.length; i++){	
//			closedhash2.insert(processedWordList1[i]);
//			openhash2.insert(processedWordList1[i]);
//		}
//		
//		System.out.println("|------ClosedHash Function 1------|\n");
//		System.out.println(closedhash.getTests());
//		System.out.println("|-------OpenHash Function 1-------|\n");
//		System.out.println(openhash.getTests());
//		
//		ClosedHashing closedhash3 = new ClosedHashing(processedWordList1.length *2, 1);
//		OpenHashing openhash3 = new OpenHashing(processedWordList1.length, 1);
//		
//		for(int i =0; i<processedWordList.length; i++){	
//			closedhash3.insert(processedWordList1[i]);
//			openhash3.insert(processedWordList1[i]);
//		}
//		System.out.println("|------ClosedHash Function 2------|\n");
//		System.out.println(closedhash2.getTests());
//		System.out.println("|-------OpenHash Function 2-------|\n");
//		System.out.println(openhash2.getTests());
//		System.out.println("|=================================|");
//		
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//		
//		
//
//		
//		
		
		
	}
		
		/*
		
		//final long startTime = System.nanoTime();
		
		
		//final long duration = System.nanoTime() - startTime;
		
		*/
		
	
	
	
	
}
