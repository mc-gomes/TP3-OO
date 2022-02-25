package pacoteDeTeste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.*;

class TesteValidacao {
	Validacao v = new Validacao();

	@Test
	void testValidacaoCPF() {
		assertTrue(v.validacaoCPF("55836412044"));
		assertFalse(v.validacaoCPF("123"));
		assertFalse(v.validacaoCPF("123.456.789-10"));
		assertFalse(v.validacaoCPF("123.567.901"));
		assertFalse(v.validacaoCPF("123abc456"));
	}

	@Test
	void testValidacaoData() {
		assertTrue(v.validacaoData("23/08/2020"));
		assertFalse(v.validacaoData("30"));
		assertFalse(v.validacaoData("1234567890"));
		assertFalse(v.validacaoData("2/3082/020"));
		assertFalse(v.validacaoData("23/0-2020"));
		assertFalse(v.validacaoData("23/08/1889"));
		assertFalse(v.validacaoData("32/08/2020"));
		assertFalse(v.validacaoData("25/13/2020"));
		assertFalse(v.validacaoData("25/08/2022"));
	}

	@Test
	void testValidacaoEstado() {
		assertTrue(v.validacaoEstado("DF"));
		assertFalse(v.validacaoEstado("df"));
		assertFalse(v.validacaoEstado("distrito federal"));
	}

}
