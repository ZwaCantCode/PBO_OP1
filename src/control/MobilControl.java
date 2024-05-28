/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author jppjo
 */

import dao.MobilDAO;
import java.util.List;
import model.Kendaraan;
import model.Mobil;

public class MobilControl {
      MobilDAO mDao = new MobilDAO();
    
    public void insertDataKendaraan(Mobil K)
    {
        K.setId_kendaraan("K" + mDao.generateId());
        mDao.insert(K);
    }
    
    public String showStringKendaraan()
    {
        List<Kendaraan> listK = mDao.showData("Mobil");
        String kendaraanString = "";
        for(Kendaraan k : listK)
        {
            kendaraanString += k.getString() + "\n";
        }
        return kendaraanString;
    }
    
    public void updateDataKendaraan(Mobil K)
    {
        mDao.update(K, K.getId_kendaraan(), K.getJenis_mesin());
    }

}
