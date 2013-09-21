/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioEmpresa;
import br.com.kpc.locbus.servico.ContextoInicial;
import br.com.kpc.locbus.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public abstract class EmpresaFacade extends DaoGenerico<Empresa> implements IRepositorioEmpresa {

    private IRepositorioEmpresa rp;
    private List<Empresa> lst = new ArrayList<Empresa>();

    public EmpresaFacade() {
        super(Empresa.class);
    }

    public List<Empresa> listaTodos() throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioEmpresa) ContextoInicial.getContext().lookup("java:global/locBus/EmpresaDao");
            lst = rp.listaTodas();

        } catch (NamingException ex) {
            Log.debug(EmpresaFacade.class.getName() + " Falha método listaTodos()");
            return null;
        }

        return lst;

    }
}
