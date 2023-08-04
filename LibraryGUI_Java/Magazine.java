public class Magazine extends Item {

    private String publisher;

    public Magazine(String title, int year, String publisher) {
        super(title, year);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String getType() {
        return "Magazine";
    }

    @Override
    public double calculatePrice() {
        int publisherNameLength = getPublisher().length();
        double pricePerCharacter = 0.05;
        return publisherNameLength * pricePerCharacter;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (publisher: %s)", publisher);
    }
}
