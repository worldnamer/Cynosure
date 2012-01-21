package cynosure.arabian.data;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.gson.Gson;

@XmlRootElement(name = "reactionMatrix")
@XmlAccessorType(XmlAccessType.NONE)
public class ReactionMatrix
{
	@XmlElement
	private String title;

	@XmlElement
	private String[] headings;

	@XmlElement
	private String[] adjectives;

	@JsonIgnore
	private String[][] tales;

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setHeadings(String[] headings)
	{
		this.headings = new String[headings.length];
		System.arraycopy(headings, 0, this.headings, 0, headings.length);
	}

	public String[] getHeadings()
	{
		return headings;
	}

	@JsonIgnore
	public void setTales(String[][] tales)
	{
		this.tales = new String[tales.length][];
		for (int i = 0; i < tales.length; i++) {
			this.tales[i] = new String[tales[i].length];
			System.arraycopy(tales[i], 0, this.tales[i], 0, tales[i].length);
		}
	}

	@JsonIgnore
	public String[][] getTales()
	{
		return tales;
	}

	public void setAdjectives(String[] adjectives)
	{
		this.adjectives = new String[adjectives.length];
		System.arraycopy(adjectives, 0, this.adjectives, 0, adjectives.length);
	}

	public String[] getAdjectives()
	{
		return adjectives;
	}

	public String[] getTales(String adjective)
	{
		for (int i = 0; i < adjectives.length; i++) {
			if (adjectives[i].equalsIgnoreCase(adjective)) {
				return tales[i];
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		
		return gson.toJson(this);
	}
}
