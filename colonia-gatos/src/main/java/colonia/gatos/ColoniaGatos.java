/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package colonia.gatos;

/**
 *
 * @author ms_ma
 */
public class ColoniaGatos {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de la colonia de gatos");
        
        Usuario u1 = new Usuario(1, "Juan", "correo@correo.com", "conTrasenia");
        System.out.println("El usuario u1 tiene el id " + u1.verId()+ " y el nombre es " + u1.verNombre());
    }
}
