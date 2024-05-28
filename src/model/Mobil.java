/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jppjo
 */
public class Mobil extends Kendaraan{
    private String jenis_mesin;
    
    public Mobil(String jenis_mesin, String nama, String jenis, float harga)
    {
        super(nama, "Mobil", harga);
        this.jenis_mesin = jenis_mesin;
    }
    
    public Mobil(String jenis_mesin, String id_kendaraan, String nama, String jenis, float harga)
    {
        super(id_kendaraan, nama, "Mobil", harga);
        this.jenis_mesin = jenis_mesin;
    }
    
    public String getJenis_mesin()
    {
        return jenis_mesin;
    }
    
    public String getString()
    {
        return super.getString() + " | " + jenis_mesin;
    }
    
    public String getSpecial()
    {
        return jenis_mesin;
    }
    
    
}
