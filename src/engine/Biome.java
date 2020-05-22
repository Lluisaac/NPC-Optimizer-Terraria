package engine;

import java.util.ArrayList;
import java.util.List;

public class Biome
{
	public static final int BIOME_SIZE = 4;

	private String name;
	
	double pylonMult;
	double villageMult;
	
	double malus;

	private NPC[][] grid;

	public Biome(String name, double pylonMult, double villageMult, double malus)
	{
		this.name = name;
		
		this.pylonMult = pylonMult;
		this.villageMult = villageMult;
		this.malus = malus;

		this.grid = new NPC[BIOME_SIZE][BIOME_SIZE];
	}

	public Biome(Biome other)
	{
		this(other.name, other.pylonMult, other.villageMult, other.malus);

		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{
				this.grid[i][j] = other.grid[i][j];
			}
		}
	}

	public NPC switchNPC(NPC npc, Coord coord)
	{
		NPC temp = getNPC(coord);

		this.putNPC(npc, coord);

		return temp;
	}

	private void putNPC(NPC npc, Coord coord)
	{
		this.grid[coord.x][coord.y] = npc;
	}

	public double getTotalValue()
	{
		double sum = 0.0;
		
		boolean canHavePylon = false;

		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{
				if (this.grid[i][j] != null)
				{
					
					if (this.grid[i][j].getMultiplicator(this) <= 0.85) {
						canHavePylon = true;
					}
					
					sum += this.grid[i][j].getValue(this);
				}
			}
		}
		
		int nb = this.getNumberOfNPC();
		
		if (nb >= 2 && canHavePylon) {
			sum *= this.pylonMult;
		}
		
		if (nb >= 3) {
			sum *= this.villageMult;
		}
		
		if (nb < 3) {
			sum += this.malus;
		}

		return sum;
	}

	public int getNumberOfNPC()
	{
		int sum = 0;

		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{
				if (this.grid[i][j] != null)
				{
					sum++;
				}
			}
		}

		return sum;
	}

	public int getNumberOfAdjacentNPC(NPC npc)
	{
		return this.getNumberOfAdjacentNPC(this.getCoord(npc));
	}

	public int getNumberOfAdjacentNPC(Coord coord)
	{
		return this.getAdjacentNPC(coord).size();
	}

	public List<NPC> getAdjacentNPC(NPC npc)
	{
		return getAdjacentNPC(this.getCoord(npc));
	}

	public List<NPC> getAdjacentNPC(Coord coord)
	{
		List<NPC> npcs = new ArrayList<NPC>();

		npcs.add(getSecureNPC(coord.plus(new Coord(-1, 0))));

		npcs.add(getSecureNPC(coord.plus(new Coord(0, -1))));

		npcs.add(getSecureNPC(coord.plus(new Coord(0, 1))));

		npcs.add(getSecureNPC(coord.plus(new Coord(1, 0))));
		
		npcs.removeIf(npc -> npc == null);

		return npcs;
	}

	private NPC getSecureNPC(Coord w)
	{
		if (!w.isOutOfBounds() && this.getNPC(w) != null)
		{
			return this.getNPC(w);
		}
		else
		{
			return null;
		}
	}

	public NPC getNPC(Coord coord)
	{
		return this.grid[coord.x][coord.y];
	}

	public Coord getCoord(NPC npc)
	{
		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{
				if (this.grid[i][j] == npc)
				{
					return new Coord(i, j);
				}
			}
		}

		return null;
	}

	public boolean contains(NPC npc)
	{
		if (this.getCoord(npc) != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clear() {
		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{
				this.grid[i][j] = null;
			}
		}
	}

	private boolean hasPylon()
	{
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[i].length; j++)
			{
				if (this.grid[i][j] != null && this.grid[i][j].getMultiplicator(this) <= 0.85 && this.grid[i][j].getValueMult() != 0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String str = name + ", biome score: " + this.getTotalValue();
		
		int nb = this.getNumberOfNPC();
		
		if (nb >= 3) {
			str += ", is a village";
		}
		
		if (this.hasPylon() && nb >= 2) {
			str += ", has a Pylon";
		}
		
		str += "\n---------------------------------\n";
		
		for (int i = 0; i < this.grid.length; i++)
		{
			for (int j = 0; j < this.grid[i].length; j++)
			{
				if (this.grid[i][j] != null) {
					str += grid[i][j];
				}
				str += "\t|";
			}
											   
			str += "\n---------------------------------\n";
		}

		return str;
	}
}
