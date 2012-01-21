package cynosure.arabian.data;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.google.gson.Gson;

@XmlRootElement(name = "card")
public class EncounterCard
{
	private String title;
	private String type;
	private List<EncounterCardOption> options = new ArrayList<EncounterCardOption>();

	public void setTitle(String title)
	{
		this.title = title;
	}

	@XmlElement
	public String getTitle()
	{
		return title;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@XmlElement
	public String getType()
	{
		return type;
	}

	public void setOptions(List<EncounterCardOption> options)
	{
		this.options = options;
	}

	@XmlElement
	public List<EncounterCardOption> getOptions()
	{
		return options;
	}

	@Override
	public String toString()
	{
		return new Gson().toJson(this);
	}
}
