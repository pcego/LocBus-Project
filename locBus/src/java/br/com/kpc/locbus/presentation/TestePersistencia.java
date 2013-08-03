/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.presentation;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioEmpresa;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public class TestePersistencia {

    public static void main(String[] args) throws NamingException {

        Context ctx = (Context) new InitialContext();
        IRepositorioEmpresa repo = (IRepositorioEmpresa) ctx.lookup("java:global/locBus/EmpresaDao");
        Empresa e = new Empresa();
        e.setNome("alprino");         
        
        repo.salvar(e);        
       
    }
}
