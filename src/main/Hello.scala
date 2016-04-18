import org.nlogo.api._
import org.nlogo.core.Syntax._
import org.nlogo.api.ScalaConversions._

class HelloScalaExtension extends DefaultClassManager {
  def load(manager: PrimitiveManager) {
    manager.addPrimitive("hello", new HelloString)
  }
}

class HelloString extends Reporter {
  override def getSyntax = reporterSyntax(right = List(StringType), ret = StringType)
  def report(args: Array[Argument], context: Context): AnyRef = {
    val name = args(0).getString
    "hello, " + name
  }
}
