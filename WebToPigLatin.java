import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class WebToPigLatin {

	public static void main(String[] args)throws IOException{
		
		if(args.length != 2) {
			System.out.println("Usage: java WebToPigLatin inputFile outputFile");
			System.out.println("Must have two command-line parameters");
			System.exit(0);
		}
		
		
		
		
		
		FileReader testInput = new FileReader(args[0]);
		FileWriter testOutput = new FileWriter(args[1]);
		
		char currentChar;
		char firstLetter = 'a';
		boolean insideTags = false;
		boolean insideAnd = false;
		boolean isFirst = true;
		boolean lastCons = false;
		boolean hasVowel = false;
		String ending = "";
		
		
		int i= 0;
		while((i = testInput.read()) != -1) {
			currentChar = (char) i;
			
			if(!Character.isLetter(currentChar) && isFirst == false) {
				
				if(firstLetter == 'A' || firstLetter == 'a' || firstLetter == 'E' || firstLetter == 'e' || firstLetter == 'I' || firstLetter == 'i' || firstLetter == 'O' || firstLetter == 'o' || firstLetter == 'U' || firstLetter == 'u') {
					testOutput.write("way");
				}
				else if(!hasVowel) {
					testOutput.write(ending);	
					ending = "";
					isFirst = false;
				}
				else {
					testOutput.write(ending.toLowerCase());
					testOutput.write("ay");
					ending = "";
				}
				
				
				}
						
			
			if(currentChar == '<') {
				insideTags = true;
			}
			
			
			if(currentChar == '>') {
				testOutput.write(currentChar);
				insideTags = false;
				isFirst = true;
				hasVowel = false;
				
				continue;
			}
			
			if(insideTags == true) {
				testOutput.write(currentChar);
				isFirst = true;
				hasVowel = false;
				
				continue;
			}
			else {
				if(currentChar == '&') {
					insideAnd = true;
				}
				if(currentChar == ';') {
					testOutput.write(currentChar);
					insideAnd = false;
					isFirst = true;
					
					continue;
				}
				
				if(insideAnd == true) {
					testOutput.write(currentChar);
					isFirst = true;
					hasVowel = false;
					
					continue;
				}
				else {
					
					if(Character.isLetter(currentChar) && isFirst == true) {
						
						firstLetter = currentChar;
						if(firstLetter == 'A' || firstLetter == 'a' || firstLetter == 'E' || firstLetter == 'e' || firstLetter == 'I' || firstLetter == 'i' || firstLetter == 'O' || firstLetter == 'o' || firstLetter == 'U' || firstLetter == 'u') {
							testOutput.write(firstLetter);
							
							hasVowel = true;
							
						}
						else {
							lastCons = true;
							isFirst = false;
							
							ending += firstLetter;
							continue;
						}
						
						isFirst = false;
					}
					else if(lastCons == true && Character.isLetter(currentChar) && currentChar != 'A' && currentChar != 'a' && currentChar != 'E' && currentChar != 'e' && currentChar != 'I' && currentChar != 'i' && currentChar != 'O' && currentChar != 'o' && currentChar != 'U' && currentChar != 'u' && currentChar != 'Y' && currentChar != 'y') {
						
						ending += currentChar;
						continue;
					}
					else {
						if(lastCons == true && Character.isUpperCase(firstLetter)) {
							testOutput.write(Character.toUpperCase(currentChar));
							lastCons = false;
							hasVowel = true;
							continue;
						}
						lastCons = false;
						
						
						testOutput.write(currentChar);
						
						if(!Character.isLetter(currentChar)) {
							hasVowel = false;
							
						}
						if(currentChar == 'A' || currentChar == 'a' || currentChar == 'E' || currentChar == 'e' || currentChar == 'I' || currentChar == 'i' || currentChar == 'O' || currentChar == 'o' || currentChar == 'U' || currentChar == 'u' || currentChar == 'Y' || currentChar == 'y') {
							hasVowel = true;
						}
					}
					
					
				}
				
				
				
				
			}
			
			if(!Character.isLetter(currentChar) || insideTags || insideAnd) {
				isFirst = true;
			}
			
			
			
		}
		testInput.close();
		testOutput.close();
			
		
			
			
			
			
			
			
			
			
			
		
		}
				
		

	}


