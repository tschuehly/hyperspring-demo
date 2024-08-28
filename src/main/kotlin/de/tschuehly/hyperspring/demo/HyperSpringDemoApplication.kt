package de.tschuehly.hyperspring.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HyperSpringDemoApplication

fun main(args: Array<String>) {
	runApplication<HyperSpringDemoApplication>(*args)
}
