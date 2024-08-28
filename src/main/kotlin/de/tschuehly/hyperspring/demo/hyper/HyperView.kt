package de.tschuehly.hyperspring.demo.hyper

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import org.springframework.stereotype.Controller

@Target( AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ViewComponent
@Controller
annotation class HyperView()
