/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author César
 */
@Remote
public interface IRepositorioVeiculo extends IRepositorio<Veiculo> {

    List<Veiculo> listaTodos();

    List<Veiculo> listaPorEmpresa(Empresa empresa);

    Veiculo listaVeiculoPorImei(String imei);

    List<Veiculo> listaVeiculosPorLinha(Linha linha);
}
