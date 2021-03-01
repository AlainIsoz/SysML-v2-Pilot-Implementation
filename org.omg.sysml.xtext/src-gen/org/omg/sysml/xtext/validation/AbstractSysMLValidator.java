/*
 * generated by Xtext 2.22.0
 */
package org.omg.sysml.xtext.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.omg.kerml.expressions.xtext.validation.KerMLExpressionsValidator;

public abstract class AbstractSysMLValidator extends KerMLExpressionsValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>(super.getEPackages());
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.omg.org/spec/SysML/2.0"));
		return result;
	}
}
