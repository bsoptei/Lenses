package main

import diy_lenses_example.DIYLensesExample
import monocle_example.MonocleExample
import vanilla_example.VanillaExample

object Main {
  def main(args: Array[String]): Unit = {
    VanillaExample.run()
    DIYLensesExample.run()
    MonocleExample.run()
  }
}
