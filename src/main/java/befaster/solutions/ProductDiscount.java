package befaster.solutions;

public class ProductDiscount extends Discount {
    private final int numberOfItems;
    private final char productToDiscount;

    public ProductDiscount(int numberOfItems, char productToDiscount) {
        this.numberOfItems = numberOfItems;
        this.productToDiscount = productToDiscount;
    }

    @Override
    public boolean apply(int numberOfItems) {
        return false;
    }

    @Override
    public int getAmountToDiscount(int numberOfItemsConsidered) {
        return 0;
    }

    @Override
    public int getNumberOfAffectedItems(int numberOfItemsConsidered) {
        return 0;
    }
}
