package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.bpmn.patterns.VariantAllocatedToTaskMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.variantAllocatedToTask pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class VariantAllocatedToTaskProcessor implements IMatchProcessor<VariantAllocatedToTaskMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT the value of pattern parameter T in the currently processed match
   * @param pRTV the value of pattern parameter RTV in the currently processed match
   * 
   */
  public abstract void process(final Task pT, final ResourceTypeVariant pRTV);
  
  @Override
  public void process(final VariantAllocatedToTaskMatch match) {
    process(match.getT(), match.getRTV());
  }
}
