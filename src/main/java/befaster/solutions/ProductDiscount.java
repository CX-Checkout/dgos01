package befaster.solutions;

public class ProductDiscount {
    private final int numberOfItems;
    private final char itemToDiscount;

    public ProductDiscount(int numberOfItems, char itemToDiscount) {
        this.numberOfItems = numberOfItems;
        this.itemToDiscount = itemToDiscount;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public char getItemToDiscount() {
        return itemToDiscount;
    }

    public boolean apply(char item, Integer numberOfItems) {
        if (item == itemToDiscount)
            return numberOfItems > this.numberOfItems;
        return numberOfItems >= this.numberOfItems;
    }

    public int getNumberOfPacks(char item, Integer numberOfItems) {
        if (item == itemToDiscount)
            return (numberOfItems) / (this.numberOfItems + 1);
        return numberOfItems / this.numberOfItems;
    }
}
