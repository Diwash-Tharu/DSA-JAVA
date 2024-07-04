package analyser;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A kind of {@link BaseAnalyser} that counts the number of unique word
 * occurrences within the text.
 * 
 * @author mdixon
 */
public class WordFrequencyAnalyser extends BaseAnalyser  {

	/**
	 * The collection containing each found word, mapped to the occurrence count.
	 * 
	 * This is a linked hash map so the order in which the words are added is maintained.
	 */
	private LinkedHashMap<String, Integer> wordCounts = new LinkedHashMap<String, Integer>() ;	
	// TODO:Part3 create the appropriate collection instance

	//////////////////////////////////////////////////////////////////

	@Override
	public void performAnalysis(String filename) throws IOException {

		// TODO:Part3 clear the word count
		wordCounts.clear();

		selectInputFile(filename);	// select the file to be analysed

		String nextWord = readNextWord();
		while (nextWord != null) {
			// TODO:Part3 check if word known, if so increment the occurrence count, otherwise add with a count of 1
			if(wordCounts.containsKey(nextWord))
			{
				wordCounts.put(nextWord, wordCounts.get(nextWord)+1);
			}	     
			else 
			{	
			
				wordCounts.put(nextWord,1);
			}
			nextWord = readNextWord();	// TODO:Part3 read next word
				
			}
		//System.out.println(wordCounts);
	}

	@Override
	public void generateReport(PrintStream out) {
		
		generateHeader(out);
	
		out.println("Most popular word is '" + getMostPopularWord() + "' with an occurrence count of "  +getMostPopularWordCount());
		out.println("Least popular word is '" + getLeastPopularWord() + "'  with an occurrence count of "  +getLeastPopularWordCount());
		out.println("Unique word count is " + getUniqueWordCount());
	}
	
	/**
	 * Gets the most popular word of the most recent analysis.
	 * 
	 * If multiple words have the same number of occurrences, then the first of these recorded should be returned.
	 * 
	 * @return the most popular word of the most recent analysis, this will be an
	 *         empty string if an analysis is yet to be performed.
	 */
	public String getMostPopularWord() {
		int max = 0;
		String word = "";
		
		// iterate over each entry within the map
		for (Entry<String, Integer> entry : wordCounts.entrySet()) //using for each loop
		{
			// TODO:Part3 if entry value (count) is higher than max, then record the key (word) as most popular word so far
			if(max < entry.getValue()) {
				max = entry.getValue();
				word = entry.getKey();
			}
		
		}
		return word;
	}

	/**
	 * Gets the number of times the most popular word(s) appeared within the most recent analysis.
	 * 
	 * @return the number of times the most popular word(s) appeared, 0 if an analysis is yet to be performed.
	 */
	public int getMostPopularWordCount() {
		// TODO:Part3 find the most popular word count and return
		TreeSet<Integer> words = new TreeSet<>(wordCounts.values());// converting values of Hashmap to treeset
		if(words.isEmpty())
		{
			return 0;
		} 
		else
		{
			int last =words.last();
			return last;
		}

	}
	
	/**
	 * Gets the least popular word of the most recent analysis.
	 * 
	 * If multiple words have the same least number of occurrences, then the first of these recorded should be returned.
	 * 
	 * @return the least popular word of the most recent analysis, this will be an
	 *         empty string if an analysis is yet to be performed.
	 */
	public String getLeastPopularWord() {

		// find the least popular word
		int min = Integer.MAX_VALUE;
		String word = "";
		
		// TODO:Part3 find the least popular word and return
		for (Entry<String, Integer> entry : wordCounts.entrySet()) //using for each loop
		{
			if(min > entry.getValue()) {
				min = entry.getValue();
				word = entry.getKey();
			}
		}
		return word;	
		}
	
	/**
	 * Gets the number of times the least popular word(s) appeared within the most recent analysis
	 * 
	 * @return the number of times the most least word(s) appeared, 0 if an analysis is yet to be performed.
	 */
	public int getLeastPopularWordCount() {

		// find the least popular word
       TreeSet<Integer> words = new TreeSet<>(wordCounts.values());		// converting values of Hashmap to treeset
		if(words.isEmpty())
		{
			return 0;
		} 
		else
		{
			int first =words.first();
			return first;
			
		}
	}
	
	/**
	 * Gets the number of unique words within the analysed text.
	 * 
	 * @return the number of unique words analysed.
	 */
	public int getUniqueWordCount() {
		// TODO:Part3 return number of entries within the word count map
		
		return wordCounts.size();				
	}
	
	/**
	 * Gets the number of times the given word occurred in the most recent analysis.
	 * 
	 * @param word the word for which the occurrence count is required.
	 * @return the number of times the given word appeared, 0 if it did not ever appear.
	 */
	public int getCountOf(String word) {
		
		// TODO:Part3 lookup the word within the word count map, and return its value (count) if it exists
		
		int Number = 0;
		if(wordCounts.containsKey(word))
		{
			Number = wordCounts.get(word);
		}
		return Number;
		
	}
	

	/**
	 * Constructor
	 */
	public WordFrequencyAnalyser() {

		super("Word Frequency Analyser", "counts the number of unique word occurrences within the text");
	}

}
