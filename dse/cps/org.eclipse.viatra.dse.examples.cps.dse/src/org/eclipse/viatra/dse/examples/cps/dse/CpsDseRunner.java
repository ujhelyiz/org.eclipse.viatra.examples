/*******************************************************************************
 * Copyright (c) 2010-2015, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.examples.cps.dse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.strategy.impl.FixedPriorityStrategy;
import org.eclipse.viatra.dse.examples.cps.CpsPackage;
import org.eclipse.viatra.dse.examples.cps.HostType;
import org.eclipse.viatra.dse.examples.cps.objectives.ResourceUsageObjective;
import org.eclipse.viatra.dse.examples.cps.patterns.CreateHostInstanceMatch;
import org.eclipse.viatra.dse.examples.cps.patterns.util.AllApplicationInstanceIsRunningQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.AllocatedAppQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.ApplicationsQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.MoreThanOneUnusedHostQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.NotExistUnsatisfiedRequirementQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.RunningAppQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.patterns.util.UnusedHostQuerySpecification;
import org.eclipse.viatra.dse.examples.cps.problems.CpsProblemFactory;
import org.eclipse.viatra.dse.examples.cps.problems.RoomServiceCpsDomain;
import org.eclipse.viatra.dse.examples.cps.rules.Rules;
import org.eclipse.viatra.dse.examples.cps.statecoder.CpsStateCoderFactory;
import org.eclipse.viatra.dse.objectives.ActivationFitnessProcessor;
import org.eclipse.viatra.dse.objectives.Comparators;
import org.eclipse.viatra.dse.objectives.impl.ConstraintsObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.ModelQueryType;
import org.eclipse.viatra.dse.objectives.impl.TrajectoryCostSoftObjective;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.junit.Test;

public class CpsDseRunner {

    @Test
    public void run() throws ViatraQueryException {
        
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.WARN);
//        Logger.getLogger(DesignSpaceManager.class).setLevel(Level.DEBUG);
        
        CpsProblemFactory cpsProblemFactory = new CpsProblemFactory();
        final RoomServiceCpsDomain domain = cpsProblemFactory.getDomain();
        
        DesignSpaceExplorer dse = new DesignSpaceExplorer();
        
        dse.setInitialModel(cpsProblemFactory.basicPackage());
        
        dse.addMetaModelPackage(CpsPackage.eINSTANCE);
        
        dse.setStateCoderFactory(new CpsStateCoderFactory());

        Rules rules = new Rules();

        dse.addTransformationRule(rules.startRule);
        dse.addTransformationRule(rules.allocateRule);
        dse.addTransformationRule(rules.createAppRule);
        dse.addTransformationRule(rules.createHostRule);
        
        dse.addGlobalConstraint(new ModelQueriesGlobalConstraint()
                .withConstraint(MoreThanOneUnusedHostQuerySpecification.instance())
                .withType(ModelQueryType.NO_MATCH));
        
        dse.addObjective(new ConstraintsObjective()
            .withSoftConstraint("RunningApps", RunningAppQuerySpecification.instance(), -4d)
            .withSoftConstraint("AllocatedApps", AllocatedAppQuerySpecification.instance(), -3d)
            .withSoftConstraint("ApplicationInstances", ApplicationsQuerySpecification.instance(), -2d)
            .withSoftConstraint("UnusedHosts", UnusedHostQuerySpecification.instance(), 1d)
            .withHardConstraint(NotExistUnsatisfiedRequirementQuerySpecification.instance())
            .withHardConstraint(AllApplicationInstanceIsRunningQuerySpecification.instance())
            .withComparator(Comparators.LOWER_IS_BETTER)
            .withLevel(1));

        dse.addObjective(new ResourceUsageObjective().withLevel(2));

        dse.addObjective(new TrajectoryCostSoftObjective("RuleCost")
                    .withRuleCost(rules.allocateRule, 3)
                    .withRuleCost(rules.deleteAllocRule, 3)
                    .withRuleCost(rules.moveRule, 4)
                    .withRuleCost(rules.startRule, 1)
                    .withRuleCost(rules.stopRule, 1)
                    .withRuleCost(rules.createAppRule, 2)
                    .withActivationCost(rules.createHostRule, new ActivationFitnessProcessor() {
                        @Override
                        public double process(IPatternMatch match) {
                            CreateHostInstanceMatch m = (CreateHostInstanceMatch) match;
                            HostType hostType = m.getHostType();
                            if (hostType.getId().equals(domain.smokeSensor.getId())) {
                                return 2d;
                            }
                            else if (hostType.getId().equals(domain.temperatureSensor.getId())) {
                                return 3d;
                            }
                            else if (hostType.getId().equals(domain.infraCam.getId())) {
                                return 30d;
                            }
                            else if (hostType.getId().equals(domain.computeServer.getId())) {
                                return 9d;
                            }
                            else if (hostType.getId().equals(domain.videoCam.getId())) {
                                return 18d;
                            }
                            else {
                                return 0d;
                            }
                        }
                    }).
                    withLevel(2));
        
        FixedPriorityStrategy fixedPriorityStrategy = new FixedPriorityStrategy()
                .withRulePriority(rules.startRule, 9)
                .withRulePriority(rules.allocateRule, 8)
                .withRulePriority(rules.createAppRule, 7)
                .withRulePriority(rules.createHostRule, 6);
            
        dse.startExploration(fixedPriorityStrategy);
        
        String solutions = dse.toStringSolutions();
        System.out.println(solutions);
        
    }

}
