package befaster.solutions;

public abstract class Discount {

    public abstract boolean apply(int numberOfItems);
    public abstract int getAmountToDiscount(int numberOfItems);
    public abstract int getNumberOfAffectedItems(int numberOfItems);
}
