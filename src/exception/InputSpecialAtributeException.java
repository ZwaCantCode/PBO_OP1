/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author jppjo
 */
public class InputSpecialAtributeException extends Exception{
        public String message(String jenis)
    {
        return "Atribut Tidak Sesuai Untuk Jenis " + jenis;
    }

}
