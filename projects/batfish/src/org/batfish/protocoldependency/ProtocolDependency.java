package org.batfish.protocoldependency;

import org.batfish.common.Pair;
import org.batfish.representation.RoutingProtocol;

public class ProtocolDependency extends Pair<RoutingProtocol, Integer> {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   public ProtocolDependency(RoutingProtocol t1, Integer t2) {
      super(t1, t2);
   }

   public Integer getIndirectionLevel() {
      return _t2;
   }

   public RoutingProtocol getProtocol() {
      return _t1;
   }

}
