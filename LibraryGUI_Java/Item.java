public abstract class Item {

    protected String title;
    protected int year;

    public Item(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public abstract String getType();

    public abstract double calculatePrice();

    @Override
    public String toString() {
        return String.format("%s: %s (year: %d)", getType(), title, year);
    }
}
