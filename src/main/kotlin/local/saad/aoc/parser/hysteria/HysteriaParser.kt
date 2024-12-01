package local.saad.aoc.parser.hysteria

import local.saad.aoc.models.InputType
import local.saad.aoc.models.hysteria.Hysteria
import local.saad.aoc.parser.Parser
import org.springframework.stereotype.Component

@Component
class HysteriaParser : Parser {

    override val parserType = InputType.Hysteria;

    override fun parse(lines: List<String>): List<Hysteria> {
        return lines.map { line ->
            val (left, right) = line.split("\\s+".toRegex())
            Hysteria(left.toInt(), right.toInt())
        }
    }
}