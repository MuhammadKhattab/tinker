package tinker.view.fish;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tinker.view.WindowDestroyer;
import tinker.view.fish.combo.CigarsComboBox;
import tinker.view.fish.combo.ColorsComboBox;
import tinker.view.fish.combo.DrinksComboBox;
import tinker.view.fish.combo.NationalitiesComboBox;
import tinker.view.fish.combo.PetsComboBox;
import tinker.view.fish.mi.MiButton;
import tinker.view.fish.mi.MiLabel;

@SuppressWarnings("serial")
public class FishView extends JFrame {

	private MiButton back;
	private MiButton solve;
	private MiButton info;
	private MiButton house1;
	private MiButton house2;
	private MiButton house3;
	private MiButton house4;
	private MiButton house5;

	private JPanel buttons;
	private JPanel table;

	private NationalitiesComboBox nat1;
	private NationalitiesComboBox nat2;
	private NationalitiesComboBox nat3;
	private NationalitiesComboBox nat4;
	private NationalitiesComboBox nat5;

	private PetsComboBox pets1;
	private PetsComboBox pets2;
	private PetsComboBox pets3;
	private PetsComboBox pets4;
	private PetsComboBox pets5;

	private ColorsComboBox colors1;
	private ColorsComboBox colors2;
	private ColorsComboBox colors3;
	private ColorsComboBox colors4;
	private ColorsComboBox colors5;

	private DrinksComboBox drinks1;
	private DrinksComboBox drinks2;
	private DrinksComboBox drinks3;
	private DrinksComboBox drinks4;
	private DrinksComboBox drinks5;

	private CigarsComboBox cigars1;
	private CigarsComboBox cigars2;
	private CigarsComboBox cigars3;
	private CigarsComboBox cigars4;
	private CigarsComboBox cigars5;

	public FishView() {
		super("Tinker");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowDestroyer());
		setLayout(new BorderLayout());

		Color buttonsbg = new Color(38, 77, 115);
		Color worldbg = new Color(25, 51, 77);
		setBackground(worldbg);

		table = new JPanel(new GridLayout(0, 6));
		table.add(new MiLabel(""));
		table.add(new MiLabel("House #1"));
		table.add(new MiLabel("House #2"));
		table.add(new MiLabel("House #3"));
		table.add(new MiLabel("House #4"));
		table.add(new MiLabel("House #5"));

		table.add(new MiLabel("Nationalities"));
		nat1 = new NationalitiesComboBox();
		table.add(nat1);
		nat2 = new NationalitiesComboBox();
		table.add(nat2);
		nat3 = new NationalitiesComboBox();
		table.add(nat3);
		nat4 = new NationalitiesComboBox();
		table.add(nat4);
		nat5 = new NationalitiesComboBox();
		table.add(nat5);

		table.add(new MiLabel("Colors"));
		colors1 = new ColorsComboBox();
		table.add(colors1);
		colors2 = new ColorsComboBox();
		table.add(colors2);
		colors3 = new ColorsComboBox();
		table.add(colors3);
		colors4 = new ColorsComboBox();
		table.add(colors4);
		colors5 = new ColorsComboBox();
		table.add(colors5);

		table.add(new MiLabel("Beverages"));
		drinks1 = new DrinksComboBox();
		table.add(drinks1);
		drinks2 = new DrinksComboBox();
		table.add(drinks2);
		drinks3 = new DrinksComboBox();
		table.add(drinks3);
		drinks4 = new DrinksComboBox();
		table.add(drinks4);
		drinks5 = new DrinksComboBox();
		table.add(drinks5);

		table.add(new MiLabel("Pets"));
		pets1 = new PetsComboBox();
		table.add(pets1);
		pets2 = new PetsComboBox();
		table.add(pets2);
		pets3 = new PetsComboBox();
		table.add(pets3);
		pets4 = new PetsComboBox();
		table.add(pets4);
		pets5 = new PetsComboBox();
		table.add(pets5);

		table.add(new MiLabel("Cigars"));
		cigars1 = new CigarsComboBox();
		table.add(cigars1);
		cigars2 = new CigarsComboBox();
		table.add(cigars2);
		cigars3 = new CigarsComboBox();
		table.add(cigars3);
		cigars4 = new CigarsComboBox();
		table.add(cigars4);
		cigars5 = new CigarsComboBox();
		table.add(cigars5);
		
		table.setBackground(buttonsbg);

		house1 = new MiButton("House #1");
		house1.setName("house1");

		house2 = new MiButton("House #2");
		house2.setName("house2");

		house3 = new MiButton("House #3");
		house3.setName("house3");

		house4 = new MiButton("House #4");
		house4.setName("house4");

		house5 = new MiButton("House #5");
		house5.setName("house5");

		back = new MiButton("Back");
		back.setName("back");

		solve = new MiButton("Solve it");
		solve.setName("solve");

		info = new MiButton("Available Information");
		info.setName("info");

		buttons = new JPanel(new GridLayout(0, 5));
		buttons.setBackground(new Color(25, 51, 77));

		buttons.add(house1);
		buttons.add(house2);
		buttons.add(house3);
		buttons.add(house4);
		buttons.add(house5);

		buttons.add(info);
		buttons.add(solve);
		buttons.add(back);

		add(table, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);

		setVisible(true);
	}

	public MiButton getBack() {
		return back;
	}

	public MiButton getSolve() {
		return solve;
	}

	public MiButton getInfo() {
		return info;
	}

	public MiButton getHouse1() {
		return house1;
	}

	public MiButton getHouse2() {
		return house2;
	}

	public MiButton getHouse3() {
		return house3;
	}

	public MiButton getHouse4() {
		return house4;
	}

	public MiButton getHouse5() {
		return house5;
	}

	public JPanel getButtons() {
		return buttons;
	}

	public JPanel getTable() {
		return table;
	}

	public NationalitiesComboBox getNat1() {
		return nat1;
	}

	public NationalitiesComboBox getNat2() {
		return nat2;
	}

	public NationalitiesComboBox getNat3() {
		return nat3;
	}

	public NationalitiesComboBox getNat4() {
		return nat4;
	}

	public NationalitiesComboBox getNat5() {
		return nat5;
	}

	public PetsComboBox getPets1() {
		return pets1;
	}

	public PetsComboBox getPets2() {
		return pets2;
	}

	public PetsComboBox getPets3() {
		return pets3;
	}

	public PetsComboBox getPets4() {
		return pets4;
	}

	public PetsComboBox getPets5() {
		return pets5;
	}

	public ColorsComboBox getColors1() {
		return colors1;
	}

	public ColorsComboBox getColors2() {
		return colors2;
	}

	public ColorsComboBox getColors3() {
		return colors3;
	}

	public ColorsComboBox getColors4() {
		return colors4;
	}

	public ColorsComboBox getColors5() {
		return colors5;
	}

	public DrinksComboBox getDrinks1() {
		return drinks1;
	}

	public DrinksComboBox getDrinks2() {
		return drinks2;
	}

	public DrinksComboBox getDrinks3() {
		return drinks3;
	}

	public DrinksComboBox getDrinks4() {
		return drinks4;
	}

	public DrinksComboBox getDrinks5() {
		return drinks5;
	}

	public CigarsComboBox getCigars1() {
		return cigars1;
	}

	public CigarsComboBox getCigars2() {
		return cigars2;
	}

	public CigarsComboBox getCigars3() {
		return cigars3;
	}

	public CigarsComboBox getCigars4() {
		return cigars4;
	}

	public CigarsComboBox getCigars5() {
		return cigars5;
	}

	
}
