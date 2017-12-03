package befaster.solutions;

public class Discount {
    private final int numberOfItems;
    private final int quantityToDiscount;

    public Discount(int numberOfItems, int quantityToDiscount) {
        this.numberOfItems = numberOfItems;
        this.quantityToDiscount = quantityToDiscount;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getQuantityToDiscount() {
        return quantityToDiscount;
    }
}
