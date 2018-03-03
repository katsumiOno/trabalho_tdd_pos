package br.aula.salario.servico;

import br.aula.salario.modelo.Funcionario;

public class FolhaPagamento {
	public int getNumeroDependentes(Funcionario funcionario) {
		return funcionario.getDependentes().size();
	}
	
	public double getSalarioBruto(Funcionario funcionario) {
		if (funcionario.getQtdHorasTrabalhadas() <= 0)
			throw new RuntimeException("Não é possível calcular Salario Bruto sem Horas trabalhadas");
		
		if (funcionario.getValorHora() <= 0)
			throw new RuntimeException("Não é possível calcular Salario Bruto sem Valor por hora");
		
		return funcionario.getQtdHorasTrabalhadas() * funcionario.getValorHora()
				+ (50 * this.getNumeroDependentes(funcionario));
	}

	public double getDescontoINSS(Funcionario funcionario) {
		double salarioBruto = this.getSalarioBruto(funcionario);
		
		if (salarioBruto <= 1000) {
			return salarioBruto * 8.5 / 100;
		} else {
			return salarioBruto * 9 / 100;
		}
	}

	public double getDescontoIR(Funcionario funcionario) {
		double salarioBruto = this.getSalarioBruto(funcionario);

		if (salarioBruto <= 500) {
			return 0;
		} else if (salarioBruto > 500 && salarioBruto <= 1000) {
			return salarioBruto * 5 / 100;
		} else {
			return salarioBruto * 7 / 100;
		}
	}

	public double getSalarioLiquido(Funcionario funcionario) {
		return this.getSalarioBruto(funcionario) - this.getDescontoINSS(funcionario) - this.getDescontoIR(funcionario);
	}
}
