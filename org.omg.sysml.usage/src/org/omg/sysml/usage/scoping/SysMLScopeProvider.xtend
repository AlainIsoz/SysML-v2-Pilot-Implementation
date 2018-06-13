/*
 * generated by Xtext 2.12.0
 */
package org.omg.sysml.usage.scoping

import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.omg.sysml.usage.sysML.Member
import org.omg.sysml.usage.sysML.Part
import org.eclipse.xtext.scoping.impl.SimpleScope

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
class SysMLScopeProvider extends AbstractSysMLScopeProvider {

	override IScope getScope(EObject context, EReference reference) {
		var scope = super.getScope(context, reference);
		if (context instanceof Member) {
			val owner = (context as Member).eContainer;
			if (owner instanceof Part) {
				val definition = (owner as Part).definition;
				if (definition !== null && !definition.eIsProxy) {
					scope = new SimpleScope(scope, this.getScope(definition, reference).allElements)
				}
				val base = (owner as Part).base;
				if (base !== null && !base.eIsProxy) {
					scope = new SimpleScope(scope, this.getScope(base, reference).allElements)
				}
			}
		}
		return scope;
	}

}
