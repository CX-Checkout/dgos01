package befaster.solutions;

public class AmountDiscount {
    private final int numberOfItems;
    private final int amountToDiscountPerPack;

    public AmountDiscount(int numberOfItems, int amountToDiscountPerPack) {
        this.numberOfItems = numberOfItems;
        this.amountToDiscountPerPack = amountToDiscountPerPack;
    }

    public boolean apply(int numberOfItems) {
        return numberOfItems >= this.numberOfItems;
    }

    public int getNumberOfAffectedItems(int numberOfItems) {
        return getPacksNumber(numberOfItems) * this.numberOfItems;
    }

    public int getAmountToDiscount(int numberOfItems) {
        return getPacksNumber(numberOfItems) * this.amountToDiscountPerPack;
    }

    private int getPacksNumber(int numberOfItems) {
        return numberOfItems / this.numberOfItems;
    }
}
