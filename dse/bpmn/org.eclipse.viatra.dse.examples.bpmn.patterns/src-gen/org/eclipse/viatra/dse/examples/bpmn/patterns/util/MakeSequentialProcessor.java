package org.eclipse.viatra.dse.examples.bpmn.patterns.util;

import org.eclipse.viatra.dse.examples.simplifiedbpmn.SimplifiedBPMN;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.MakeSequentialMatch;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.examples.bpmn.patterns.makeSequential pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MakeSequentialProcessor implements IMatchProcessor<MakeSequentialMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pT1 the value of pattern parameter T1 in the currently processed match
   * @param pT2 the value of pattern parameter T2 in the currently processed match
   * @param pRoot the value of pattern parameter Root in the currently processed match
   * 
   */
  public abstract void process(final Task pT1, final Task pT2, final SimplifiedBPMN pRoot);
  
  @Override
  public void process(final MakeSequentialMatch match) {
    process(match.getT1(), match.getT2(), match.getRoot());
  }
}