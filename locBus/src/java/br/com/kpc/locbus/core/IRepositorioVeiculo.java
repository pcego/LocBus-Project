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
public interface IRepositorioVeiculo extends IRepositorio<Veiculo> {

    List<Veiculo> listaTodos();

    List<Veiculo> listaPorEmpresa(Empresa empresa);

    List<Veiculo> listaVeiculoPorImei(String imei);

    List<Veiculo> listaVeiculosPorLinha(Linha linha);
}
