package br.com.tdd.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		//assertThrows(IllegalArgumentException.class,
			//	() -> service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("25000"))));

		try {
			service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior que 10.000 nao recebe bonus", e.getMessage());
		}
	}

	@Test
	void bonusDeveriaSer10PorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);

	}

	@Test
	void bonusDeveriaSer10PorcentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gabriel", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);

	}
}
