package br.aula.testes;

import br.aula.salario.modelo.Funcionario;

public class CriadorDeFolhaPagamento {
	private Funcionario funcionario;
	
	public CriadorDeFolhaPagamento para(String nome) {
		this.funcionario = new Funcionario();
		this.funcionario.setNome(nome);
		return this;
	}
	
	public CriadorDeFolhaPagamento queTrabalha(int qtdHorasTrabalhadas) {
		this.funcionario.setQtdHorasTrabalhadas(qtdHorasTrabalhadas);
		return this;
	}
	
	public CriadorDeFolhaPagamento queRecebePorHora(double valorHora) {
		this.funcionario.setValorHora(valorHora);
		return this;
	}
	
	public CriadorDeFolhaPagamento dependete(String nomeDependente) {
		this.funcionario.setDependente(nomeDependente);
		return this;
	}
	
	public Funcionario constroi() {
		return funcionario;
	}
}
