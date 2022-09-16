package entities;

public class Conta {
	private Long id;
	private String numero;
	private String titular;
	private Double saldo;
	
	
	public Conta() {
		
	}

	public Conta(Long id, String numero, String titular, Double saldo) {
		this.id = id;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public Double getSaldo() {
		return saldo;
	}


// 	O saldo sera atualizado em metodos especificos
//	como deposito, saque e transferencia
//	public void setSaldo(Double saldo) {
//		this.saldo = saldo;
//	}
	
	public void deposito(double valor) {
		
		if(valor > 0) {
			saldo += valor;
		}
		
	}
	
	public void saque(double valor) {
		if(valor > saldo) {
			throw new IllegalArgumentException("O saque é maior quue o saldo");
		}
		saldo -= valor;
	}
	
	public double saqueValorTotal() {
		double aux = saldo;
		saldo = 0.0;
		return aux;
	}
	
	public void transferencia(double valor, Conta conta) {
		
		conta.deposito(valor);
	}
	
}
