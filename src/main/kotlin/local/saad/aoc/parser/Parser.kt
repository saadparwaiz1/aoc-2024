package local.saad.aoc.parser

import local.saad.aoc.models.Input
import local.saad.aoc.models.InputType

interface Parser {
    val  parserType: InputType
    fun parse(lines: List<String>): List<Input>
}