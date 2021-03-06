package headless;

import headless.EClassMatch;
import headless.util.EClassQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.rete.misc.DeltaMonitor;

/**
 * Generated pattern matcher API of the headless.eClass pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link EClassMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * {@literal @}Item(item = ec, label = "EC: $ec.name$")
 * {@literal @}Format(color = "#e8da2c")
 * pattern eClass(ec : EClass) { EClass(ec); }
 * </pre></code>
 * 
 * @see EClassMatch
 * @see EClassProcessor
 * @see EClassQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class EClassMatcher extends BaseMatcher<EClassMatch> {
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<EClassMatcher> querySpecification() throws IncQueryException {
    return EClassQuerySpecification.instance();
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static EClassMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    EClassMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new EClassMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_EC = 0;
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public EClassMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public EClassMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @return matches represented as a EClassMatch object.
   * 
   */
  public Collection<EClassMatch> getAllMatches(final EClass pEc) {
    return rawGetAllMatches(new Object[]{pEc});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @return a match represented as a EClassMatch object, or null if no match is found.
   * 
   */
  public EClassMatch getOneArbitraryMatch(final EClass pEc) {
    return rawGetOneArbitraryMatch(new Object[]{pEc});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EClass pEc) {
    return rawHasMatch(new Object[]{pEc});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EClass pEc) {
    return rawCountMatches(new Object[]{pEc});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EClass pEc, final IMatchProcessor<? super EClassMatch> processor) {
    rawForEachMatch(new Object[]{pEc}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EClass pEc, final IMatchProcessor<? super EClassMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pEc}, processor);
  }
  
  /**
   * Registers a new filtered delta monitor on this pattern matcher.
   * The DeltaMonitor can be used to track changes (delta) in the set of filtered pattern matches from now on, considering those matches only that conform to the given fixed values of some parameters.
   * It can also be reset to track changes from a later point in time,
   * and changes can even be acknowledged on an individual basis.
   * See {@link DeltaMonitor} for details.
   * @param fillAtStart if true, all current matches are reported as new match events; if false, the delta monitor starts empty.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @return the delta monitor.
   * @deprecated use the IncQuery Databinding API (IncQueryObservables) instead.
   * 
   */
  @Deprecated
  public DeltaMonitor<EClassMatch> newFilteredDeltaMonitor(final boolean fillAtStart, final EClass pEc) {
    return rawNewFilteredDeltaMonitor(fillAtStart, new Object[]{pEc});
  }
  
  /**
   * Returns a new (partial) Match object for the matcher.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pEc the fixed value of pattern parameter ec, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public EClassMatch newMatch(final EClass pEc) {
    return new EClassMatch.Immutable(pEc);
    
  }
  
  /**
   * Retrieve the set of values that occur in matches for ec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EClass> rawAccumulateAllValuesOfec(final Object[] parameters) {
    Set<EClass> results = new HashSet<EClass>();
    rawAccumulateAllValues(POSITION_EC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ec.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EClass> getAllValuesOfec() {
    return rawAccumulateAllValuesOfec(emptyArray());
  }
  
  @Override
  protected EClassMatch tupleToMatch(final Tuple t) {
    try {
    	return new EClassMatch.Immutable((org.eclipse.emf.ecore.EClass) t.get(POSITION_EC));
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in tuple not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected EClassMatch arrayToMatch(final Object[] match) {
    try {
    	return new EClassMatch.Immutable((org.eclipse.emf.ecore.EClass) match[POSITION_EC]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  protected EClassMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return new EClassMatch.Mutable((org.eclipse.emf.ecore.EClass) match[POSITION_EC]);
    } catch(ClassCastException e) {engine.getLogger().error("Element(s) in array not properly typed!",e);	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
}
