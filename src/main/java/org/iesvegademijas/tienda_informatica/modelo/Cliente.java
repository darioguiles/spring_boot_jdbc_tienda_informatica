package org.iesvegademijas.tienda_informatica.modelo;
import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class Cliente {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private int categoria;

}
