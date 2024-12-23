package com.mozi.great_number;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mozi.great_number.GreatNumberApplication.calculateGreatString;
import static org.assertj.core.api.Assertions.assertThat;

class GreatNumberApplicationTests {

	@Test
	void contextLoads() {
		assertThat(calculateGreatString("12223")).isEqualTo(222);
		assertThat(calculateGreatString("111999333")).isEqualTo(999);
		assertThat(calculateGreatString("123")).isEqualTo(-1);
		assertThat(calculateGreatString("12")).isEqualTo(-1);
	}

}
