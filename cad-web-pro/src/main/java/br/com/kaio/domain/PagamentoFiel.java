package br.com.kaio.domain;

import java.util.Date;

public class PagamentoFiel {
	String nomeFiel;
	String cpf;
	Date dataPagamento;
	double valor;
	boolean pago;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PagamentoFiel() {
		super();

	}

	public PagamentoFiel(String nomeFiel, String cpf, Date dataPagamento, double valor, boolean pago) {
		super();
		this.nomeFiel = nomeFiel;
		this.cpf = cpf;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.pago = pago;
	}

	public String getNomeFiel() {
		return nomeFiel;
	}

	public void setNomeFiel(String nomeFiel) {
		this.nomeFiel = nomeFiel;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
}
