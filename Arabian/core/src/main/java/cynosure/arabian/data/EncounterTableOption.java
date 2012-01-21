package cynosure.arabian.data;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "tableOption")
public class EncounterTableOption
{
	private String adjective;
	private String description;
	private String reactionMatrix;

	public void setAdjective(String adjective)
	{
		this.adjective = adjective;
	}

	@XmlElement
	public String getAdjective()
	{
		return adjective;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@XmlElement
	public String getDescription()
	{
		return description;
	}

	public void setReactionMatrix(String reactionMatrix)
	{
		this.reactionMatrix = reactionMatrix;
	}

	@XmlElement
	public String getReactionMatrix()
	{
		return reactionMatrix;
	}
}
