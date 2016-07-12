package tinker.model.fish;

import java.sql.Array;
import java.util.ArrayList;

import tinker.model.fish.clues.Cigar;
import tinker.model.fish.clues.Clue;
import tinker.model.fish.clues.Drink;
import tinker.model.fish.clues.House;
import tinker.model.fish.clues.Nationality;
import tinker.model.fish.clues.Pet;

public class Game {

	private ArrayList<Clue> nationalities;
	private ArrayList<Clue> drinks;
	private ArrayList<Clue> cigars;
	private ArrayList<Clue> pets;
	private ArrayList<Clue> houses;

	private ArrayList<Clue> chosen_nationalities;
	private ArrayList<Clue> chosen_drinks;
	private ArrayList<Clue> chosen_cigars;
	private ArrayList<Clue> chosen_pets;
	private ArrayList<Clue> chosen_houses;

	public Game() {
		chosen_nationalities = new ArrayList<>();
		chosen_houses = new ArrayList<>();
		chosen_pets = new ArrayList<>();
		chosen_drinks = new ArrayList<>();
		chosen_cigars = new ArrayList<>();

		nationalities = new ArrayList<>();
		Nationality n = new Nationality("Brit");
		nationalities.add(n);
		n = new Nationality("Norwegian");
		nationalities.add(n);
		n = new Nationality("Swede");
		nationalities.add(n);
		n = new Nationality("Dane");
		nationalities.add(n);
		n = new Nationality("German");
		nationalities.add(n);

		drinks = new ArrayList<>();
		Drink d = new Drink("Tea");
		drinks.add(d);
		d = new Drink("Coffee");
		drinks.add(d);
		d = new Drink("Milk");
		drinks.add(d);
		d = new Drink("Beer");
		drinks.add(d);
		d = new Drink("Water");
		drinks.add(d);

		pets = new ArrayList<>();
		Pet p = new Pet("Dog");
		pets.add(p);
		p = new Pet("Cat");
		pets.add(p);
		p = new Pet("Horse");
		pets.add(p);
		p = new Pet("Fish");
		pets.add(p);
		p = new Pet("Bird");
		pets.add(p);

		houses = new ArrayList<>();
		House h = new House("Red");
		houses.add(h);
		h = new House("Green");
		houses.add(h);
		h = new House("White");
		houses.add(h);
		h = new House("Yellow");
		houses.add(h);
		h = new House("Blue");
		houses.add(h);

		cigars = new ArrayList<>();
		Cigar c = new Cigar("Pall Mall");
		cigars.add(c);
		c = new Cigar("Blends");
		cigars.add(c);
		c = new Cigar("Dunhill");
		cigars.add(c);
		c = new Cigar("BlueMaster");
		cigars.add(c);
		c = new Cigar("Prince");
		cigars.add(c);
	}

	public boolean isCorrect() {
		if (!(nationalities.isEmpty() && cigars.isEmpty() && drinks.isEmpty() && houses.isEmpty() && pets.isEmpty())) {
			return false;
		}

		String[] a = { "Norwegian", "Dane", "Brit", "German", "Swede" };
		for (int i = 0; i < a.length; i++)
			if (!a[i].equals(chosen_nationalities.get(i).getName())) {
				return false;
			}

		String[] b = { "Yellow", "Blue", "Red", "Green", "White" };
		for (int i = 0; i < b.length; i++)
			if (!b[i].equals(chosen_houses.get(i).getName()))
				return false;

		String[] c = { "Water", "Tea", "Milk", "Coffee", "Beer" };
		for (int i = 0; i < c.length; i++)
			if (!c[i].equals(chosen_drinks.get(i).getName()))
				return false;

		String[] d = { "Dunhill", "Blends", "Pall Mall", "Prince", "BlueMaster" };
		for (int i = 0; i < d.length; i++)
			if (!d[i].equals(chosen_cigars.get(i).getName()))
				return false;

		String[] e = { "Cat", "Horse", "Bird", "Fish", "Dog" };
		for (int i = 0; i < e.length; i++)
			if (!e[i].equals(chosen_pets.get(i).getName()))
				return false;

		return true;
	}

	public void add(ArrayList<Clue> cur, ArrayList<Clue> target, Clue clue, int index) {
		target.add(index, clue);
		for (int i = 0; i < cur.size(); i++)
			if (cur.get(i).getName().equals(clue.getName()))
				cur.remove(i);
	}

	public void solve() {
		Clue clue = new Pet("Cat");
		add(pets, chosen_pets, clue, 0);
		clue = new Pet("Horse");
		add(pets, chosen_pets, clue, 1);
		clue = new Pet("Bird");
		add(pets, chosen_pets, clue, 2);
		clue = new Pet("Fish");
		add(pets, chosen_pets, clue, 3);
		clue = new Pet("Dog");
		add(pets, chosen_pets, clue, 4);

		clue = new House("Yellow");
		add(houses, chosen_houses, clue, 0);
		clue = new House("Blue");
		add(houses, chosen_houses, clue, 1);
		clue = new House("Red");
		add(houses, chosen_houses, clue, 2);
		clue = new House("Green");
		add(houses, chosen_houses, clue, 3);
		clue = new House("White");
		add(houses, chosen_houses, clue, 4);

		clue = new Nationality("Norwegian");
		add(nationalities, chosen_nationalities, clue, 0);
		clue = new Nationality("Dane");
		add(nationalities, chosen_nationalities, clue, 1);
		clue = new Nationality("Brit");
		add(nationalities, chosen_nationalities, clue, 2);
		clue = new Nationality("German");
		add(nationalities, chosen_nationalities, clue, 3);
		clue = new Nationality("Swede");
		add(nationalities, chosen_nationalities, clue, 4);

		clue = new Drink("Water");
		add(drinks, chosen_drinks, clue, 0);
		clue = new Drink("Tea");
		add(drinks, chosen_drinks, clue, 1);
		clue = new Drink("Milk");
		add(drinks, chosen_drinks, clue, 2);
		clue = new Drink("Coffee");
		add(drinks, chosen_drinks, clue, 3);
		clue = new Drink("Beer");
		add(drinks, chosen_drinks, clue, 4);

		clue = new Cigar("Dunhill");
		add(cigars, chosen_cigars, clue, 0);
		clue = new Cigar("Blends");
		add(cigars, chosen_cigars, clue, 1);
		clue = new Cigar("Pall Mall");
		add(cigars, chosen_cigars, clue, 2);
		clue = new Cigar("Prince");
		add(cigars, chosen_cigars, clue, 3);
		clue = new Cigar("BlueMaster");
		add(cigars, chosen_cigars, clue, 4);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.solve();
		System.out.println(g.isCorrect());
	}

}
