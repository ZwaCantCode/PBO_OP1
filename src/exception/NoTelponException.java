/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author jppjo
 */
public class NoTelponException extends Exception
{
    public String message()
    {
        return "No Telpon Hanya Boleh Terdiri Dari Angka / Diawali +";
    }

}
