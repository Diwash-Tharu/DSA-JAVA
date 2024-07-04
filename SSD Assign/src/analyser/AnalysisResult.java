package analyser;

/**
 * Stores result information related to the analysis of text.
 * 
 * @author mdixon
 */
public class AnalysisResult {

	// TODO::Part1 add missing attributes (use UML model to identify these)

	////////////////////////////////////////////////////////////
	
	private int totalChars=0;
	private int wordCount =0;
	private String longestWord = "";
	private String shortestWord = "";
	private String lastWord="";
	private int resetCount = 0;
	
	/**
	 * Records a word, using the information given to calculate analysis results.
	 * 
	 * Any whitespace is trimmed from either side of the word prior to it being
	 * recorded.
	 * 
	 * @param word the word to be recorded (null or empty words are ignored).
	 */
	
	@SuppressWarnings("null")
	public void recordWord(String word) {

		
		// TODO:Part1 ensure word is not null or empty
		if(word == null || word.isEmpty())
		{
			return;
		}
		else {
		// TODO:Part1 remove any whitespace
			
		word = word.trim();
		// TODO:Part1 store the word in the last word attribute
		
		 lastWord =word;
		// TODO:Part1 increment the word count attribute
		 
		 wordCount++;
		// TODO:Part1 check if word is the longest so far, if so record in appropriate attribute
	    
		 if(longestWord.length()<word.length()){
	    	  
	    	  longestWord= word;
	      }  
		// TODO:Part1 check if word is the shortest so far, if so record in appropriate attribute
		 
		 if(wordCount==1) {
			 shortestWord= word;
		 } 
	      if(shortestWord.length()>word.length()){
	    	 
	    	  shortestWord= word;
	      }
		// TODO:Part1 add length of word to the total character count attribute
	      
	      totalChars += word.length();
		}       
	}
     
	/**
	 * @return total number of characters recorded.
	 */
	public int getTotalChars() {

		return totalChars; 			// TODO:Part1 return correct attribute
	}

	/**
	 * @return total number of words recorded.
	 */
	public int getWordCount() {

		return wordCount; 			// TODO:Part1 return correct attribute
	}

	/**
	 * @return the number of times {@link #reset()} has been called.
	 */
	public int getResetCount() {

		return resetCount; 			// TODO:Part1 return correct attribute
	}

	/**
	 * Gets the longest word recorded.
	 * 
	 * note: If multiple longest recorded words contain the same number of
	 * characters, then the first one recorded is returned.
	 * 
	 * @return the longest recorded word
	 */
	public String getLongestWord() {
		
		return longestWord; 			// TODO:Part1 return correct attribute
	}

	/**
	 * Gets the shortest word recorded.
	 * 
	 * note: If multiple shortest recorded words contain the same number of
	 * characters, then the first one recorded is returned.
	 * 
	 * @return the shortest recorded word
	 */
	public String getShortestWord() {

		return shortestWord;         // TODO:Part1 return correct attribute
	}

	/**
	 * Gets the most recently recorded word.
	 * 
	 * @return the most recently recorded word.
	 */
	public String getLastWord() {

		return lastWord;            // TODO:Part1 return correct attribute
	}

	/**
	 * Calculates and returns the average length of all recorded words.
	 * 
	 * @return the average length of all recorded words. This will be 0.0 if no
	 *         words have been recorded.
	 */
	public double getAveWordLength() {
		// TODO:Part1 calculate average and return
		
		if(wordCount == 0) 
		{
			return 0.0;
		}
		else 
		{
		double lengths;
		lengths= (double)totalChars/(double)wordCount;
		return lengths ;
		}
	}

	/**
	 * Resets the analysis results back to the initial state, and increments the
	 * reset count as returned by {@link #getResetCount()}.
	 */
	public void reset() {
		// TODO:Part1 reset appropriate attributes, and increment the reset count
		
		 totalChars=0;
		 wordCount =0;
		 longestWord = "";
		 shortestWord = "";
		 lastWord="";
		 resetCount++;               //increasing the attribute of resetcount;
		
	    }

}
