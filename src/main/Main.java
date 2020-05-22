package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import engine.Biome;
import engine.Engine;
import engine.NPC;
import engine.Preference;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		List<NPC> npcs = new ArrayList<NPC>();
		ArrayList<Biome> biomes = new ArrayList<Biome>();

		Biome Forest = new Biome("Forest", 0.8, 0.8, 2);
		biomes.add(Forest);
		Biome Hallow = new Biome("Hallow", 0.9, 1.0, 0.5);
		biomes.add(Hallow);
		Biome Underground = new Biome("Underground", 0.8, 0.8, 2);
		biomes.add(Underground);
		Biome Desert = new Biome("Desert", 0.9, 1.0, 0.5);
		biomes.add(Desert);
		Biome Jungle = new Biome("Jungle", 0.8, 0.8, 2);
		biomes.add(Jungle);
		Biome Ocean = new Biome("Ocean", 1.0, 1.0, 1);
		biomes.add(Ocean);
		Biome Snow = new Biome("Snow", 0.9, 1.0, 0.5);
		biomes.add(Snow);

		NPC Guide = new NPC("Guide", 0.0);
		npcs.add(Guide);
		Guide.setPreferedBiome(Forest, Preference.LIKED);
		Guide.setPreferedBiome(Ocean, Preference.DISLIKED);

		NPC Merchant = new NPC("Mercha", 0.8);
		npcs.add(Merchant);
		Merchant.setPreferedBiome(Forest, Preference.LIKED);
		Merchant.setPreferedBiome(Desert, Preference.DISLIKED);

		NPC Zoologist = new NPC("Zoolog", 0.8);
		npcs.add(Zoologist);
		Zoologist.setPreferedBiome(Forest, Preference.LIKED);
		Zoologist.setPreferedBiome(Desert, Preference.DISLIKED);

		NPC Golfer = new NPC("Golfer", 0.8);
		npcs.add(Golfer);
		Golfer.setPreferedBiome(Forest, Preference.LIKED);
		Golfer.setPreferedBiome(Underground, Preference.DISLIKED);

		NPC Nurse = new NPC("Nurse", 0.0);
		npcs.add(Nurse);
		Nurse.setPreferedBiome(Hallow, Preference.LIKED);
		Nurse.setPreferedBiome(Snow, Preference.DISLIKED);

		NPC Tavernkeep = new NPC("Tavern", 0.8);
		npcs.add(Tavernkeep);
		Tavernkeep.setPreferedBiome(Hallow, Preference.LIKED);
		Tavernkeep.setPreferedBiome(Snow, Preference.DISLIKED);

		NPC Party = new NPC("Party", 0.8);
		npcs.add(Party);
		Party.setPreferedBiome(Hallow, Preference.LIKED);
		Party.setPreferedBiome(Underground, Preference.DISLIKED);

		NPC Wizard = new NPC("Wizard", 1.0);
		npcs.add(Wizard);
		Wizard.setPreferedBiome(Hallow, Preference.LIKED);
		Wizard.setPreferedBiome(Ocean, Preference.DISLIKED);

		NPC Demolitionist = new NPC("Demoli", 1.0);
		npcs.add(Demolitionist);
		Demolitionist.setPreferedBiome(Underground, Preference.LIKED);
		Demolitionist.setPreferedBiome(Ocean, Preference.DISLIKED);

		NPC Goblin = new NPC("Goblin", 0.8);
		npcs.add(Goblin);
		Goblin.setPreferedBiome(Underground, Preference.LIKED);
		Goblin.setPreferedBiome(Jungle, Preference.DISLIKED);

		NPC Clothier = new NPC("Clothi", 0.8);
		npcs.add(Clothier);
		Clothier.setPreferedBiome(Underground, Preference.LIKED);
		Clothier.setPreferedBiome(Hallow, Preference.DISLIKED);

		NPC Dye = new NPC("Dye", 0.8);
		npcs.add(Dye);
		Dye.setPreferedBiome(Desert, Preference.LIKED);
		Dye.setPreferedBiome(Forest, Preference.DISLIKED);

		NPC Arms = new NPC("Arms", 1.2);
		npcs.add(Arms);
		Arms.setPreferedBiome(Desert, Preference.LIKED);
		Arms.setPreferedBiome(Snow, Preference.DISLIKED);

		NPC Steampunker = new NPC("Steamp", 1.2);
		npcs.add(Steampunker);
		Steampunker.setPreferedBiome(Desert, Preference.LIKED);
		Steampunker.setPreferedBiome(Jungle, Preference.DISLIKED);

		NPC Dryad = new NPC("Dryad", 0.8);
		npcs.add(Dryad);
		Dryad.setPreferedBiome(Jungle, Preference.LIKED);
		Dryad.setPreferedBiome(Desert, Preference.DISLIKED);

		NPC Painter = new NPC("Painte", 0.8);
		npcs.add(Painter);
		Painter.setPreferedBiome(Jungle, Preference.LIKED);
		Painter.setPreferedBiome(Forest, Preference.DISLIKED);

		NPC Witch = new NPC("Witch", 1.0);
		npcs.add(Witch);
		Witch.setPreferedBiome(Jungle, Preference.LIKED);
		Witch.setPreferedBiome(Hallow, Preference.DISLIKED);

		NPC Stylist = new NPC("Stylis", 0.8);
		npcs.add(Stylist);
		Stylist.setPreferedBiome(Ocean, Preference.LIKED);
		Stylist.setPreferedBiome(Snow, Preference.DISLIKED);

		NPC Angler = new NPC("Angler", 0.0);
		npcs.add(Angler);
		Angler.setPreferedBiome(Ocean, Preference.LIKED);
		Angler.setPreferedBiome(Desert, Preference.DISLIKED);

		NPC Pirate = new NPC("Pirate", 0.8);
		npcs.add(Pirate);
		Pirate.setPreferedBiome(Ocean, Preference.LIKED);
		Pirate.setPreferedBiome(Underground, Preference.DISLIKED);

		NPC Mechanic = new NPC("Mechan", 1.2);
		npcs.add(Mechanic);
		Mechanic.setPreferedBiome(Snow, Preference.LIKED);
		Mechanic.setPreferedBiome(Underground, Preference.DISLIKED);

		NPC Tax = new NPC("Tax", 0.0);
		npcs.add(Tax);
		Tax.setPreferedBiome(Snow, Preference.LIKED);
		Tax.setPreferedBiome(Hallow, Preference.DISLIKED);

		NPC Cyborg = new NPC("Cyborg", 1.2);
		npcs.add(Cyborg);
		Cyborg.setPreferedBiome(Snow, Preference.LIKED);
		Cyborg.setPreferedBiome(Jungle, Preference.DISLIKED);

		NPC Santa = new NPC("Santa", 0.8);
		npcs.add(Santa);
		Santa.setPreferedBiome(Snow, Preference.LOVED);
		Santa.setPreferedBiome(Desert, Preference.HATED);

		NPC Truffle = new NPC("Truffl", 0.8);
		npcs.add(Truffle);

		Guide.setPreferredNeighbour(Clothier, Preference.LIKED);
		Guide.setPreferredNeighbour(Zoologist, Preference.LIKED);
		Guide.setPreferredNeighbour(Steampunker, Preference.DISLIKED);
		Guide.setPreferredNeighbour(Painter, Preference.HATED);

		Merchant.setPreferredNeighbour(Golfer, Preference.LIKED);
		Merchant.setPreferredNeighbour(Nurse, Preference.LIKED);
		Merchant.setPreferredNeighbour(Tax, Preference.DISLIKED);
		Merchant.setPreferredNeighbour(Angler, Preference.HATED);

		Zoologist.setPreferredNeighbour(Witch, Preference.LOVED);
		Zoologist.setPreferredNeighbour(Golfer, Preference.LIKED);
		Zoologist.setPreferredNeighbour(Angler, Preference.DISLIKED);
		Zoologist.setPreferredNeighbour(Arms, Preference.HATED);

		Golfer.setPreferredNeighbour(Angler, Preference.LIKED);
		Golfer.setPreferredNeighbour(Painter, Preference.LIKED);
		Golfer.setPreferredNeighbour(Zoologist, Preference.LIKED);
		Golfer.setPreferredNeighbour(Pirate, Preference.DISLIKED);
		Golfer.setPreferredNeighbour(Merchant, Preference.HATED);

		Nurse.setPreferredNeighbour(Arms, Preference.LOVED);
		Nurse.setPreferredNeighbour(Wizard, Preference.LIKED);
		Nurse.setPreferredNeighbour(Dryad, Preference.DISLIKED);
		Nurse.setPreferredNeighbour(Party, Preference.DISLIKED);
		Nurse.setPreferredNeighbour(Zoologist, Preference.HATED);

		Tavernkeep.setPreferredNeighbour(Demolitionist, Preference.LOVED);
		Tavernkeep.setPreferredNeighbour(Goblin, Preference.LIKED);
		Tavernkeep.setPreferredNeighbour(Guide, Preference.DISLIKED);
		Tavernkeep.setPreferredNeighbour(Dye, Preference.HATED);

		Party.setPreferredNeighbour(Wizard, Preference.LOVED);
		Party.setPreferredNeighbour(Stylist, Preference.LIKED);
		Party.setPreferredNeighbour(Merchant, Preference.DISLIKED);
		Party.setPreferredNeighbour(Tax, Preference.HATED);

		Wizard.setPreferredNeighbour(Golfer, Preference.LOVED);
		Wizard.setPreferredNeighbour(Merchant, Preference.LIKED);
		Wizard.setPreferredNeighbour(Witch, Preference.DISLIKED);
		Wizard.setPreferredNeighbour(Cyborg, Preference.HATED);

		Demolitionist.setPreferredNeighbour(Tavernkeep, Preference.LOVED);
		Demolitionist.setPreferredNeighbour(Mechanic, Preference.LIKED);
		Demolitionist.setPreferredNeighbour(Arms, Preference.DISLIKED);
		Demolitionist.setPreferredNeighbour(Goblin, Preference.DISLIKED);

		Goblin.setPreferredNeighbour(Mechanic, Preference.LOVED);
		Goblin.setPreferredNeighbour(Dye, Preference.LIKED);
		Goblin.setPreferredNeighbour(Clothier, Preference.DISLIKED);
		Goblin.setPreferredNeighbour(Stylist, Preference.HATED);

		Clothier.setPreferredNeighbour(Truffle, Preference.LOVED);
		Clothier.setPreferredNeighbour(Tax, Preference.LIKED);
		Clothier.setPreferredNeighbour(Nurse, Preference.DISLIKED);
		Clothier.setPreferredNeighbour(Mechanic, Preference.HATED);

		Dye.setPreferredNeighbour(Arms, Preference.LIKED);
		Dye.setPreferredNeighbour(Painter, Preference.LIKED);
		Dye.setPreferredNeighbour(Steampunker, Preference.DISLIKED);
		Dye.setPreferredNeighbour(Pirate, Preference.HATED);

		Arms.setPreferredNeighbour(Nurse, Preference.LOVED);
		Arms.setPreferredNeighbour(Steampunker, Preference.LIKED);
		Arms.setPreferredNeighbour(Golfer, Preference.DISLIKED);
		Arms.setPreferredNeighbour(Demolitionist, Preference.HATED);

		Steampunker.setPreferredNeighbour(Cyborg, Preference.LOVED);
		Steampunker.setPreferredNeighbour(Painter, Preference.LIKED);
		Steampunker.setPreferredNeighbour(Dryad, Preference.DISLIKED);
		Steampunker.setPreferredNeighbour(Party, Preference.DISLIKED);
		Steampunker.setPreferredNeighbour(Wizard, Preference.DISLIKED);

		Dryad.setPreferredNeighbour(Witch, Preference.LIKED);
		Dryad.setPreferredNeighbour(Truffle, Preference.LIKED);
		Dryad.setPreferredNeighbour(Angler, Preference.DISLIKED);
		Dryad.setPreferredNeighbour(Zoologist, Preference.DISLIKED);
		Dryad.setPreferredNeighbour(Golfer, Preference.HATED);

		Painter.setPreferredNeighbour(Dryad, Preference.LOVED);
		Painter.setPreferredNeighbour(Party, Preference.LIKED);
		Painter.setPreferredNeighbour(Truffle, Preference.DISLIKED);
		Painter.setPreferredNeighbour(Cyborg, Preference.DISLIKED);

		Witch.setPreferredNeighbour(Dryad, Preference.LIKED);
		Witch.setPreferredNeighbour(Truffle, Preference.LIKED);
		Witch.setPreferredNeighbour(Angler, Preference.DISLIKED);
		Witch.setPreferredNeighbour(Zoologist, Preference.DISLIKED);
		Witch.setPreferredNeighbour(Golfer, Preference.HATED);

		Stylist.setPreferredNeighbour(Dye, Preference.LOVED);
		Stylist.setPreferredNeighbour(Pirate, Preference.LIKED);
		Stylist.setPreferredNeighbour(Tavernkeep, Preference.DISLIKED);
		Stylist.setPreferredNeighbour(Goblin, Preference.HATED);

		Angler.setPreferredNeighbour(Demolitionist, Preference.LIKED);
		Angler.setPreferredNeighbour(Party, Preference.LIKED);
		Angler.setPreferredNeighbour(Tax, Preference.LIKED);
		Angler.setPreferredNeighbour(Tavernkeep, Preference.HATED);

		Pirate.setPreferredNeighbour(Angler, Preference.LOVED);
		Pirate.setPreferredNeighbour(Tavernkeep, Preference.LIKED);
		Pirate.setPreferredNeighbour(Stylist, Preference.DISLIKED);
		Pirate.setPreferredNeighbour(Guide, Preference.HATED);

		Mechanic.setPreferredNeighbour(Goblin, Preference.LOVED);
		Mechanic.setPreferredNeighbour(Cyborg, Preference.LIKED);
		Mechanic.setPreferredNeighbour(Arms, Preference.DISLIKED);
		Mechanic.setPreferredNeighbour(Clothier, Preference.HATED);

		Cyborg.setPreferredNeighbour(Steampunker, Preference.LIKED);
		Cyborg.setPreferredNeighbour(Pirate, Preference.LIKED);
		Cyborg.setPreferredNeighbour(Stylist, Preference.LIKED);
		Cyborg.setPreferredNeighbour(Zoologist, Preference.DISLIKED);
		Cyborg.setPreferredNeighbour(Wizard, Preference.HATED);

		Santa.setPreferredNeighbour(Tax, Preference.HATED);

		Truffle.setPreferredNeighbour(Guide, Preference.LOVED);
		Truffle.setPreferredNeighbour(Dryad, Preference.LIKED);
		Truffle.setPreferredNeighbour(Clothier, Preference.DISLIKED);
		Truffle.setPreferredNeighbour(Witch, Preference.HATED);

		Engine engine = new Engine(npcs, biomes);

		String best = "";
		double value = Double.MAX_VALUE;

		long time = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++)
		{
			engine.launch();

			if (engine.getValue() < value)
			{
				value = engine.getValue();
				best = engine.toString();
			}
		}

		best = ((System.currentTimeMillis() - time) / 1000.0) + best;
		System.out.println(best);
	}

}
