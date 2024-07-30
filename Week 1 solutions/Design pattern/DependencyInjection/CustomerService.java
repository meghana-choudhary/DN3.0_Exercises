public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository custRepo) {
        this.customerRepository = custRepo;
    }
    public Customer getCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}