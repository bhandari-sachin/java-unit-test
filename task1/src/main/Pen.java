public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");

        private final String color;
        Color(String color) { this.color = color; }

        @Override
        public String toString() { return color; }
    }

    private Color currentColor; // color for next stroke
    private Color drawColor;    // color currently being drawn
    private boolean capped;

    // Default constructor → RED
    public Pen() {
        this.currentColor = Color.RED;
        this.drawColor = Color.RED;
        this.capped = true; // start capped
    }

    // Constructor with color
    public Pen(Color color) {
        this.currentColor = color;
        this.drawColor = color;
        this.capped = true; // start capped
    }

    // Cap the pen
    public void capOn() {
        this.capped = true;
        this.drawColor = currentColor; // update draw color for next uncapped stroke
    }

    // Uncap the pen
    public void capOff() {
        this.capped = false;
    }

    // Draw method
    public String draw() {
        if (capped) return "";
        return "Drawing " + drawColor.toString();
    }

    // Change pen color
    public void changeColor(Color newColor) {
        this.currentColor = newColor;
        if (capped) {
            this.drawColor = newColor; // only update draw color if capped
        }
    }
}
