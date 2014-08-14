package batfish.z3.node;

import java.util.ArrayList;
import java.util.List;

public class EqExpr extends BooleanExpr implements ComplexExpr {

   private IntExpr _lhs;
   private IntExpr _rhs;
   private List<Expr> _subExpressions;

   public EqExpr() {
      init();
   }

   public EqExpr(IntExpr lhs, IntExpr rhs) {
      init();
      _lhs = lhs;
      _rhs = rhs;
      refreshSubExpressions();
   }

   @Override
   public List<Expr> getSubExpressions() {
      return _subExpressions;
   }

   private void init() {
      _subExpressions = new ArrayList<Expr>();
      _printer = new CollapsedComplexExprPrinter(this);
   }

   private void refreshSubExpressions() {
      _subExpressions.clear();
      _subExpressions.add(new IdExpr("="));
      _subExpressions.add(_lhs);
      _subExpressions.add(_rhs);
   }

   public void setLhs(IntExpr lhs) {
      _lhs = lhs;
      refreshSubExpressions();
   }

   public void setRhs(IntExpr rhs) {
      _rhs = rhs;
      refreshSubExpressions();
   }

   @Override
   public BooleanExpr simplify() {
      if (_lhs.equals(_rhs)) {
         return TrueExpr.INSTANCE;
      }
      else if (_lhs instanceof LitIntExpr && _rhs instanceof LitIntExpr) {
         return FalseExpr.INSTANCE;
      }
      else {
         return this;
      }
   }
   
}
