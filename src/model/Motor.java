/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jppjo
 */
public class Motor extends Kendaraan{
    private int jumlah_tak;
    
    public Motor(int jumlah_tak, String nama, String jenis, float harga)
    {
        super(nama, "Motor", harga);
        this.jumlah_tak = jumlah_tak;
    }
    
    public Motor(int jumlah_tak, String id_kendaraan, String nama, String jenis, float harga)
    {
        super(id_kendaraan, nama, jenis, harga);
        this.jumlah_tak = jumlah_tak;
    }
    
    public int getJumlah_tak()
    {
        return jumlah_tak;
    }
    
    public String getString()
    {
        return super.getString() + " | " + jumlah_tak;
    }
    
    public String getSpecial()
    {
        return jumlah_tak+"";
    }

}
