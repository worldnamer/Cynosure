package cynosure.prolixity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Document
{
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(cascade=CascadeType.PERSIST)
	private List<WordCount> words = new ArrayList<WordCount>();
	
	public Long getId()
	{
		return id;
	}
	
	public List<WordCount> getWords()
	{
		return Collections.unmodifiableList(words);
	}

	public void addWord(WordCount wcToAdd)
	{
		boolean foundWord = false;
		Iterator<WordCount> iterator = words.iterator();
		while (iterator.hasNext() && !foundWord) {
			WordCount wc = iterator.next();
			if (wc.getWord().equals(wcToAdd.getWord())) {
				wc.setCount(wc.getCount() + wcToAdd.getCount());
				foundWord = true;
			}
		}
		if (!foundWord) {
			words.add(wcToAdd);
		}
	}
}
