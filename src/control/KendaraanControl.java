/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author jppjo
 */
import dao.KendaraanDAO;
import model.Kendaraan;

public class KendaraanControl {
     KendaraanDAO kDao = new KendaraanDAO();
    
    public String generateId()
    {
        return "K" + kDao.generateId();
    }
    
    public Kendaraan searchDataKendaraan(String id)
    {
        return kDao.search(id);
    }
    
    public void deleteDataKendaraan(String id)
    {
        kDao.delete(id);
    }

}
