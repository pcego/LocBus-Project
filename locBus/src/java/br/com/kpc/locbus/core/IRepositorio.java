/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

/**
 *
 * @author César
 */
public interface IRepositorio<T> {

    public T abrir(Long obj) throws Exception;

    public boolean salvar(T obj);

    public boolean apagar(T obj);

    public boolean atualizar(T obj);
}
