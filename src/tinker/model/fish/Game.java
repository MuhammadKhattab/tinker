package tinker.model.fish;

import tinker.model.fish.clues.Cigar;
import tinker.model.fish.clues.Clue;
import tinker.model.fish.clues.Drink;
import tinker.model.fish.clues.House;
import tinker.model.fish.clues.Nationality;
import tinker.model.fish.clues.Pet;

public class Game {

	private Nationality[] nationalities;
	private Drink[] drinks;
	private Cigar[] cigars;
	private Pet[] pets;
	private House[] houses;

	public Game() {
		nationalities = new Nationality[5];
		Nationality n = new Nationality("Brit");
		nationalities[0] = n;
		n = new Nationality("Norwegian");
		nationalities[1] = n;
		n = new Nationality("Swede");
		nationalities[2] = n;
		n = new Nationality("Dane");
		nationalities[3] = n;
		n = new Nationality("German");
		nationalities[4] = n;

		drinks = new Drink[5];
		Drink d = new Drink("Tea");
		drinks[0] = d;
		d = new Drink("Coffee");
		drinks[1] = d;
		d = new Drink("Milk");
		drinks[2] = d;
		d = new Drink("Beer");
		drinks[3] = d;
		d = new Drink("Water");
		drinks[4] = d;

		pets = new Pet[5];
		Pet p = new Pet("Dog");
		pets[0] = p;
		p = new Pet("Cat");
		pets[1] = p;
		p = new Pet("Horse");
		pets[2] = p;
		p = new Pet("Fish");
		pets[3] = p;
		p = new Pet("Bird");
		pets[4] = p;

		houses = new House[5];
		House h = new House("Red");
		houses[0] = h;
		h = new House("Green");
		houses[1] = h;
		h = new House("White");
		houses[2] = h;
		h = new House("Yellow");
		houses[3] = h;
		h = new House("Blue");
		houses[4] = h;

		cigars = new Cigar[5];
		Cigar c = new Cigar("Pall Mall");
		cigars[0] = c;
		c = new Cigar("Blends");
		cigars[1] = c;
		c = new Cigar("Dunhill");
		cigars[2] = c;
		c = new Cigar("BlueMaster");
		cigars[3] = c;
		c = new Cigar("Prince");
		cigars[4] = c;

	}

	public Nationality[] getNationalities() {
		return nationalities;
	}

	public Drink[] getDrinks() {
		return drinks;
	}

	public Cigar[] getCigars() {
		return cigars;
	}

	public Pet[] getPets() {
		return pets;
	}

	public House[] getColors() {
		return houses;
	}

	public boolean isCorrect() {
		String[] a = { "Norwegian", "Dane", "Brit", "German", "Swede" };
		for (int i = 0; i < a.length; i++)
			if (!a[i].equals(nationalities[i].getName()))
				return false;

		String[] b = { "Yellow", "Blue", "Red", "Green", "White" };
		for (int i = 0; i < b.length; i++)
			if (!b[i].equals(houses[i].getName()))
				return false;

		String[] c = { "Water", "Tea", "Milk", "Coffee", "Beer" };
		for (int i = 0; i < c.length; i++)
			if (!c[i].equals(drinks[i].getName()))
				return false;

		String[] d = { "Dunhill", "Blends", "Pall Mall", "Prince", "BlueMaster" };
		for (int i = 0; i < d.length; i++)
			if (!d[i].equals(cigars[i].getName()))
				return false;

		String[] e = { "Cat", "Horse", "Bird", "Fish", "Dog" };
		for (int i = 0; i < e.length; i++)
			if (!e[i].equals(pets[i].getName()))
				return false;

		return true;
	}

	public void add(Clue[] clues, Clue clue, int target) {
		clues[target] = clue;
	}

}
