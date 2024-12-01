package local.saad.aoc.models.hysteria

import local.saad.aoc.models.Input
import local.saad.aoc.models.InputType

data class Hysteria(val left: Int, val right: Int, override val type: InputType = InputType.Hysteria): Input
