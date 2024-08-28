@file:Suppress("ktlint")
package gg.jte.generated.ondemand.de.tschuehly.hyperspring.demo.ui
@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class JteExampleComponentGenerated {
companion object {
	@JvmField val JTE_NAME = "de/tschuehly/hyperspring/demo/ui/ExampleComponent.kte"
	@JvmField val JTE_LINE_INFO = intArrayOf(0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,3,4,4,14,14,15,15,15,16,16,16,17,17,19,19,19,0,0,0,0,0)
	@JvmStatic fun render(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, exampleContext:de.tschuehly.hyperspring.demo.ui.ExampleComponent.ExampleContext) {
		jteOutput.writeContent("\n<script src=\"https://unpkg.com/htmx.org@2.0.2/dist/htmx.js\"></script>\n<div")
		val __jte_html_attribute_0 = exampleContext.contextId
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" id=\"")
			jteOutput.setContext("div", "id")
			jteOutput.writeUserContent(__jte_html_attribute_0)
			jteOutput.setContext("div", null)
			jteOutput.writeContent("\"")
		}
		jteOutput.writeContent(">\n    <form hx-post=\"/example\" ")
		jteOutput.writeUnsafeContent(exampleContext.contextForm)
		jteOutput.writeContent(">\n        <label>\n            Text\n            <input name=\"exampleText\" type=\"text\">\n        </label>\n        <button type=\"submit\">\n            Submit\n        </button>\n    </form>\n\n    ")
		for (example in  exampleContext.exampleRecordList) {
			jteOutput.writeContent("\n        ")
			jteOutput.setContext("div", null)
			jteOutput.writeUserContent(example.exampleText)
			jteOutput.writeContent("\n        ")
			jteOutput.setContext("div", null)
			jteOutput.writeUserContent(example.exampleDate?.toString())
			jteOutput.writeContent("\n    ")
		}
		jteOutput.writeContent("\n\n</div>")
	}
	@JvmStatic fun renderMap(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, params:Map<String, Any?>) {
		val exampleContext = params["exampleContext"] as de.tschuehly.hyperspring.demo.ui.ExampleComponent.ExampleContext
		render(jteOutput, jteHtmlInterceptor, exampleContext);
	}
}
}
