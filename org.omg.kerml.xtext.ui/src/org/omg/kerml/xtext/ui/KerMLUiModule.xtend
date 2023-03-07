/*
 * generated by Xtext 2.18.0.M3
 */
package org.omg.kerml.xtext.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.shared.Access
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider
import org.omg.kerml.xtext.ui.quickfix.KerMLQuickfixProvider
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class KerMLUiModule extends AbstractKerMLUiModule {

	override Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		KerMLQuickfixProvider;
	}
	
	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		KerMLUserKeywordHighlightingCalculator
	}
	
	def Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		KerMLHighlightingConfiguration
	}
	
	def Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		KerMLAntlrTokenToAttributeIdMapper
	}
	
	override provideIAllContainersState() {
		// Replaces the JDT-aware project state implementation with one that handles dependencies via project references
		Access.workspaceProjectsState
	}
}
