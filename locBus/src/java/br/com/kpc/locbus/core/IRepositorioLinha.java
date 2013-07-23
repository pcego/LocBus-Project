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
public interface IRepositorioLinha extends IRepositorio<Linha> {

    List<Linha> listaTodos();

    List<Linha> listaPorParada(Parada parada);

    List<Linha> listaLinhasPorEmpresa(Empresa empresa);
}
