package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaTestarBonusSalarioMenorQue10000() {

		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Alex", LocalDate.now(), new BigDecimal("5000")));

		assertEquals(new BigDecimal("500.00"), bonus);

	}

	
	@Test
	void deveriaTestarBonusSalarioIgual10000() {

		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService
				.calcularBonus(new Funcionario("Alex", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);

	}
	
	@Test
	void deveriaTestarBonusSalarioMaior10000() {

		BonusService bonusService = new BonusService();		

		assertThrows(IllegalArgumentException.class, () -> bonusService.
				calcularBonus(new Funcionario("Alex", LocalDate.now(), new BigDecimal("10500"))));

	}

}
