package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		if(sourceText.equals("")) {
			if(wordList.size()==0)
			starter = "";
			wordList.add(new ListNode(""));
		}
		else {
		int t=0;
		String[] words= sourceText.split(" +");
		starter=words[0];
		wordList.add(new ListNode(starter));
		//System.out.println(1+ wordList.get(0).getWord());
		for(int i=1;i<words.length;i++) {
			String c = words[i];
			t=0;
			for(int j=0;j<wordList.size();j++) {
				if(wordList.get(j).getWord().equals(words[i-1])) {
					wordList.get(j).addNextWord(c);
				}
				if(wordList.get(j).getWord().equals(c)) {
					t=1;
				}
			}
			if(t==0) {
				wordList.add(new ListNode(c));
			}
		}
		}
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		if(wordList.size()==0) {
			return"";
		}
		else if(numWords>0) {
		int i=0,t=1;
		String[] words = new String[numWords];
			if(wordList.size()==1&&starter.equals("")) {
				return "";
			}
		words[0]=starter;
		starter+= " ";
		while(numWords>1) {
			words[t]=wordList.get(i).getRandomNextWord(rnGenerator);
			if(words[t]==null) {
				words[t]=words[0];
			}
			starter+=words[t]+ " ";
			for(int j=0;j<wordList.size();j++) {
				if(wordList.get(j).getWord().equals(words[t])) {
					i=j;
					break;
				}
			}
			t++;numWords--;
		}
		//System.out.println(starter.length()+ "After generate text");
		return starter;
		}
		else if(numWords==0) {
			return "";
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Error Thrown");
	}
		}
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		wordList.removeAll(wordList);
	//	System.out.println(wordList.size());
		train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random());
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.train(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		if(nextWords.size()>0) {
		int i=generator.nextInt(nextWords.size());
		//System.out.println(i);
	    return nextWords.get(i);
	    }
		else
			return null;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


