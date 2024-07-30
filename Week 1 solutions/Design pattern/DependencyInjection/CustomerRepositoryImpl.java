import java.util.ArrayList;

public class CustomerRepositoryImpl implements CustomerRepository {
    ArrayList<Customer> customers;
    CustomerRepositoryImpl(){
        customers = new ArrayList<>();
    }
    public Customer findCustomerById(int id) {
        int n = customers.size();
        for(int i=0; i<n; i++){
            if(customers.get(i).getId() == id){
                return customers.get(i);
            }
        }
        return null;
    }
    public void addCustomers(Customer cust){
        customers.add(cust);
    }
}