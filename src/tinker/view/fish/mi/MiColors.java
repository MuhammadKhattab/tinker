package tinker.view.fish.mi;

import java.awt.Color;

public class MiColors {

	private Color foreground;
	private Color background;
	private Color red;
	private Color green;
	private Color oil;
	private Color grey;
	private Color purple;

	public MiColors() {
		foreground = new Color(230, 255, 230);
		background = new Color(38, 77, 115);
		red = new Color(204, 0, 0);
		oil = new Color(153, 153, 102);
		grey = new Color(77, 77, 77);
		purple = new Color(102, 0, 51);
		green = new Color(45, 134, 89);
	}

	public Color getForeground() {
		return foreground;
	}

	public Color getBackground() {
		return background;
	}

	public Color getRed() {
		return red;
	}

	public Color getGreen() {
		return green;
	}

	public Color getOil() {
		return oil;
	}

	public Color getGrey() {
		return grey;
	}

	public Color getPurple() {
		return purple;
	}

}
