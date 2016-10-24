package com.monovore.clique

import cats.syntax.all._

object ListDir extends CommandApp(
  name = "ls",
  header = "List information about files.",
  options = {

    val color =
      Opts.optional[String]("color", "WHEN", "colorize the output: 'always', 'auto', or 'never'")
        .withDefault("always")

    val humanReadable = Opts.flag("human-readable", "print human readable sizes")

    val directory = Opts.argument[String]("directory")

    (color |@| humanReadable |@| directory).map { (color, humanReadable, directory) =>

      println("Color: "  + color)
      println("Human readable: "  + humanReadable)
      println("Dir: " + directory)
    }
  }
)
