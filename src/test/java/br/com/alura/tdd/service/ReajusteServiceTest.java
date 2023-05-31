package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService reajusteService;
	private Funcionario func;

	@BeforeEach
	public void inicializar() {
		this.reajusteService = new ReajusteService();
		this.func = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1500.00"));
	}

	@Test
	void reajusteSalarioADesejar() {
		reajusteService.reajusteAnual(func, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1545.00"), func.getSalario());
	}

	@Test
	void reajusteSalarioBom() {
		reajusteService.reajusteAnual(func, Desempenho.BOM);
		assertEquals(new BigDecimal("1725.00"), func.getSalario());
	}

	@Test
	void reajusteSalarioOtimo() {
		reajusteService.reajusteAnual(func, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1800.00"), func.getSalario());
	}

}
