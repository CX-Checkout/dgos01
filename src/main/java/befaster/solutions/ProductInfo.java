package befaster.solutions;

public class ProductInfo {
    private int pricePerUnit;
    private Discounts discounts;

    public ProductInfo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        this.discounts = new Discounts();
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public Discounts getDiscounts() {
        return discounts;
    }

//    public void addProductDiscount(int numberOfItems, char productToDiscount) {
//        discounts.add(new ProductDiscount(numberOfItems, productToDiscount));
//    }
}
