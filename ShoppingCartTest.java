import java.util.ArrayList;

class Item{
    
    private String productName;
    private int quantity ;
    private double unitPrice;


    Item(String productName , int quantity , double unitPrice){

        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getAmount(){
        double amnt = (quantity * unitPrice);
        return amnt;
    }


    public void getAllCart(){
        System.out.println(productName + ": " + quantity);
    }

    public void getAll(){
        double a = getAmount();
        System.out.println(productName + "\t" + quantity + "\t" + unitPrice + "\t" + a);    
    }
}



class ShoppingCart{

    ArrayList<Item> items;
    public double discount = 0 ;
    public double tax = 0.14 ;
    public int flag = 0;

    ShoppingCart(){
        items = new ArrayList<Item>();
    }

    public void addToCart(Item item){
        items.add(item);
        if(flag == 1) {
            discount = (getTotalAmount()*0.1);
        }
        getPayableAmount();

    }

    public void removeFromCart(Item item) {
        items.remove(item);

    }

    public void printInvoice() {
        for(int i = 0; i < items.size() ; i++){
            items.get(i).getAll();
        }
        System.out.println("\t\t\t\tTotal:" + getTotalAmount());
        System.out.println("\t\t\t\tDisc%:" + discount);
        System.out.println("\t\t\t\tTax:"   + tax+"%");
        System.out.println("\t\t\t\tTotal:" + getPayableAmount());

    }

    public void applyCoupon(String name) {
        double couponAmount,t;
        
        if(name.equals("IND10")){
            discount = (getTotalAmount()*0.1);
            flag = 1;
        }
       
    }

    public double getTotalAmount()  {
        double finalAmount = 0;
        double singleAmount= 0;
        for(int i = 0; i  < items.size(); i++){
            singleAmount = items.get(i).getAmount();
            finalAmount += singleAmount;
        }
        return finalAmount;
    }

    public double getPayableAmount() {
        double total = getTotalAmount() - discount;
        System.out.println(tax*total);
        tax = 0.14;
        total = total+ (tax*total);
        return total;
    }

    public void showCart() {
        for(int i = 0; i < items.size(); i++){
            items.get(i).getAllCart();
        }
    }

}


public class ShoppingCartTest{

  public static void main(String[] args){

    Item i1 = new Item("Olive Oil 1l", 3, 100.0);
    Item i2 = new Item("Cheese Slices", 2, 50.0);
    Item i3 = new Item("Bread", 1, 75.0);
    Item i4 = new Item("Eggs\t", 50, 10.0);
    Item i5 = new Item("Chicken Salami", 2, 100.0);
    
    ShoppingCart cart = new ShoppingCart();
    

    cart.addToCart(i1);
    cart.addToCart(i2);
    cart.addToCart(i3);
    cart.addToCart(i4);
    cart.addToCart(i5);
    
    cart.showCart();
    
    cart.removeFromCart(i3);    
   
    cart.showCart();

    
    double totalAmount = cart.getTotalAmount();
    System.out.println(totalAmount);

    
    double payableAmount = cart.getPayableAmount();
    System.out.println(payableAmount);    

  
    cart.applyCoupon("IND50");
   
    cart.printInvoice();

    cart.applyCoupon("IND10");

   
    cart.printInvoice();

    cart.addToCart(new Item("Milk\t", 5, 30.00)); 
    cart.applyCoupon("IND10");
    
    cart.printInvoice();
  }
}
