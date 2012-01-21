package cynosure.prolixity;

import javax.persistence.*;

@Entity
public class WordCount
{
	@Id
	@GeneratedValue
	private Long id;
	private String word;
	@Column(name="occurances")
	private int count;
	
	public WordCount(String word, int count)
	{
		this.word = word;
		this.count = count;
	}

	public WordCount()
	{
	}

	public Long getId()
	{
		return id;
	}

	public int getCount()
	{
		return count;
	}

	public void setWord(String word)
	{
		this.word = word;
	}

	public String getWord()
	{
		return word;
	}

	public void setCount(int count)
	{
		this.count = count;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof WordCount) {
			WordCount wc = (WordCount)o;
			
			if (
				(
				 (wc.word == null && word == null) ||
				 (
				  (wc.word != null && word != null) &&
				  (wc.word.equals(word))
				 )
			    ) &&
			    (wc.count == count)
			   )
			    {
				return true;
			}
		}
		
		return false;
	}
}
