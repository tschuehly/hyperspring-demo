package de.tschuehly.hyperspring.demo.ui;

import de.tschuehly.hyperspring.demo.hyper.HyperContext
import de.tschuehly.hyperspring.demo.hyper.HyperView
import de.tschuehly.spring.viewcomponent.kte.ViewContext
import org.jooq.DSLContext
import org.jooq.generated.Tables.TODO
import org.jooq.generated.tables.records.TodoRecord
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@HyperView
class ExampleComponent(private val sql: DSLContext) {
    data class ExampleContext(val todoList: List<TodoRecord>) : HyperContext()

    @GetMapping("/")
    fun render(): ViewContext {
        val exampleRecordList = sql.selectFrom(TODO).fetchArray().toList()
        return ExampleContext(exampleRecordList)
    }

    data class CreateTodoForm(val todo: String )

    @PostMapping("/todo")
    fun createTodo(createTodoForm: CreateTodoForm): ViewContext {
        sql.newRecord(TODO).apply {
            todoText = createTodoForm.todo
            store()
        }
        return render()
    }
    @PostMapping("/todo/{id}/complete")
    fun completeTodo(@PathVariable id: Long): ViewContext {
        sql.update(TODO).set(TODO.COMPLETED, true).where(TODO.ID.eq(id)).execute();
        return render()
    }
}
