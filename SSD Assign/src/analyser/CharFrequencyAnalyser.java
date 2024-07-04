package analyser;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * A kind of {@link BaseAnalyser} that counts the number of unique individual
 * character occurrences within the text.
 * 
 * @author mdixon
 */
public class CharFrequencyAnalyser extends BaseAnalyser {

	/**
	 * The collection containing each found character, mapped to the occurrence
	 * count.
	 * 
	 * This is a linked hash map so the order in which the characters are added is
	 * maintained.
	 */
	// TODO:Part4 create the appropriate collection instance
	private Map<Character, Integer> charCounts = new TreeMap<Character, Integer> (); 
	// TODO:Part4 add missing attributes (see UML model).

	//////////////////////////////////////////////////////////////////
	private int vowelCount=0;
	private int singleCharCount=0;
	private int nonvowelCount=0;
	@Override
	public void performAnalysis(String filename) throws IOException {

		// TODO:Part4 clear map contents and re-init other attributes.
		charCounts.clear();
		vowelCount=0;
		singleCharCount=0;
		 nonvowelCount=0;
		selectInputFile(filename); // select the file to be analysed

		String nextWord = readNextWord();

		// process all available words
		while (nextWord != null) {
			
			 
			// extract each character from the next word, and add to the occurrence map
			for (int i = 0; i < nextWord.length(); i++) {
				
				// TODO:Part4 get char at position 'i' from the next word
				char character = nextWord.charAt(i);

				
				// TODO:Part4 Check if present in the map, and increment occurrence count
				if(charCounts.containsKey(character)) {
					charCounts.put(character, charCounts.get(character)+1);
				}
				else {
					charCounts.put(character, 1);
				}
				// TODO:Part4 check if vowel, if so increment correct attribute
				
		         if(character == 'a'|| character == 'e'|| character == 'i' ||character == 'o' ||character == 'u'){
		        	 vowelCount++;
		        	 
		         }
		         else 
		         {
		        	 nonvowelCount++;
		         } 
			}

			// TODO:Part4 if word length is 1, then increment attribute that counts single
			if(nextWord.length()== 1) 
			{
				singleCharCount++;
			}
			// character words.
			nextWord = readNextWord();
		}
	}

	@Override
	public void generateReport(PrintStream out) {

		generateHeader(out);

		out.println("Most popular character is '" + getMostPopularChar() + "' with an occurrence count of "
				+ getMostPopularCharCount());
		out.println("Unique character count is " + getUniqueCharCount());
	}

	/**
	 * Gets the most popular character of the most recent analysis.
	 * 
	 * If multiple characters have the same number of occurrences, then the first of
	 * these recorded should be returned.
	 * 
	 * @return the most popular character of the most recent analysis, this will be
	 *         null an analysis is yet to be performed.
	 */
	public Character getMostPopularChar() {

		// find the most popular character
		Character character = null;

		// TODO:Part4 if highest occurrence count so far, record the character.
		int max =0;
		if(charCounts.isEmpty())
		{
			return null;
		}
		else
		{
		for(Entry<Character,Integer> data : charCounts.entrySet()) //using for each loop
		{
			if(max <= data.getValue()) {
				max = data.getValue();
				character = data.getKey();
			}
		}
		return character;
	}
}

	/**
	 * Gets the number of times the most popular character(s) appeared within the
	 * most recent analysis.
	 * 
	 * @return the number of times the most popular character(s) appeared, 0 if an
	 *         analysis is yet to be performed.
	 */
	public int getMostPopularCharCount() {

		if(charCounts.isEmpty()) 
		{
			return 0;
		}
		else {
	    TreeSet<Integer> words = new TreeSet<>(charCounts.values());
			int lastnum =words.last();
			
			return lastnum;
			
		}
	}
		
		// TODO:Part4 find the most popular character count
	

		// TODO:Part4 if highest occurrence count so far, record the character.
	/**
	 * Gets the number of unique characters within the analysed text.
	 * 
	 * @return the number of unique characters analysed.
	 */
	public int getUniqueCharCount() {

		
		return charCounts.size(); // TODO:Part4 return size of the map
	}

	/**
	 * Gets the total number of characters which are vowels within the analysed
	 * text.
	 * 
	 * @return the total number of characters which are vowels
	 */
	public int getVowelCount() {

		return vowelCount; // TODO:Part4 return appropriate attribute
	}

	/**
	 * Gets the total number of characters which are not vowels within the analysed
	 * text.
	 * 
	 * @return the total number of characters which are not vowels
	 */
	public int getNonVowelCount() {
		// TODO:Part4 calc result and return (hint: can use getResult().getTotalChars() to get total char count).
		return  nonvowelCount;
	}

	/**
	 * Gets the total number of single character words present within the analysed
	 * text.
	 * 
	 * @return the total number of single character words
	 */
	public int getSingleCharacterWordCount() {
			
		return singleCharCount;// TODO:Part4 return appropriate attribute
	}
	/**
	 * Gets the total number of multi-character words present within the analysed
	 * text.
	 * 
	 * @return the total number of multi-character words
	 */
	public int getMultiCharacterWordCount() {
		
		// TODO:Part4 calc result and return (hint: can use getResult().getWordCount() to get total word count).\
		
		return getResult().getWordCount()- singleCharCount ;
	}

	/**
	 * Gets the number of times the given character occurred in the most recent
	 * analysis.
	 * 
	 * @param character the character for which the occurrence count is required.
	 * @return the number of times the given character appeared, 0 if it did not
	 *         ever appear.
	 */
	public int getCountOf(Character character) {
		if(character==null){
			return 0;
		}
		else {
		int num =0;
		if(charCounts.containsKey(character)) {
		num=charCounts.get(character);
		}
		return num ; // TODO:Part4 lookup the character in the map and return the associated count value (if any).
	}
	}
	/**
	 * Constructor
	 */
	public CharFrequencyAnalyser() {

		super("Character Frequency Analyser", "counts the number of unique character occurrences within the text");
	}

}
