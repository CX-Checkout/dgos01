package befaster.solutions;

public class Discount {
    private final int numberOfItems;
    private final int quantityToDiscount;

    public Discount(int numberOfItems, int quantityToDiscount) {
        this.numberOfItems = numberOfItems;
        this.quantityToDiscount = quantityToDiscount;
    }

    public boolean applyFor(int numberOfItems) {
        return numberOfItems >= this.numberOfItems;
    }

    public int getAmountToDiscountFor(int numberOfItems) {
        int packs = numberOfItems / this.numberOfItems;
        return packs * quantityToDiscount;
    }
}
