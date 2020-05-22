package engine;

public class Coord
{
	public int x;
	public int y;

	public Coord(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Coord(Coord other)
	{
		this.x = other.x;
		this.y = other.y;
	}

	public boolean isOutOfBounds()
	{
		return x < 0 || x >= Biome.BIOME_SIZE || y < 0 || y >= Biome.BIOME_SIZE;
	}

	public Coord plus(Coord other)
	{
		return new Coord(this.x + other.x, this.y + other.y);
	}

	public Coord next()
	{
		int newX = this.x;
		int newY = this.y;

		if (this.y == Biome.BIOME_SIZE - 1)
		{
			newX++;
			newY = 0;
		}
		else
		{
			newY++;
		}

		return new Coord(newX, newY);
	}
	
	public Coord doNext(int times) {
		Coord temp = this;
		
		for (int i = 0; i < times; i++) {
			temp = temp.next();
		}
		
		return temp;
	}
}
