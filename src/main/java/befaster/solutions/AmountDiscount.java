package befaster.solutions;

public class Discount {
    private final int numberOfItems;
    private final int amountToDiscountPerPack;

    public Discount(int numberOfItems, int amountToDiscountPerPack) {
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