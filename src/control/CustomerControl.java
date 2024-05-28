/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author jppjo
 */
import model.Customer;
import dao.CustomerDAO;
import java.util.List;

public class CustomerControl {
    CustomerDAO cDao = new CustomerDAO();
    
    public void insertDataCustomer(Customer c)
    {
        cDao.insert(c);
    }
    
    public String showAllStringCustomer()
    {
        List<Customer> listC = cDao.showData(0);
        String customerString = "";
        int i = 0;
        
        for(Customer c : listC)
        {
            i++;
            customerString += c.getId_customer() +". " + c.getNama() + " | " + c.getAlamat() + " | " + c.getNo_telepon() + "\n";
        }
        return customerString;
    }
    
    public Customer searchCustomerById(int id_customer)
    {
        return cDao.search(id_customer);
    }
    
    public void updateDataCustomer(Customer c, int id_customer)
    {
        cDao.update(c, id_customer);
    }
    
    public void deleteDataCustomer(int id_customer)
    {
        cDao.delete(id_customer);
    }

}
