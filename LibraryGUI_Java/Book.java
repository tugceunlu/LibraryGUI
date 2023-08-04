public class Book extends Item {

    private String author;

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public double calculatePrice() {
        int authorNameLength = getAuthor().length();
        double pricePerCharacter = 0.10;
        return authorNameLength * pricePerCharacter;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (author: %s)", author);
    }
}
