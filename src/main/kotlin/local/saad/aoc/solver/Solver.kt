package local.saad.aoc.solver

import local.saad.aoc.models.Answer
import local.saad.aoc.models.Input
import local.saad.aoc.models.InputType

interface Solver {

    val solverType: InputType

    fun solve(input: List<Input>): Answer

}