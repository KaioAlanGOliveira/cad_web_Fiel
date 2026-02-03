package br.com.kaio.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Pagamento {

	private String cpf;
	private BigDecimal valor;
	private Date dataPagamento;
	private int id;
	private boolean pago;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valorDecimal) {
		this.valor = valorDecimal;
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

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Pagamento() {

		super();
	}

	public Pagamento(int id, BigDecimal valor, String cpf, Date dataPagamento, boolean pago) {
		super();
		this.id = id;
		this.valor = valor;
		this.cpf = cpf;
		this.dataPagamento = dataPagamento;
		this.pago = pago;
	}

}
