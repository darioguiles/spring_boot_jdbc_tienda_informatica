package org.iesvegademijas.tienda_informatica.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Pedido {

    private int id;
    private double total;
    private Date fecha;
    private int id_cliente;
    private int id_comercial;


}
