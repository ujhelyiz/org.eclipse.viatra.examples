/*******************************************************************************
 * Copyright (c) 2014, 2016, IncQuery Labs Ltd. 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Akos Horvath, Abel Hegedus, Tamas Borbas, Marton Bur, Zoltan Ujhelyi, Robert Doczi, Daniel Segesdi, Peter Lunk - initial API and implementation
 *******************************************************************************/

package org.eclipse.viatra.examples.cps.xform.m2m.tests.wrappers

import org.apache.log4j.Logger
import org.eclipse.viatra.examples.cps.traceability.CPSToDeployment

abstract class CPSTransformationWrapper {
	protected extension Logger logger = Logger.getLogger("cps.xform.CPSTransformationWrapper")
	
	def void initializeTransformation(CPSToDeployment cps2dep)
	
	def void executeTransformation()
	
	def void cleanupTransformation()
}