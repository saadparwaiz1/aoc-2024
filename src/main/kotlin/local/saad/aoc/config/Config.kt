package local.saad.aoc.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "aoc")
class Config {
    lateinit var solutions: List<Solution>
}