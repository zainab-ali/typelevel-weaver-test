package fix

import scalafix.v1._
import scalafix.internal.config._
import scala.meta._

class RenameAssertToExpect extends SemanticRule("RenameAssertToExpect") {

  override def fix(implicit doc: SemanticDocument): Patch = {
    val assertMethod  = SymbolMatcher.normalized("weaver/Expectations.Helpers#assert.")
    doc.tree.collect {
      case assertMethod(tree) => Patch.renameSymbol(tree.symbol, "expect")
    }.asPatch
  }

}
