package local.saad.aoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class AocApplication

fun main(args: Array<String>) {
	runApplication<AocApplication>(*args)
}
