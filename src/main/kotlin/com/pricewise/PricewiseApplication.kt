package com.pricewise

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PricewiseApplication

fun main(args: Array<String>) {
	runApplication<PricewiseApplication>(*args)
}
