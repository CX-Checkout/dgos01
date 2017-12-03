package befaster.solutions;

public class Discount {
    private final int numberOfItems;
    private final int amountToDiscountPerPack;

    public Discount(int numberOfItems, int amountToDiscountPerPack) {
        this.numberOfItems = numberOfItems;
        this.amountToDiscountPerPack = amountToDiscountPerPack;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getAmountToDiscountPerPack() {
        return amountToDiscountPerPack;
    }

    public int getNumberOfAffectedItems(int numberOfItemsConsidered) {
        return numberOfItemsConsidered / this.numberOfItems * this.numberOfItems;
    }
}
