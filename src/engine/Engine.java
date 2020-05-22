package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Engine
{
	List<NPC> npcs;
	List<Biome> biomes;

	double value;
	int counter;

	public Engine(List<NPC> npcs, List<Biome> biomes)
	{
		this.npcs = npcs;
		this.biomes = biomes;
		this.value = 0;
	}

	public void launch()
	{
		presetRandomly();

		this.counter = 0;

		double actual = Double.MAX_VALUE;
		double previous = Double.MAX_VALUE;

		do
		{
			previous = actual;
			actual = findBestSolution();
			counter++;
		} while (previous != actual);

		this.value = actual;
	}

	private void presetRandomly()
	{
		Random rand = new Random();

		List<NPC> buffer = new ArrayList<NPC>(this.npcs);

		this.biomeClear();

		while (!buffer.isEmpty())
		{
			NPC actual = buffer.remove(0);

			while (actual != null)
			{
				Biome chosen = null;

				if (actual.getBiome(Preference.LIKED) != null)
				{
					chosen = actual.getBiome(Preference.LIKED);
				}
				else
				{
					chosen = this.biomes.get(rand.nextInt(this.biomes.size()));
				}

				Coord pos = new Coord(0, 0).doNext(rand.nextInt(Biome.BIOME_SIZE * Biome.BIOME_SIZE));

				actual = chosen.switchNPC(actual, pos);
			}
		}
	}

	private void biomeClear()
	{
		for (Biome biome : biomes)
		{
			biome.clear();
		}
	}

	private double findBestSolution()
	{
		Biome bestBiomeInital = null;
		Coord bestCoordInitial = null;
		Biome bestBiomeFinal = null;
		Coord bestCoordFinal = null;

		boolean betterFound = false;

		double bestValue = this.getTotalValue();

		for (NPC npc : this.npcs)
		{
			Biome actualBiomeInital = this.getBiomeOf(npc);
			Coord actualCoordInital = this.getCoordOf(npc);

			for (Biome actualBiomeFinal : this.biomes)
			{
				Coord actualCoordFinal = new Coord(0, 0);
				for (int i = 0; i < Biome.BIOME_SIZE * Biome.BIOME_SIZE; i++)
				{
					this.switchSpots(actualBiomeInital, actualCoordInital, actualBiomeFinal, actualCoordFinal);

					double value = this.getTotalValue();

					if (bestValue > value)
					{
						bestBiomeInital = actualBiomeInital;
						bestCoordInitial = actualCoordInital;
						bestBiomeFinal = actualBiomeFinal;
						bestCoordFinal = actualCoordFinal;

						betterFound = true;

						bestValue = value;
						
					}

					this.switchSpots(actualBiomeInital, actualCoordInital, actualBiomeFinal, actualCoordFinal);

					actualCoordFinal = actualCoordFinal.next();
				}
			}
		}

		if (betterFound)
		{
			this.switchSpots(bestBiomeInital, bestCoordInitial, bestBiomeFinal, bestCoordFinal);
		}

		return bestValue;
	}

	private double getTotalValue()
	{
		double sum = 0.0;

		for (Biome biome : biomes)
		{
			sum += biome.getTotalValue();
		}

		return sum;
	}

	private Coord getCoordOf(NPC npc)
	{
		return this.getBiomeOf(npc).getCoord(npc);
	}

	private Biome getBiomeOf(NPC npc)
	{
		for (Biome biome : biomes)
		{
			if (biome.contains(npc))
			{
				return biome;
			}
		}

		return null;
	}

	private void switchSpots(Biome b1, Coord c1, Biome b2, Coord c2)
	{
		NPC temp = b2.switchNPC(b1.getNPC(c1), c2);
		b1.switchNPC(temp, c1);
	}

	public double getValue()
	{
		return this.value;
	}

	@Override
	public String toString()
	{
		String str = "Final value: " + this.value + ", Iterations: " + this.counter + "\n";

		for (Biome biome : this.biomes)
		{
			str += biome + "\n";
		}
		
		for (NPC npc : npcs)
		{
			str += npc.toString() + ": " + npc.getMultiplicator(this.getBiomeOf(npc)) + "\n";
		}

		return str;
	}
}
