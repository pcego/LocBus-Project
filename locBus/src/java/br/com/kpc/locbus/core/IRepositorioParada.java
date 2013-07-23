/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.util.List;

/**
 *
 * @author César
 */
public interface IRepositorioParada extends IRepositorio<Parada> {

    List<Parada> listaTodas();

    List<Parada> paradasPorRua(Endereco end);
}
