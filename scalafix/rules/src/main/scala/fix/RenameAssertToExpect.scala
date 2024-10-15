package fix

import scalafix.v1._
import scala.meta._

class RenameAssertToExpect extends SemanticRule("RenameAssertToExpect") {

  override def fix(implicit doc: SemanticDocument): Patch = {
    Patch.replaceSymbols("weaver.Expectations.Helpers.assert" -> "expect")
  }

}
