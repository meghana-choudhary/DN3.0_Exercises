
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Product {
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

    public void display(){
        System.out.println("Product ID = " + productId + ", Name = " + productName + ", Quantity = " + quantity + ", Price = " + price);
    }
}

public class Searching {
    private ArrayList<Product> products;
    private Scanner sc;

    public Searching() {
        products = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void display(){
        System.out.println("Inventory Status");
        if(products.isEmpty()){
            System.out.println("No items in inventory!");
        } else {
            for (Product product : products) {
                product.display();
            }
        } 
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void lsearch(){
        System.out.println("Enter product id to be searched");
        String key = sc.nextLine();
        boolean found = false;
        for (Product product : products) {
            if (product.getProductId().equals(key)) {
                found = true;
                product.display();
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public void bsearch(){
        System.out.println("Enter product id to be searched");
        String key = sc.nextLine();

        
        Collections.sort(products, Comparator.comparing(Product::getProductId));

        int left = 0;
        int right = products.size() - 1;
        boolean found = false;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = products.get(mid);
            int cmp = midProduct.getProductId().compareTo(key);

            if (cmp == 0) {
                found = true;
                midProduct.display();
                break;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
    }

    public static void main(String[] args) {
        Searching inventory = new Searching();

     
        inventory.addProduct(new Product("1", "Product A", 10, 20.5));
        inventory.addProduct(new Product("2", "Product B", 15, 30.0));
        inventory.addProduct(new Product("3", "Product C", 5, 12.0));
        inventory.addProduct(new Product("4", "Product D", 8, 25.0));

      
        inventory.display();

        
        System.out.println("\nLinear Search:");
        inventory.lsearch();

        
        System.out.println("\nBinary Search:");
        inventory.bsearch();
    }
}
