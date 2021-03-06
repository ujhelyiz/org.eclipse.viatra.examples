package org.eclipse.viatra.dse.examples.bpmn.patterns;

import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AllocateTaskToVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.examples.bpmn.patterns.allocateTaskToVariant pattern,
 * to be used in conjunction with {@link AllocateTaskToVariantMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AllocateTaskToVariantMatcher
 * @see AllocateTaskToVariantProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AllocateTaskToVariantMatch extends BasePatternMatch {
  private Task fT;
  
  private ResourceTypeVariant fRTV;
  
  private static List<String> parameterNames = makeImmutableList("T", "RTV");
  
  private AllocateTaskToVariantMatch(final Task pT, final ResourceTypeVariant pRTV) {
    this.fT = pT;
    this.fRTV = pRTV;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("T".equals(parameterName)) return this.fT;
    if ("RTV".equals(parameterName)) return this.fRTV;
    return null;
  }
  
  public Task getT() {
    return this.fT;
  }
  
  public ResourceTypeVariant getRTV() {
    return this.fRTV;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("T".equals(parameterName) ) {
    	this.fT = (Task) newValue;
    	return true;
    }
    if ("RTV".equals(parameterName) ) {
    	this.fRTV = (ResourceTypeVariant) newValue;
    	return true;
    }
    return false;
  }
  
  public void setT(final Task pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
  }
  
  public void setRTV(final ResourceTypeVariant pRTV) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRTV = pRTV;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.examples.bpmn.patterns.allocateTaskToVariant";
  }
  
  @Override
  public List<String> parameterNames() {
    return AllocateTaskToVariantMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fT, fRTV};
  }
  
  @Override
  public AllocateTaskToVariantMatch toImmutable() {
    return isMutable() ? newMatch(fT, fRTV) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"T\"=" + prettyPrintValue(fT) + ", ");
    
    result.append("\"RTV\"=" + prettyPrintValue(fRTV)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fT == null) ? 0 : fT.hashCode());
    result = prime * result + ((fRTV == null) ? 0 : fRTV.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AllocateTaskToVariantMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    AllocateTaskToVariantMatch other = (AllocateTaskToVariantMatch) obj;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    if (fRTV == null) {if (other.fRTV != null) return false;}
    else if (!fRTV.equals(other.fRTV)) return false;
    return true;
  }
  
  @Override
  public AllocateTaskToVariantQuerySpecification specification() {
    try {
    	return AllocateTaskToVariantQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static AllocateTaskToVariantMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AllocateTaskToVariantMatch newMutableMatch(final Task pT, final ResourceTypeVariant pRTV) {
    return new Mutable(pT, pRTV);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT the fixed value of pattern parameter T, or null if not bound.
   * @param pRTV the fixed value of pattern parameter RTV, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AllocateTaskToVariantMatch newMatch(final Task pT, final ResourceTypeVariant pRTV) {
    return new Immutable(pT, pRTV);
  }
  
  private static final class Mutable extends AllocateTaskToVariantMatch {
    Mutable(final Task pT, final ResourceTypeVariant pRTV) {
      super(pT, pRTV);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AllocateTaskToVariantMatch {
    Immutable(final Task pT, final ResourceTypeVariant pRTV) {
      super(pT, pRTV);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
