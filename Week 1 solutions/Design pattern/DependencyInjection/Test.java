public class Test{
    public static void main(String[] args) {
        CustomerRepository custRepo = new CustomerRepositoryImpl();
        custRepo.addCustomers(new Customer(1, "Alice"));
        custRepo.addCustomers(new Customer(2, "Bob"));
        CustomerService customerService = new CustomerService(custRepo);

        Customer customer = customerService.getCustomerById(1);
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}