package befaster.solutions;

public class ProductDiscount extends Discount {
    private final int numberOfItems;
    private final char productToDiscount;

    public ProductDiscount(int numberOfItems, char productToDiscount) {
        this.numberOfItems = numberOfItems;
        this.productToDiscount = productToDiscount;
    }

    @Override
    public boolean apply(int numberOfItems, Basket basket) {
        return (numberOfItems >= this.numberOfItems) && basket.contains(productToDiscount);
    }

    @Override
    public int getNumberOfAffectedItems(int numberOfItems, Basket basket) {
        return getPacksNumber(numberOfItems) * this.numberOfItems;
    }

    @Override
    public int getAmountToDiscount(int numberOfItems, Basket basket) {
        return getPacksNumber(numberOfItems) * this.productToDiscount;
    }

    private int getPacksNumber(int numberOfItems) {
        return (numberOfItems / this.numberOfItems) ;
    }
}
