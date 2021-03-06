/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy, Abel Hegedus, Akos Horvath, Zoltan Ujhelyi and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.bpmn.rules;

import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatch;
import org.eclipse.viatra.dse.examples.bpmn.patterns.AllocateTaskToVariantMatcher;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AllocateTaskToVariantProcessor;
import org.eclipse.viatra.dse.examples.bpmn.patterns.util.AllocateTaskToVariantQuerySpecification;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.ResourceTypeVariant;
import org.eclipse.viatra.dse.examples.simplifiedbpmn.Task;

/**
 * This rule assigns a resource variant to a task.
 * 
 * @author Andras Szabolcs Nagy
 */
public class AssignVariantToTaskRule {

    public static DSETransformationRule<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher> createRule()
            throws ViatraQueryException {
        return new DSETransformationRule<AllocateTaskToVariantMatch, AllocateTaskToVariantMatcher>(
                AllocateTaskToVariantQuerySpecification.instance(), new AllocateTaskToVariantProcessor() {

                    @Override
                    public void process(Task pT, ResourceTypeVariant pRTV) {
                        pT.setVariant(pRTV);
                    }
                });
    }
}
