package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest {

	static Calc calc = null;

	@BeforeAll
	static void テスト前処理() {
		calc = new Calc();
	}

	@Test
	void addテスト_正常() {
		assertEquals(calc.add(1, 3), 4);
		assertThat(calc.add(1, 3)).isEqualTo(4);
	}

	@AfterAll
	static void テスト後処理() {
		calc = null;
	}

	@Test
	void Calcクラスsdm_正常() {
		assertEquals(calc.sub(4, 2), 2);
		assertThat(calc.div(4, 2)).isEqualTo(2);
		assertThat(calc.mul(4, 2)).isEqualTo(8);
	}

	@Test
	void CalcクラスThrownBy_異常() {
		assertThatThrownBy(() -> {
			calc.div(4, 0);
		}).isInstanceOf(ArithmeticException.class).hasMessageContaining("/ by zero");

	}

	@Test
	void CalcクラスExceptionOfType_異常() {
		assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
			calc.div(4, 0);
		})
				// エラーメッセージに特定の文字列が含まれるか）
				.withMessageContaining("/ by zero");
	}

	@Test
	void 分離処理() {
		// when
		Throwable thrown = catchThrowable(() -> {

			calc.div(4, 0);

		});

		// then
		assertThat(thrown).isInstanceOf(ArithmeticException.class).hasMessageContaining("/ by zero");

	}

	// 課題２
	@Test
	void kadai2() {
		assertThat(calc.div(5, 0)).isEqualTo(0);

	}

}
