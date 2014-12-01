import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.ConsoleAppender
import org.springframework.core.env.StandardEnvironment

import static ch.qos.logback.classic.Level.*
import static demo.DemoProfiles.DEVELOPMENT

def applicationLogLevel = INFO
def frameworkLogLevel = INFO
def appenders = ['console']

def environment = new StandardEnvironment()
if(!environment.activeProfiles) {
    environment.activeProfiles = [DEVELOPMENT]
}

if(environment.acceptsProfiles(DEVELOPMENT)) {
    applicationLogLevel = DEBUG
}

appender("console", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%-5level %d{HH:mm:ss} [%thread] %logger{36} - %msg%n"
    }
    filter(ThresholdFilter) {
        level = DEBUG
    }
}

logger("demo", applicationLogLevel, appenders, false)

logger("org.springframework", frameworkLogLevel, appenders, false)
logger("org.springframework.web", DEBUG, appenders, false)
logger("org.thymeleaf", frameworkLogLevel, appenders, false)
logger("org.thymeleaf.TemplateRepository", DEBUG, appenders, false)

root(WARN, appenders)