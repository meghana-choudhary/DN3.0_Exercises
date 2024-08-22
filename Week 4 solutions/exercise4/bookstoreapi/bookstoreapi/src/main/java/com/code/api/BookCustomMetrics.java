package com.code.api;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

public class BookCustomMetrics {
	

	public BookCustomMetrics(MeterRegistry registry) {
		//add custom
		 registry.counter("book.creation.counter", "type", "book");
	}

	
}
