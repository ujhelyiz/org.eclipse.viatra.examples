package org.eclipse.viatra.dse.examples.bpmn.patterns;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.examples.bpmn.patterns.EnoughResourceInstancesMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.EnoughResourceInstancesQuerySpecification;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.examples.bpmn.patterns.enoughResourceInstances pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EnoughResourceInstancesMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern enoughResourceInstances() {
 * 	neg find absenceOfResourceInstances(_);
 * }
 * </pre></code>
 * 
 * @see EnoughResourceInstancesMatch
 * @see EnoughResourceInstancesProcessor
 * @see EnoughResourceInstancesQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EnoughResourceInstancesMatcher extends BaseMatcher<EnoughResourceInstancesMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EnoughResourceInstancesMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    EnoughResourceInstancesMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EnoughResourceInstancesMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(EnoughResourceInstancesMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private EnoughResourceInstancesMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Indicates whether the (parameterless) pattern matches or not.
   * @return true if the pattern has a valid match.
   * 
   */
  public boolean hasMatch() {
    return rawHasMatch(new Object[]{});
  }
  
  @Override
  protected EnoughResourceInstancesMatch tupleToMatch(final Tuple t) {
    try {
    	return EnoughResourceInstancesMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EnoughResourceInstancesMatch arrayToMatch(final Object[] match) {
    try {
    	return EnoughResourceInstancesMatch.newMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected EnoughResourceInstancesMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return EnoughResourceInstancesMatch.newMutableMatch();
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<EnoughResourceInstancesMatcher> querySpecification() throws ViatraQueryException {
    return EnoughResourceInstancesQuerySpecification.instance();
  }
}
