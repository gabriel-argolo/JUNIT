package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {


	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();

		//		assertThrows(IllegalArgumentException.class, ()
		//				-> service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(),
		//						new BigDecimal("25000"))));

		try {
			service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("25000")));
			fail("Nao ocorreu Exception");
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("Funcionario com Salario Mario do que R$10.000,00", e.getMessage());
		}

	}


	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus  = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("2500")));

		Assertions.assertEquals(new BigDecimal("250.00"), bonus); 
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDe1000() {
		BonusService service = new BonusService();
		BigDecimal bonus  = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("10000")));

		Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
