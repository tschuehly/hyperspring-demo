package de.tschuehly.hyperspring.demo

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<HyperSpringDemoApplication>().with(TestcontainersConfiguration::class).run(*args)
}
