/*
 * generated by Xtext 2.18.0.M3
 */
package org.omg.kerml.xtext

import com.google.inject.Binder
import com.google.inject.name.Names
import org.eclipse.xtext.linking.ILinker
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.validation.CompositeEValidator
import org.eclipse.xtext.validation.IResourceValidator
import org.omg.kerml.xtext.library.KerMLLibraryProvider
import org.omg.kerml.xtext.library.LibraryNamespaces
import org.omg.kerml.xtext.linking.KerMLLazyLinkingResource
import org.omg.kerml.xtext.naming.KerMLQualifiedNameConverter
import org.omg.kerml.xtext.naming.KerMLQualifiedNameProvider
import org.omg.kerml.xtext.scoping.KerMLGlobalScopeProvider
import org.omg.kerml.xtext.scoping.KerMLLinker
import org.omg.kerml.xtext.validation.KerMLResourceValidator
import org.omg.sysml.lang.sysml.util.IModelLibraryProvider
import org.omg.kerml.xtext.library.ILibraryIndexProvider
import org.omg.kerml.xtext.library.PrecalculatedLibraryIndexProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class KerMLRuntimeModule extends AbstractKerMLRuntimeModule {
	
	def Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		KerMLQualifiedNameConverter
	}
	
	def Class<? extends IModelLibraryProvider> bindIModelLLibraryProvider() {
		KerMLLibraryProvider
	}
		
	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		KerMLGlobalScopeProvider
	}

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		KerMLQualifiedNameProvider
	}

	override Class<? extends ILinker> bindILinker() {
		KerMLLinker
	}
	
	def void configureUseEObjectValidator(Binder binder) {
		binder.bind(Boolean).annotatedWith(Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false);
		binder.bind(ILibraryIndexProvider).toProvider([PrecalculatedLibraryIndexProvider.getInstance])
	}

	def Class<? extends IResourceValidator> bindIResourceValidator() {
		KerMLResourceValidator
	}
	
	override Class<? extends XtextResource> bindXtextResource() {
		KerMLLazyLinkingResource
	}
	
	def Class<? extends LibraryNamespaces> bindLibraryNamespaces(){
	    LibraryNamespaces
	}
}
