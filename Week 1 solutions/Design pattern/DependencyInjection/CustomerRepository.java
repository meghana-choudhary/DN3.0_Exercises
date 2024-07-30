public interface CustomerRepository {
    Customer findCustomerById(int id);
    void addCustomers(Customer customer);
}