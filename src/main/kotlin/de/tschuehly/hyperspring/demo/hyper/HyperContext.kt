package de.tschuehly.hyperspring.demo.hyper

import de.tschuehly.spring.viewcomponent.kte.ViewContext
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

open class HyperContext : ViewContext {
    val hyperId: String
    val hyperForm: String

    init {
        val requestContextId = getRequest()?.getHeader("_contextId")
        if (requestContextId != null) {
            hyperId = requestContextId
            getResponse()?.setHeader("HX-Retarget", "#$requestContextId")
            getResponse()?.setHeader("HX-Reswap", "outerHTML")
        } else {
            hyperId = "context-id-${UUID.randomUUID()}"
        }
        hyperForm = """hx-headers='{"_contextId": "$hyperId"}'"""
    }
}


private fun getRequest(): HttpServletRequest? {
    return (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)?.request
}


fun getResponse(): HttpServletResponse? {
    return (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)?.response
}
