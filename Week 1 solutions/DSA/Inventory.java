package week1;
import java.util.ArrayList;
import java.util.Scanner;

class Product{
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display(){
        System.out.println("\nProduct ID = "+productId+" "+"Name = "+productName+" "+ "Quantity = "+quantity+" "+"Price = "+price);
    }

}
class Inventory{
    private ArrayList<Product> products;
    
    public Inventory(){
        products = new ArrayList<Product>();
    }
    

    public void display(){
        System.out.println("Inventory Status");
        if(products.size()==0){
            System.out.println("No items in inventory!");
        }
        else{
        for (Product product : products) {
            product.display();
        }
    } 
    }

    public void add(Product product){
        products.add(product);
    }

    public void delete(String productId){
        for(int i = 0; i<products.size();i++){
            if(products.get(i).getProductId()==productId){
                products.remove(i);
                break;
            }
        }
    }

    public void update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getProductId().equals(updatedProduct.getProductId())) {
                product.setProductName(updatedProduct.getProductName());
                product.setQuantity(updatedProduct.getQuantity());
                product.setPrice(updatedProduct.getPrice());
                break;
            }
        }
    }


public static void main(String[] args) {
    Inventory inventory = new Inventory();
    Scanner sc = new Scanner(System.in);
    while(true){
        System.out.println("Press 1 to add items\nPress 2 to remove items\n Press 3 to update items\n Press 4 to display items\n Press 5 to exit");
        int input = sc.nextInt();
        sc.nextLine(); 
        switch(input){
            case 1:
            System.out.println("Add items");
            System.out.println("Enter product id, name, quantity and price");
            String id = sc.nextLine();
            String name = sc.nextLine();
            int qty = sc.nextInt();
            double price = sc.nextDouble();
            sc.nextLine();  
            inventory.add(new Product(id, name, qty, price));
            break;
        case 2:
            System.out.println("Enter id of product to be deleted");
            String pid = sc.nextLine();
            inventory.delete(pid);
            break;
        case 3:
            System.out.println("Enter product details to update");
            String p_id = sc.nextLine();
            String pname = sc.nextLine();
            int pqty = sc.nextInt();
            double p_price = sc.nextDouble();
            sc.nextLine();  
            inventory.update(new Product(p_id, pname, pqty, p_price));
            break;
        case 4:
            inventory.display();
            break;
        case 5:
            System.out.println("Exiting...");
            sc.close();
            return;
        default:
            System.out.println("Invalid input. Please try again.");
            break;
            

        }
    }



  }
}