package engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPC
{
	public static final double MULT_OVERPOP = 1.04;
	public static final double MULT_UNDERPOP = 0.9;

	private String name;
	private double valueMult;

	private Map<Biome, Preference> biomePref;
	private Map<NPC, Preference> neighbourPref;

	public NPC(String name, double valueMult)
	{
		this.name = name;
		this.valueMult = valueMult;

		this.biomePref = new HashMap<Biome, Preference>();
		this.neighbourPref = new HashMap<NPC, Preference>();
	}

	public void setPreferedBiome(Biome biome, Preference pref)
	{
		this.biomePref.put(biome, pref);
	}

	public void setPreferredNeighbour(NPC neigh, Preference pref)
	{
		this.neighbourPref.put(neigh, pref);
	}

	public double getValue(Biome biome)
	{
		return this.getMultiplicator(biome) * this.valueMult;
	}

	public double getMultiplicator(Biome biome)
	{

		return getProximityMultiplicator(biome) * getBiomeMultiplicator(biome) * getNeighbourMultiplicator(biome);
	}

	private double getProximityMultiplicator(Biome biome)
	{
		double mult = 1.0;

		if (biome.getNumberOfAdjacentNPC(this) > 2)
		{
			mult *= MULT_OVERPOP;
		}

		if (biome.getNumberOfAdjacentNPC(this) < 2 && biome.getNumberOfNPC() < 4)
		{
			mult *= MULT_UNDERPOP;
		}

		return mult;
	}

	private double getBiomeMultiplicator(Biome biome)
	{
		if (this.biomePref.containsKey(biome))
		{
			return this.biomePref.get(biome).multiplicator;
		}
		else
		{
			return 1.0;
		}
	}

	private double getNeighbourMultiplicator(Biome biome)
	{
		double mult = 1.0;

		List<NPC> neighbours = biome.getAdjacentNPC(this);

		for (NPC npc : neighbours)
		{
			if (this.neighbourPref.containsKey(npc))
			{
				mult *= this.neighbourPref.get(npc).multiplicator;
			}
		}

		return mult;
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	public Biome getBiome(Preference liked)
	{
		for (Map.Entry<Biome, Preference> entry : this.biomePref.entrySet())
		{
			if (entry.getValue().equals(liked))
			{
				return entry.getKey();
			}
		}

		return null;
	}

	public double getValueMult()
	{
		return this.valueMult;
	}
}
