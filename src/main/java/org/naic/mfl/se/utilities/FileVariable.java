package org.naic.mfl.se.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class FileVariable {

	private static String readFileToString(String sourceFile) {
		String fileContents = "";
		String line;

		try {
			File extVarFile = new File(sourceFile);
			isFileReadable(sourceFile);

			FileReader fileReader = new FileReader(extVarFile);
			BufferedReader bufferReader = new BufferedReader(fileReader);

			while ((line = bufferReader.readLine()) != null) {
				fileContents = fileContents + line;
				fileContents = fileContents + System.getProperty("line.separator");

			}
			bufferReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContents;
	}
	
	private static void isFileReadable(String sourceFile) {
		File file = new File(sourceFile);
		for(int i=0; i <3; i++) {
			if(!Files.isReadable(file.toPath())) {
				System.out.println("File is currently unreadable");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else break;
		}
		
	}
	
	private static String getSectionString (String sourceFile, String secHeader) {
		String fileContents = "";
		String [] fileRows = null;
		String foundSections = "";
		String [] lineParts = null;
		
		fileContents = readFileToString(sourceFile);
		//fileRows = fileContents.split("\\n?\\r");
		fileRows = fileContents.split("\\n");
		
		for(String line : fileRows) {
			if (StringUtils.containsIgnoreCase(line, secHeader));{
				lineParts = line.split("@",2);
				foundSections += lineParts[1];	
			}
			
		}
		return foundSections;
		
	}
	
	
	public static HashMap<String, String> getVariables(String sourceFile, String secHeader, String variation){
		
		String foundSection= "";
		String rowNumber = "Variation ~ "+ variation;
		String[] sectionRows = null;
		String[] linePair = null;
		String[] varPair = null;
		String key = "";
		String value = "";
		
		HashMap<String, String> varMap = new HashMap<String, String>();
		foundSection = getSectionString(sourceFile, secHeader);
		sectionRows = foundSection.split(Pattern.quote("<endOfLine>"));
			
		for( String row : sectionRows) {
			boolean rowFound = row.contains(rowNumber);
			if(rowFound) {
				linePair = row.split(Pattern.quote(" | "));
				for(String varSet : linePair) {
					varPair = varSet.split(Pattern.quote(" ~ "));
					key = varPair[0].trim();
					value = varPair[1].trim();
					varMap.put(key, value);
				}
			}
		}
		return varMap;
	}
	
	
}
