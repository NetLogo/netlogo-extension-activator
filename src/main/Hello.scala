import org.nlogo.api._
import org.nlogo.core.Syntax._
import org.nlogo.api.ScalaConversions._

class HelloScalaExtension extends DefaultClassManager {
  def load(manager: PrimitiveManager) {
    manager.addPrimitive("hello", new HelloString)
    manager.addPrimitive("wiggle", new Wiggle)
  }
}

class HelloString extends Reporter {
  override def getSyntax = reporterSyntax(
    right = List(StringType), // The types of arguments this reporter takes
    ret = StringType // The type of thing this reporter returns
  )

  def report(args: Array[Argument], context: Context): AnyRef = {
    // args(0) gives you the first argument, args(1) the second, and so forth
    val name = args(0).getString
    // In Scala, the last line of a function is what is returned.
    "hello, " + name
  }
}

class Wiggle extends Command {
  override def getSyntax = commandSyntax(
    right = List(NumberType),
    // This limits the command to turtles. The default is "OTPL", which allows
    // the observer, turtles, patches, or links to run the command. Replacing
    // any one of the letters with "-" prevents that kind of agent from running
    // the command.
    agentClassString = "-T--"
  )

  override def perform(args: Array[Argument], context: Context): Unit = {
    val rng = context.getRNG // This lets us get random numbers
    val turtle = context.getAgent.asInstanceOf[Turtle] // Gets the turtle that running the command
    val angle = args(0).getIntValue // Get the first argument as a whole number

    // This equivalent to having the turtle run
    // set heading heading + (random angle) - (random angle)
    turtle.heading(turtle.heading + rng.nextInt(angle) - rng.nextInt(angle))
  }
}
