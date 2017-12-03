package befaster.solutions;

public class AmountDiscount extends Discount {
    private final int numberOfItems;
    private final int amountToDiscountPerPack;

    public AmountDiscount(int numberOfItems, int amountToDiscountPerPack) {
        this.numberOfItems = numberOfItems;
        this.amountToDiscountPerPack = amountToDiscountPerPack;
    }

    @Override
    public boolean apply(int numberOfItems, Basket basket) {
        return numberOfItems >= this.numberOfItems;
    }

    @Override
    public int getNumberOfAffectedItems(int numberOfItems, Basket basket) {
        return getPacksNumber(numberOfItems) * this.numberOfItems;
    }

    @Override
    public int getAmountToDiscount(int numberOfItems, Basket basket) {
        return getPacksNumber(numberOfItems) * this.amountToDiscountPerPack;
    }

    private int getPacksNumber(int numberOfItems) {
        return numberOfItems / this.numberOfItems;
    }
}
