package de.tschuehly.hyperspring.demo.hyper

import de.tschuehly.spring.viewcomponent.kte.ViewContext
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

open class HyperContext : ViewContext {
    val contextId: String
    val contextForm: String

    init {
        val requestContextId = getRequest()?.getHeader("_contextId")
        if (requestContextId != null) {
            contextId = requestContextId
            getResponse()?.setHeader("HX-Retarget", "#$requestContextId")
            getResponse()?.setHeader("HX-Reswap", "outerHTML")
        } else {
            contextId = "context-id-${UUID.randomUUID()}"
        }
        contextForm = """hx-headers='{"_contextId": "$contextId"}'"""
    }
}


private fun getRequest(): HttpServletRequest? {
    return (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)?.request
}


fun getResponse(): HttpServletResponse? {
    return (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)?.response
}
