/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.presentation;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.Endereco;
import br.com.kpc.locbus.core.IRepositorioEmpresa;
import br.com.kpc.locbus.core.IRepositorioEndereco;
import br.com.kpc.locbus.core.IRepositorioLinha;
import br.com.kpc.locbus.core.IRepositorioParada;
import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.IRepositorioVeiculo;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Parada;
import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.core.Veiculo;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public class TestePersistencia {

    public static void main(String[] args) throws NamingException {

        //Declarando Context Geral
        Context ctx = (Context) new InitialContext();

        //--------------Parada
        IRepositorioParada repoParada = (IRepositorioParada) ctx.lookup("java:global/locBus/ParadaDao");
        Parada parada = new Parada();
        parada.setLongitude(-43.12345);
        parada.setLatitude(-16.98675);
        parada.setDescricao("PARADA DE TESTE");


        // --------------Endereço
        IRepositorioEndereco repoEnd = (IRepositorioEndereco) ctx.lookup("java:global/locBus/EnderecoDao");
        Endereco end = new Endereco();
        end.setCep("39400100");
        end.setRua("RUA SANTA MARIA");
        end.setBairro("TODOS OS SANTOS");
        end.setNumero(299);
        end.setParada(parada);

        repoEnd.salvar(end);

        //--------------Linha
        IRepositorioLinha repoLinha = (IRepositorioLinha) ctx.lookup("java:global/locBus/LinhaDao");
        Linha l = new Linha();
        l.setNumeroLinha(077);
        l.setTipoLinha("CIRCULAR");
        l.setPontoInicial("JK");
        l.setPontoFinal("RODOVIARIA");
        l.setHoraInicial("06:00");
        l.setHoraFinal("23:00");



        //--------------Empresa
        IRepositorioEmpresa repoEmpresa = (IRepositorioEmpresa) ctx.lookup("java:global/locBus/EmpresaDao");
        Empresa emp = new Empresa();
        emp.setNome("UNIAO");
        emp.setVeiculo(null);


        //--------------Veiculo
        IRepositorioVeiculo repoVeiculo = (IRepositorioVeiculo) ctx.lookup("java:global/locBus/VeiculoDao");
        Veiculo v = new Veiculo();
        v.setImei("123456789123");
        v.setDescricao("DESCRIÇÃO TESTE");
        v.setLinha(l);
        v.setEmpresa(emp);


        //--------------Posição
        IRepositorioPosicao repoPosicao = (IRepositorioPosicao) ctx.lookup("java:global/locBus/PosicaoDao");
        Posicao pos = new Posicao();
        pos.setLongitude(987643);
        pos.setLatitude(123456);
        pos.setVeiculo(v);
        repoPosicao.salvar(pos);



    }
}
