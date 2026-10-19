package com.pricewise

import org.flywaydb.core.Flyway
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.postgresql.PostgreSQLContainer
import kotlin.test.assertEquals

@SpringBootTest
@Testcontainers
class PricewiseApplicationTests {
	companion object{
		@JvmField
		@Container
		@ServiceConnection
		val postgresql = PostgreSQLContainer("postgres:16-alpine")
	}

	@Autowired
	lateinit var flyway: Flyway

	@Test
	fun contextLoads() {
		val applied = flyway.info().applied()
		assertEquals(1, applied.size)
		assertEquals("1", applied.first().version.version)
	}
}
