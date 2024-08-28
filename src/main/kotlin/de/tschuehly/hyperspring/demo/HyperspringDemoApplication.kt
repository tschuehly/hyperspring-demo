package de.tschuehly.hyperspring.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HyperspringDemoApplication

fun main(args: Array<String>) {
	runApplication<HyperspringDemoApplication>(*args)
}
