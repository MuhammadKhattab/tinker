package tinker.view.mi;

import java.awt.Color;

public class MiColors {

	private Color foreground;
	private Color background;
	private Color purple1;
	private Color grey1;
	private Color grey2;
	private Color grey;
	private Color purple;
	private Color hover;
	private Color darkBackground;

	public MiColors() {
		foreground = new Color(230, 255, 230);
		background = new Color(38, 77, 115);
		darkBackground = new Color(0, 33, 51);

		grey = new Color(13, 13, 13);
		grey1 = new Color(26, 26, 26);
		grey2 = new Color(38, 38, 38);

		purple = new Color(26, 0, 13);
		purple1 = new Color(39, 12, 26);

		hover = new Color(255, 191, 128);
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

	public Color getGrey() {
		return grey;
	}

	public Color getPurple1() {
		return purple1;
	}

	public Color getGrey1() {
		return grey1;
	}

	public Color getGrey2() {
		return grey2;
	}

	public Color getPurple() {
		return purple;
	}

}
