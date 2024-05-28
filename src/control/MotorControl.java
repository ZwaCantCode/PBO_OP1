/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author jppjo
 */
import dao.MotorDAO;
import java.util.List;
import model.Kendaraan;
import model.Motor;

public class MotorControl {
      MotorDAO mDao = new MotorDAO();
    
    public void insertDataKendaraan(Motor mtr)
    {
        mtr.setId_kendaraan("K" + mDao.generateId());
        mDao.insert(mtr);
    }
    
    public String showStringKendaraan()
    {
        List<Kendaraan> listK = mDao.showData("Motor");
        String kendaraanString = "";
        for(Kendaraan k : listK)
        {
            kendaraanString += k.getString() + "\n";
        }
        return kendaraanString;
    }
    
    public void updateDataKendaraan(Motor K)
    {
        System.out.println(K.getJumlah_tak());
        mDao.update(K, K.getId_kendaraan(), K.getJumlah_tak());
    }

}
