package local.saad.aoc.solver.hysteria

import local.saad.aoc.exceptions.AocException
import local.saad.aoc.models.Answer
import local.saad.aoc.models.Input
import local.saad.aoc.models.InputType
import local.saad.aoc.models.hysteria.Hysteria
import local.saad.aoc.solver.Solver
import org.springframework.stereotype.Component
import kotlin.math.abs

@Component
class HysteriaSolver: Solver {
    override val solverType: InputType = InputType.Hysteria

    override fun solve(input: List<Input>): Answer {
        val left = extracted(input, Hysteria::left)
        val right = extracted(input, Hysteria::right)
        val occurs = right.groupBy { k -> k }.mapValues { it.value.size }
        val diff = left.zip(right).sumOf { (left, right) -> abs(left - right) }
        val sim = left.sumOf { v -> (occurs.getOrElse(v) { 0 }) * v }
        return Answer(diff, sim)
    }


    private fun extracted(lines: List<Input>, extractor: (Hysteria) -> Int): List<Int> {
        return lines.map { line ->
            when (line) {
                is Hysteria -> extractor(line)
                else -> {
                    throw AocException("Unrecognised hysteria line $line")
                }
            }
        }.sorted()
    }
}