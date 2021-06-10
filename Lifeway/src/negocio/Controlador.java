package negocio;

import java.time.LocalDate;

import negocio.beans.Bandeira;
import negocio.beans.Cliente;
import negocio.beans.Consumidor;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.Funcionario;
import negocio.beans.TipoConsumidor;

public class Controlador {
    
    private static Controlador instance;

    private ControladorEmpresas controladorEmpresas;
    private ControladorFuncionarios controladorFuncionarios;
    private ControladorConsumidores controladorConsumidores;
    private ControladorContas controladorContas;
    private ControladorClientes controladorClientes;

    private Controlador() {
        //construtor privado
        this.controladorEmpresas = ControladorEmpresas.getInstance();
        /* this.controladorFuncionarios = controladorFuncionarios.getInstance();
        this.controladorContas = controladorContas.getInstance();
        this.controladorConsumidores = controladorConsumidores.getInstance(); */
        this.controladorClientes = ControladorClientes.getInstance();
    }

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }




    public Cliente criarCliente(String nome, String cpf, LocalDate dataNascimento){
        return this.controladorClientes.criarCliente(nome, cpf, dataNascimento);
    }

    public void removerCliente(String cpf){
        this.controladorClientes.removerCliente(cpf);
    }

    public Consumidor adicionarConsumidorAoCliente(String cpfCliente, String idEmpresa, String numMedidor, TipoConsumidor tipo, Endereco endereco){
        return this.controladorClientes.adicionarConsumidorAoCliente(cpfCliente, idEmpresa, numMedidor, tipo, endereco);
    }

    public void removerConsumidorDoCliente(String idCliente, String numMedidor){
        this.controladorClientes.removerConsumidorDoCliente(idCliente, numMedidor);
    }


    public Empresa criarEmpresa(String idEmpresa, String nome, String servico) {
        return this.controladorEmpresas.criarEmpresa(idEmpresa, nome, servico);
    }

    public void removerEmpresa(String idEmpresa){
        this.controladorEmpresas.removerEmpresa(idEmpresa);
    }

    public Funcionario criarFuncionarioNaEmpresa(String empresa, String cpf, String nome, LocalDate dataNascimento, String cargo) {
        return this.controladorEmpresas.criarFuncionarioNaEmpresa(empresa, cpf, nome, dataNascimento, cargo);
    }

    public void removerFuncionarioNaEmpresa(String idEmpresa, String idFuncionario) {
        this.controladorEmpresas.removerFuncionarioNaEmpresa(idEmpresa, idFuncionario);
    }


    public void adicionarTaxaFixaPorTipoNaEmpresa(String idEmpresa, TipoConsumidor tipo, double taxaFixa){
        this.controladorEmpresas.adicionarTaxaFixaPorTipoNaEmpresa(idEmpresa, tipo, taxaFixa);
    }

    public void adicionarTaxaAdicionalPorTipoNaEmpresa(String idEmpresa, TipoConsumidor tipo, double de, double ate, double valor){
        this.controladorEmpresas.adicionarTaxaAdicionalPorTipoNaEmpresa(idEmpresa, tipo, de, ate, valor);
    }

    public void adicionarTarifaNaEmpresa(String idEmpresa, String nomeTarifa, Double valor){
        this.controladorEmpresas.adicionarTarifaNaEmpresa(idEmpresa, nomeTarifa, valor);
    }
    
    public void definirBandeiraDaEmpresa(String idEmpresa, Bandeira bandeira, float valor){
        this.controladorEmpresas.definirBandeiraDaEmpresa(idEmpresa, bandeira, valor);
    }

    public void adicionarTaxaDoTipoNaEmpresa(String idEmpresa, TipoConsumidor tipo){
        this.controladorEmpresas.adicionarTaxaDoTipoNaEmpresa(idEmpresa, tipo);
    }

    

}
