package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Conta;

public class ContaTests {

	/**
	 * DESPOSITO
	 * <Deposito> deveria <aumentar> o saldo
	 * quando valor for <positivo>
	 * 
	 * AÇÃO deveria EFEITO [quando CENÁRIO]
	 * 
	 * CENÁRIO
	 * para cada deposito o titular recebera 2% do valor;
	 */
	
	@Test
	public void  depositDeveriaAumentarSaldoQuandoValorPositivo() {
		//Arrange
		double valorDeposito = 100.0;
		double esperado = 110.0;
		Conta conta = new Conta(1L, "1234", "Mirahy", 10.0);
		
		//Act
		conta.deposito(valorDeposito);
		
		//Assert
		Assertions.assertEquals(esperado, conta.getSaldo());
	}
	
	
	/**
	 * SAQUE
	 * <Saque> deveria <diminuir> o saldo
	 * quando valor for <positivo>
	 * 
	 * AÇÃO deveria EFEITO [quando CENÁRIO]
	 * 
	 * CENÁRIO
	 * para cada saque o titular tera o valor do saldo subtraído;
	 */
	
	
	@Test
	public void  saqueDeveriaDiminuirSaldoQuandoValorPositivo() {
		//Arrange
		double valorSaque = 50.0;
		double esperado = 100.0;
		Conta conta = new Conta(1L, "1234", "Mirahy", 150.0);
		
		//Act
		conta.saque(valorSaque);
		
		//Assert
		Assertions.assertEquals(esperado, conta.getSaldo());
	}
	
	@Test
	public void  saqueDeveriaLançarExecao() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			
			Conta conta = new Conta(1L, "1234", "Mirahy", 150.0);
			conta.saque(250.0);
			
		});
	}
	
	@Test
	public void saqueValorTotalDeveriaRetornarSaldoZero(){
		double esperado = 0.0;
		double saldoInicial = 250.0;
		Conta conta = new Conta(1L, "1234", "Mirahy", saldoInicial);
		
		double resultado = conta.saqueValorTotal();
		
		Assertions.assertTrue(esperado == conta.getSaldo());
		Assertions.assertTrue(saldoInicial == resultado);
	}
}


