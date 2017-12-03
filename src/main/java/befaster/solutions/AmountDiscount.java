package befaster.solutions;

public class AmountDiscount {
    private final int numberOfItems;
    private final int amountToDiscountPerPack;

    public AmountDiscount(int numberOfItems, int amountToDiscountPerPack) {
        this.numberOfItems = numberOfItems;
        this.amountToDiscountPerPack = amountToDiscountPerPack;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getAmountToDiscountPerPack() {
        return amountToDiscountPerPack;
    }

    public boolean apply(int numberOfItems) {
        return numberOfItems >= this.numberOfItems;
    }
}
