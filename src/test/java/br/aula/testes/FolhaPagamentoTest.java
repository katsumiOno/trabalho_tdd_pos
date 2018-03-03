package br.aula.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.aula.salario.modelo.Funcionario;
import br.aula.salario.servico.FolhaPagamento;

public class FolhaPagamentoTest {
	private FolhaPagamento folhaPagamento;
	private Funcionario funcionario1;
	private Funcionario funcionario2;
	private Funcionario funcionario3;
	private Funcionario funcionario4;
	private Funcionario funcionario5;
	private Funcionario funcionario6;
	private Funcionario funcionario7;
	
	@Before
	public void criaFolhaPagamento() {
		this.folhaPagamento = new FolhaPagamento();
		
		this.funcionario1 = new CriadorDeFolhaPagamento()
				.para("Marcio")
				.queRecebePorHora(24.5)
				.queTrabalha(8)
				.dependete("Luna")
				.dependete("Frida")
				.constroi();
		
		this.funcionario2 = new CriadorDeFolhaPagamento()
				.para("Helder")
				.queRecebePorHora(30)
				.queTrabalha(0)
				.constroi();
		
		this.funcionario3 = new CriadorDeFolhaPagamento()
				.para("Gabriel")
				.queRecebePorHora(0)
				.queTrabalha(10)
				.constroi();
		
		this.funcionario4 = new CriadorDeFolhaPagamento()
				.para("Samuel")
				.queRecebePorHora(1)
				.queTrabalha(-5)
				.dependete("Pongo")
				.constroi();
		
		this.funcionario5 = new CriadorDeFolhaPagamento()
				.para("Julio")
				.queRecebePorHora(-1)
				.queTrabalha(10)
				.dependete("Miah")
				.constroi();
		
		this.funcionario6 = new CriadorDeFolhaPagamento()
				.para("Clara")
				.queRecebePorHora(40)
				.queTrabalha(30)
				.dependete("Snoke")
				.dependete("Ivan")
				.constroi();
		
		this.funcionario7 = new CriadorDeFolhaPagamento()
				.para("Cardoso")
				.queRecebePorHora(20)
				.queTrabalha(30)
				.constroi();
	}
	
	@Test
	public void retornarSalarioBrutoVerdadeiro() {
		assertEquals(this.folhaPagamento.getSalarioBruto(this.funcionario1), 296, 0.0001);
	}
	
	@Test(expected = RuntimeException.class)
	public void retornaSalarioBrutoSemHorasTrabalhadasFalso() {
		this.folhaPagamento.getSalarioBruto(this.funcionario2);
	}
	
	@Test(expected = RuntimeException.class)
	public void retornaSalarioBrutoSemValorHoraFalso() {
		this.folhaPagamento.getSalarioBruto(this.funcionario3);
	}
	
	@Test(expected = RuntimeException.class)
	public void retornaSalarioBrutoComHorasTrabalhadasNegativaFalso() {
		this.folhaPagamento.getSalarioBruto(this.funcionario4);
	}
	
	@Test(expected = RuntimeException.class)
	public void retornaSalarioBrutoComValorHoraNegativaFalso() {
		this.folhaPagamento.getSalarioBruto(this.funcionario5);
	}
	
	@Test
	public void retornaDescontoINSSQuandoSalarioBrutoMenorOuIgualA1000() {
		assertEquals(this.folhaPagamento.getDescontoINSS(this.funcionario1), 25.16, 0.0001);
	}
	
	@Test
	public void retornaDescontoINSSQuandoSalarioBrutoMaiorQue1000() {
		assertEquals(this.folhaPagamento.getDescontoINSS(this.funcionario6), 117, 0.0001);
	}
	
	@Test
	public void retornaDescontoIRQuandoSalarioBrutoMenorOuIgualA500() {
		assertEquals(this.folhaPagamento.getDescontoIR(this.funcionario1), 0, 0.0001);
	}
	
	@Test
	public void retornaDescontoIRQuandoSalarioBrutoEntre500E1000() {
		assertEquals(this.folhaPagamento.getDescontoIR(this.funcionario7), 30, 0.0001);
	}
	
	@Test
	public void retornaDescontoIRQuandoSalarioBrutoMaiorQue1000() {
		assertEquals(this.folhaPagamento.getDescontoIR(this.funcionario6), 91, 0.0001);
	}
	
	@Test
	public void retornarSalarioLiquidoVerdadeiro() {
		assertEquals(this.folhaPagamento.getSalarioLiquido(this.funcionario6), 1092, 0.0001);
	}
}
