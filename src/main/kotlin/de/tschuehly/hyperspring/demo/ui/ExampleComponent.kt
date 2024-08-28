package de.tschuehly.hyperspring.demo.ui;

import de.tschuehly.hyperspring.demo.hyper.HyperContext
import de.tschuehly.hyperspring.demo.hyper.HyperView
import de.tschuehly.spring.viewcomponent.kte.ViewContext
import org.jooq.DSLContext
import org.jooq.generated.Tables.EXAMPLE
import org.jooq.generated.tables.records.ExampleRecord
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@HyperView
class ExampleComponent(private val sql: DSLContext) {
    data class ExampleContext(val exampleRecordList: List<ExampleRecord>) :
        HyperContext() {

    }

    @GetMapping("/")
    fun render(): ViewContext {
        val exampleRecordList = sql.selectFrom(EXAMPLE).fetchArray().toList()
        return ExampleContext(exampleRecordList)
    }

    data class ExampleCreateForm(
        val exampleText: String,
    )

    @PostMapping("/example")
    fun createExample(exampleCreateForm: ExampleCreateForm): ViewContext {
        sql.newRecord(EXAMPLE).apply {
            exampleText = exampleCreateForm.exampleText
            store()
        }
        return render()
    }
}
