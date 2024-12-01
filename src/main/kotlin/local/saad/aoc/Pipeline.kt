package local.saad.aoc

import local.saad.aoc.config.Config
import local.saad.aoc.config.Solution
import local.saad.aoc.exceptions.AocException
import local.saad.aoc.models.Answer
import local.saad.aoc.parser.Parser
import local.saad.aoc.solver.Solver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class Pipeline(val solvers: List<Solver>, val parsers: List<Parser>, val config: Config) : CommandLineRunner {

    companion object {
        val log: Logger = LoggerFactory.getLogger(Pipeline::class.java);
    }


    override fun run(vararg args: String?) {
        config.solutions.forEach { sol ->
            log.info("trying to solve solution of input type {} with path {}", sol.inputType, sol.file)
            val parser = parsers.first { parser: Parser -> parser.parserType == sol.inputType }
            val solver = solvers.first { it.solverType == sol.inputType }

            val fileStream = javaClass.getResourceAsStream(sol.file)
            fileStream.use {
                val data = fileStream?.readBytes()?.toString(Charsets.UTF_8)
                if (data != null) {
                    log.info(
                        "answer for sol of type {} is {}",
                        sol.inputType,
                        solver.solve(parser.parse(data.split("\n")))
                    )
                } else {
                    throw AocException("no data found at path ${sol.file}")
                }
            }
        }
    }
}