package be.pxl.ja;

import java.time.Duration;
import java.util.function.Function;

public class DurationCalculator {

	private Duration value = Duration.ZERO;

	// TODO implement generic method

	public void minus(Duration duration) {
		value = value.minus(duration);
	}

	public void plus(Duration duration) {
		value = value.plus(duration);
	}

	public Duration getResult() {
		return value;
	}

	public <T> void minus(T data, Function<T, Duration> converter) {
		Duration dataToDuration = converter.apply(data);
		minus(dataToDuration);
	}
}
