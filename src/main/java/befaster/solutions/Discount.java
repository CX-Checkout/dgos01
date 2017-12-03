package befaster.solutions;

public class Discount {
    private final int numberOfItems;
    private final int quantityToDiscount;

    public Discount(int numberOfItems, int quantityToDiscount) {
        this.numberOfItems = numberOfItems;
        this.quantityToDiscount = quantityToDiscount;
    }

    public boolean matches(int numberOfItems) {
        return numberOfItems >= this.numberOfItems;
    }

    public int getDiscount(int numberOfItems) {
        int packs = numberOfItems / this.numberOfItems;
        return packs * quantityToDiscount;
    }
}
