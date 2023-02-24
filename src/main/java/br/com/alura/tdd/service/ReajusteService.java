package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		// TODO Auto-generated method stub
			BigDecimal perc = desempenho.PercentualReajuste();
			BigDecimal reajuste = funcionario.getSalario().multiply(perc);
			funcionario.ReajustarSalario(reajuste);
		
	}

}
