package befaster.solutions;

public class PackDiscount {
    private final int numberOfItems;
    private final int pricePerPack;
    private final char[] items;

    public PackDiscount(int numberOfItems, int pricePerPack, char... items) {
        this.numberOfItems = numberOfItems;
        this.pricePerPack = pricePerPack;
        this.items = items;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getPricePerPack() {
        return pricePerPack;
    }

    public char[] getItems() {
        return items;
    }

    public char getItemForIndex(int index) {
        return items[index];
    }
}
