/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.IRepositorioLinha;
import br.com.kpc.locbus.core.Linha;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author César
 */
@Stateless
public class LinhaDao extends DaoGenerico<Linha> implements IRepositorioLinha {

    public LinhaDao() {
        super(Linha.class);
    }

    @Override
    public List<Linha> findAll() {

        Query consulta = getManager().createQuery("select l from Linha l order by l.numeroLinha");
        return consulta.getResultList();

    }

    @Override
    public List<Linha> getByParada(String descricao) {
        final String sql;
        sql = "select *from linhas as l join paradas_linhas as pl on "
                + "l.codigo_linha = pl.linha_id join paradas as p on "
                + "p.codigo_parada = pl.parada_id where p.descricao = " +"'" + descricao + "'" + " AND p.status = true;";
        Query consulta = getManager().createNativeQuery(sql, Linha.class);
        return consulta.getResultList();
    }

    @Override
    public List<Linha> listaLinhasPorEmpresa(String nome) {

        Query consulta = getManager().createQuery("select l from Linha l JOIN Veiculo v on l.veiculo = v.linha_id "
                + "JOIN Empresa e on e.veiculo = v.empresa_id where e.nome LIKE :nome AND l.status = true");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
}
