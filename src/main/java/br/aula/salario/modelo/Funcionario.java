package br.aula.salario.modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private int qtdHorasTrabalhadas;
	private double valorHora;
	private String nome;
	private List<String> dependentes = new ArrayList();
	
	public Funcionario(int qtdHorasTrabalhadas, double valorHora, String nome, List<String> dependentes) {
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
		this.valorHora = valorHora;
		this.nome = nome;
		this.dependentes = dependentes;
	}
	
	public Funcionario() {
		
	}
	
	public List<String> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<String> dependentes) {
		this.dependentes = dependentes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdHorasTrabalhadas() {
		return qtdHorasTrabalhadas;
	}

	public void setQtdHorasTrabalhadas(int qtdHorasTrabalhadas) {
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	public void setDependente(String nomeDependente) {
		this.dependentes.add(nomeDependente);
	}
}
