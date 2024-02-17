package com.tester

import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TesterApplication {

fun main(args: Array<String>) {
	runApplication<TesterApplication>(*args)
}
	@Bean
	fun openTelemetry(): OpenTelemetry {
		return AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
	}
}
