package document;

/** 
 * A class that represents a text document
 * @author UC San Diego Intermediate Programming MOOC team
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Document {

	private String text;
	
	/** Create a new document from the given text.
	 * Because this class is abstract, this is used only from subclasses.
	 * @param text The text of the document.
	 */
	protected Document(String text)
	{
		this.text = text;
	}
	
	/** Returns the tokens that match the regex pattern from the document 
	 * text string.
	 * @param pattern A regular expression string specifying the 
	 *   token pattern desired
	 * @return A List of tokens from the document text that match the regex 
	 *   pattern
	 */
	protected List<String> getTokens(String pattern)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	/** This is a helper function that returns the number of syllables
	 * in a word.  You should write this and use it in your 
	 * BasicDocument class.
	 * 
	 * You will probably NOT need to add a countWords or a countSentences 
	 * method here.  The reason we put countSyllables here because we'll 
	 * use it again next week when we implement the EfficientDocument class.
	 * 
	 * For reasons of efficiency you should not create Matcher or Pattern 
	 * objects inside this method. Just use a loop to loop through the 
	 * characters in the string and write your own logic for counting 
	 * syllables.
	 * 
	 * @param word  The word to count the syllables in
	 * @return The number of syllables in the given word, according to 
	 * this rule: Each contiguous sequence of one or more vowels is a syllable, 
	 *       with the following exception: a lone "e" at the end of a word 
	 *       is not considered a syllable unless the word has no other syllables. 
	 *       You should consider y a vowel.
	 */
	protected int countSyllables(String word)
	{
		// TODO: Implement this method so that you can call it from the 
	    // getNumSyllables method in BasicDocument (module 2) and 
	    // EfficientDocument (module 3).
		int t=0,len=word.length();
		/*ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile("[aeiouyAEIOU]+");
		Matcher m = tokSplitter.matcher(word);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		//for(String i: tokens)
			//System.out.println(i);
		t=tokens.size();
		//System.out.println("before last e " + t );
		if(word.charAt(word.length()-1)=='e'&&t>1&&word.charAt(word.length()-2)!='e'&&word.charAt(word.length()-2)!='a') {
			if(word.charAt(word.length()-2)!='i'&&word.charAt(word.length()-2)!='o'&&word.charAt(word.length()-2)!='u')
			t=t-1;
		}
		if(word.charAt(0)== 'y') {
			t -= 1;
		}*/
		//System.out.println("after last e " + t );
		//loop method
		if(word.charAt(0)=='A'||word.charAt(0)=='E'||word.charAt(0)=='I'||word.charAt(0)=='O'||word.charAt(0)=='U'||word.charAt(0)=='Y') {
			t++;
			//System.out.println(word.charAt(0));
		}
		if(word.charAt(0)=='a'||word.charAt(0)=='e'||word.charAt(0)=='i'||word.charAt(0)=='o'||word.charAt(0)=='u'||word.charAt(0)=='y') {
			t++;
			//System.out.println(word.charAt(0));
		}
		if(word.charAt(len-1)=='e') {
			len = len - 1;
		}
		for(int i=1;i<len;i++) {
			if(word.charAt(i)=='A'||word.charAt(i)=='E'||word.charAt(i)=='I'||word.charAt(i)=='O'||word.charAt(i)=='U'||word.charAt(i)=='Y') {
				if(word.charAt(i-1)=='a'||word.charAt(i-1)=='e'||word.charAt(i-1)=='i'||word.charAt(i-1)=='o'||word.charAt(i-1)=='u'||word.charAt(i-1)=='y');
				else if(word.charAt(i-1)=='A'||word.charAt(i-1)=='E'||word.charAt(i-1)=='I'||word.charAt(i-1)=='O'||word.charAt(i-1)=='U'||word.charAt(i-1)=='Y');
				else{
					t++;
					//System.out.println(word.charAt(i));
				}
			}
			if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u'||word.charAt(i)=='y') {
				if(word.charAt(i-1)=='a'||word.charAt(i-1)=='e'||word.charAt(i-1)=='i'||word.charAt(i-1)=='o'||word.charAt(i-1)=='u'||word.charAt(i-1)=='y');
				else if(word.charAt(i-1)=='A'||word.charAt(i-1)=='E'||word.charAt(i-1)=='I'||word.charAt(i-1)=='O'||word.charAt(i-1)=='U'||word.charAt(i-1)=='Y');
				else{
					t++;
					//System.out.println(word.charAt(i));
				}
			}
		}
		//System.out.println(t);
		if(word.charAt(word.length()-1)=='e'&&t==0) {
			t++;
		}
	    return t;
	}
	
	/** A method for testing
	 * 
	 * @param doc The Document object to test
	 * @param syllables The expected number of syllables
	 * @param words The expected number of words
	 * @param sentences The expected number of sentences
	 * @return true if the test case passed.  False otherwise.
	 */
	public static boolean testCase(Document doc, int syllables, int words, int sentences)
	{
		System.out.println("Testing text: ");
		System.out.print(doc.getText() + "\n....");
		boolean passed = true;
		int syllFound = doc.getNumSyllables();
		int wordsFound = doc.getNumWords();
		int sentFound = doc.getNumSentences();
		if (syllFound != syllables) {
			System.out.println("\nIncorrect number of syllables.  Found " + syllFound 
					+ ", expected " + syllables);
			passed = false;
		}
		if (wordsFound != words) {
			System.out.println("\nIncorrect number of words.  Found " + wordsFound 
					+ ", expected " + words);
			passed = false;
		}
		if (sentFound != sentences) {
			System.out.println("\nIncorrect number of sentences.  Found " + sentFound 
					+ ", expected " + sentences);
			passed = false;
		}
		
		if (passed) {
			System.out.println("passed.\n");
		}
		else {
			System.out.println("FAILED.\n");
		}
		return passed;
	}
	
	
	/** Return the number of words in this document */
	public abstract int getNumWords();
	
	/** Return the number of sentences in this document */
	public abstract int getNumSentences();
	
	/** Return the number of syllables in this document */
	public abstract int getNumSyllables();
	
	/** Return the entire text of this document */
	public String getText()
	{
		return this.text;
	}
	
	/** return the Flesch readability score of this document */
	public double getFleschScore()
	{
	    // TODO: You will play with this method in week 1, and 
		// then implement it in week 2
		double t = (double)getNumWords()/getNumSentences();
		double t2= (double)getNumSyllables()/getNumWords();
		//System.out.println("t=" + t + " t2=" + t2);
	    return 206.835 -(1.015*t) - (84.6*t2);
	}
	
	
	
}
