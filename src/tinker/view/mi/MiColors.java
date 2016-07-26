package tinker.view.mi;

import java.awt.Color;

public class MiColors {

	private Color foreground;
	private Color background;
	private Color red;
	private Color green;
	private Color oil;
	private Color grey;
	private Color purple;
	private Color hover;
	private Color darkBackground;

	public MiColors() {
		foreground = new Color(230, 255, 230);
		background = new Color(38, 77, 115);
		red = new Color(255, 102, 102);
		oil = new Color(153, 153, 102);
		grey = new Color(77, 77, 77);
		purple = new Color(102, 0, 51);
		green = new Color(45, 134, 89);
		hover = new Color(255, 191, 128);
		darkBackground = new Color(0, 33, 51);
	}

	public Color getDarkBackground() {
		return darkBackground;
	}

	public Color getHover() {
		return hover;
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
