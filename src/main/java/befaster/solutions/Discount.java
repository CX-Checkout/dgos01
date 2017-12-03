package befaster.solutions;

public abstract class Discount {

    public abstract boolean apply(int numberOfItems);
    public abstract int getAmountToDiscount(int numberOfItemsConsidered);
    public abstract int getNumberOfAffectedItems(int numberOfItemsConsidered);
}
