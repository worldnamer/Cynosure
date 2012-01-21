package cynosure.arabian.data;

import javax.xml.bind.annotation.*;

import com.google.gson.Gson;

@XmlRootElement(name = "table")
public class EncounterTable
{
	private String title;
	private EncounterTableOption[] entries = new EncounterTableOption[12];

	public void setTitle(String tatle)
	{
		this.title = tatle;
	}

	@XmlElement
	public String getTitle()
	{
		return title;
	}

	public void setEntries(EncounterTableOption[] entries) 
	{
		System.arraycopy(entries, 0, this.entries, 0, 12);
	}

	@XmlElement
	public EncounterTableOption[] getEntries()
	{
		return entries;
	}

	@Override
	public String toString()
	{
		return new Gson().toJson(this);
	}
}
