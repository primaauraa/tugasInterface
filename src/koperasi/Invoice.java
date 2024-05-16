package koperasi;

public class Invoice implements Payable{
    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem){
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPayableAmount(){
        return quantity * pricePerItem;
    }

    public String getProductName(){
        return getProductName();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    @Override
    public String toString(){
        return String.format("%d buah %s\t\tRp %,d", quantity, productName, (int)getPayableAmount());
    }

}

