public class OrderSorter {

    public static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void display() {
            System.out.println("Order ID: " + orderId + ", Customer Name: " + customerName + ", Total Price: " + totalPrice);
        }
    }

    // Bubble Sort 
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                   
                }
            }
        }
    }

    // Quick Sort 
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = new Order[] {
            new Order("1", "A", 250.75),
            new Order("2", "B", 150.50),
            new Order("3", "C", 300.00),
            new Order("4", "D", 100.25),
            new Order("5", "E", 175.00)
        };

        System.out.println("Original Orders:");
        for (Order order : orders) {
            order.display();
        }

        Order[] bubbleSortedOrders = orders.clone();
        bubbleSort(bubbleSortedOrders);
        System.out.println("\nBubble Sorted Orders:");
        for (Order order : bubbleSortedOrders) {
            order.display();
        }

        Order[] quickSortedOrders = orders.clone();
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sorted Orders:");
        for (Order order : quickSortedOrders) {
            order.display();
        }
    }
}
