package headless.util;

import com.google.common.collect.Sets;
import headless.EClassMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.context.EMFPatternMatcherContext;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.PQuery.PQueryStatus;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.ParameterReference;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;

/**
 * A pattern-specific query specification that can instantiate EClassMatcher in a type-safe way.
 * 
 * @see EClassMatcher
 * @see EClassMatch
 * 
 */
@SuppressWarnings("all")
public final class EClassQuerySpecification extends BaseGeneratedQuerySpecification<EClassMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static EClassQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected EClassMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return EClassMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "headless.eClass";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("ec");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("ec", "org.eclipse.emf.ecore.EClass"));
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    EMFPatternMatcherContext context = new EMFPatternMatcherContext();
    Set<PBody> bodies = Sets.newHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_ec = body.getOrCreateVariableByName("ec");
      body.setExportedParameters(Arrays.asList(
        new ExportedParameter(body, var_ec, "ec")
      ));
      
      new TypeUnary(body, var_ec, getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EClass"), "http://www.eclipse.org/emf/2002/Ecore/EClass");
      bodies.add(body);
    }{
      PAnnotation annotation = new PAnnotation("Item");
      annotation.addAttribute("item",new ParameterReference("ec"));
      annotation.addAttribute("label","EC: $ec.name$");
      addAnnotation(annotation);
    }
    {
      PAnnotation annotation = new PAnnotation("Format");
      annotation.addAttribute("color","#e8da2c");
      addAnnotation(annotation);
    }
    setStatus(PQueryStatus.OK);
    return bodies;
  }
  
  private EClassQuerySpecification() throws IncQueryException {
    super();
    setStatus(PQueryStatus.UNINITIALIZED);
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<EClassQuerySpecification> {
    @Override
    public EClassQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static EClassQuerySpecification INSTANCE = make();
    
    public static EClassQuerySpecification make() {
      try {
      	return new EClassQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
