package befaster.solutions;

public abstract class Discount {

    public abstract boolean apply(int numberOfItems, Basket basket);
    public abstract int getAmountToDiscount(int numberOfItems, Basket basket);
    public abstract int getNumberOfAffectedItems(int numberOfItems, Basket basket);
}
