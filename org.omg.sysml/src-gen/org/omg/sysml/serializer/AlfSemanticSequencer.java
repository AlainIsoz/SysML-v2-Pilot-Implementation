/*
 * generated by Xtext 2.12.0
 */
package org.omg.sysml.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.omg.sysml.lang.sysml.Association;
import org.omg.sysml.lang.sysml.Comment;
import org.omg.sysml.lang.sysml.Connector;
import org.omg.sysml.lang.sysml.ElementReferenceExpression;
import org.omg.sysml.lang.sysml.EndFeatureMembership;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureMembership;
import org.omg.sysml.lang.sysml.Generalization;
import org.omg.sysml.lang.sysml.InstanceCreationExpression;
import org.omg.sysml.lang.sysml.LiteralBoolean;
import org.omg.sysml.lang.sysml.LiteralInteger;
import org.omg.sysml.lang.sysml.LiteralNull;
import org.omg.sysml.lang.sysml.LiteralReal;
import org.omg.sysml.lang.sysml.LiteralString;
import org.omg.sysml.lang.sysml.LiteralUnbounded;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.OperatorExpression;
import org.omg.sysml.lang.sysml.Redefinition;
import org.omg.sysml.lang.sysml.SequenceAccessExpression;
import org.omg.sysml.lang.sysml.SequenceConstructionExpression;
import org.omg.sysml.lang.sysml.Subset;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.services.AlfGrammarAccess;

@SuppressWarnings("all")
public class AlfSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AlfGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == SysMLPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case SysMLPackage.ASSOCIATION:
				if (rule == grammarAccess.getAssociationDeclarationRule()) {
					sequence_AssociationDeclaration(context, (Association) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getNonFeatureDefinitionRule()
						|| rule == grammarAccess.getClassifierDefinitionOrStubRule()
						|| rule == grammarAccess.getAssociationDefinitionRule()
						|| rule == grammarAccess.getAssociationDefinitionOrStubRule()) {
					sequence_AssociationDeclaration_AssociationDefinition(context, (Association) semanticObject); 
					return; 
				}
				else break;
			case SysMLPackage.CLASS:
				if (rule == grammarAccess.getClassDeclarationRule()) {
					sequence_ClassDeclaration(context, (org.omg.sysml.lang.sysml.Class) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnitDefinitionRule()
						|| rule == grammarAccess.getUnCommentedUnitDefinitionRule()
						|| rule == grammarAccess.getNonFeatureDefinitionRule()
						|| rule == grammarAccess.getClassifierDefinitionOrStubRule()
						|| rule == grammarAccess.getClassDefinitionRule()
						|| rule == grammarAccess.getClassDefinitionOrStubRule()) {
					sequence_ClassDeclaration_ClassDefinition(context, (org.omg.sysml.lang.sysml.Class) semanticObject); 
					return; 
				}
				else break;
			case SysMLPackage.COMMENT:
				sequence_Comment(context, (Comment) semanticObject); 
				return; 
			case SysMLPackage.CONNECTOR:
				sequence_ConnectorDefinition(context, (Connector) semanticObject); 
				return; 
			case SysMLPackage.ELEMENT_REFERENCE_EXPRESSION:
				sequence_ElementReferenceExpression(context, (ElementReferenceExpression) semanticObject); 
				return; 
			case SysMLPackage.END_FEATURE_MEMBERSHIP:
				sequence_EndFeatureMember(context, (EndFeatureMembership) semanticObject); 
				return; 
			case SysMLPackage.FEATURE:
				if (rule == grammarAccess.getUnitDefinitionRule()
						|| rule == grammarAccess.getUnCommentedUnitDefinitionRule()
						|| rule == grammarAccess.getNamedFeatureDefinitionRule()) {
					sequence_NamedFeatureDefinition(context, (Feature) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getFeatureDefinitionRule()) {
					sequence_NamedFeatureDefinition_UnnamedFeatureDefinition(context, (Feature) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnnamedFeatureDefinitionRule()) {
					sequence_UnnamedFeatureDefinition(context, (Feature) semanticObject); 
					return; 
				}
				else break;
			case SysMLPackage.FEATURE_MEMBERSHIP:
				if (rule == grammarAccess.getAssociationMemberRule()
						|| rule == grammarAccess.getAssociationFeatureMemberRule()) {
					sequence_AssociationFeatureMember(context, (FeatureMembership) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getClassMemberRule()
						|| rule == grammarAccess.getClassFeatureMemberRule()) {
					sequence_ClassFeatureMember(context, (FeatureMembership) semanticObject); 
					return; 
				}
				else break;
			case SysMLPackage.GENERALIZATION:
				sequence_Generalization(context, (Generalization) semanticObject); 
				return; 
			case SysMLPackage.INSTANCE_CREATION_EXPRESSION:
				sequence_InstanceCreationExpression(context, (InstanceCreationExpression) semanticObject); 
				return; 
			case SysMLPackage.LITERAL_BOOLEAN:
				sequence_BooleanLiteralExpression(context, (LiteralBoolean) semanticObject); 
				return; 
			case SysMLPackage.LITERAL_INTEGER:
				sequence_NaturalLiteralExpression(context, (LiteralInteger) semanticObject); 
				return; 
			case SysMLPackage.LITERAL_NULL:
				sequence_NullLiteralExpression(context, (LiteralNull) semanticObject); 
				return; 
			case SysMLPackage.LITERAL_REAL:
				sequence_RealLiteralExpression(context, (LiteralReal) semanticObject); 
				return; 
			case SysMLPackage.LITERAL_STRING:
				sequence_StringLiteralExpression(context, (LiteralString) semanticObject); 
				return; 
			case SysMLPackage.LITERAL_UNBOUNDED:
				sequence_UnlimitedNaturalLiteralExpression(context, (LiteralUnbounded) semanticObject); 
				return; 
			case SysMLPackage.MEMBERSHIP:
				if (rule == grammarAccess.getNonFeatureMemberRule()
						|| rule == grammarAccess.getClassMemberRule()
						|| rule == grammarAccess.getAssociationMemberRule()) {
					sequence_NonFeatureMember(context, (Membership) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPackageMemberRule()) {
					sequence_NonFeatureMember_PackagedFeatureMember(context, (Membership) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOwnedGeneralizationRule()) {
					sequence_OwnedGeneralization(context, (Membership) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getOwnedRedefinitionOrSubsetRule()) {
					sequence_OwnedRedefinitionOrSubset(context, (Membership) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getPackagedFeatureMemberRule()) {
					sequence_PackagedFeatureMember(context, (Membership) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnitMemberRule()) {
					sequence_UnitMember(context, (Membership) semanticObject); 
					return; 
				}
				else break;
			case SysMLPackage.OPERATOR_EXPRESSION:
				sequence_BinaryExpression_UnaryExpression(context, (OperatorExpression) semanticObject); 
				return; 
			case SysMLPackage.PACKAGE:
				if (rule == grammarAccess.getCommentedUnitDefinitionRule()) {
					sequence_CommentedUnitDefinition(context, (org.omg.sysml.lang.sysml.Package) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnitDefinitionRule()) {
					sequence_CommentedUnitDefinition_PackageDefinition(context, (org.omg.sysml.lang.sysml.Package) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getUnCommentedUnitDefinitionRule()
						|| rule == grammarAccess.getPackageDefinitionRule()
						|| rule == grammarAccess.getPackageDefinitionOrStubRule()
						|| rule == grammarAccess.getNonFeatureDefinitionRule()) {
					sequence_PackageDefinition(context, (org.omg.sysml.lang.sysml.Package) semanticObject); 
					return; 
				}
				else break;
			case SysMLPackage.REDEFINITION:
				sequence_Redefinition(context, (Redefinition) semanticObject); 
				return; 
			case SysMLPackage.SEQUENCE_ACCESS_EXPRESSION:
				sequence_SequenceAccessExpression(context, (SequenceAccessExpression) semanticObject); 
				return; 
			case SysMLPackage.SEQUENCE_CONSTRUCTION_EXPRESSION:
				sequence_SequenceConstructionExpression(context, (SequenceConstructionExpression) semanticObject); 
				return; 
			case SysMLPackage.SUBSET:
				sequence_Subset(context, (Subset) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AssociationDeclaration returns Association
	 *
	 * Constraint:
	 *     (isAbstract?='abstract'? name=Name (ownedMembership+=OwnedGeneralization ownedMembership+=OwnedGeneralization*)?)
	 */
	protected void sequence_AssociationDeclaration(ISerializationContext context, Association semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NonFeatureDefinition returns Association
	 *     ClassifierDefinitionOrStub returns Association
	 *     AssociationDefinition returns Association
	 *     AssociationDefinitionOrStub returns Association
	 *
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMembership+=OwnedGeneralization ownedMembership+=OwnedGeneralization*)? 
	 *         ownedMembership+=AssociationMember*
	 *     )
	 */
	protected void sequence_AssociationDeclaration_AssociationDefinition(ISerializationContext context, Association semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AssociationMember returns FeatureMembership
	 *     AssociationFeatureMember returns FeatureMembership
	 *
	 * Constraint:
	 *     (
	 *         ownedElement+=Comment* 
	 *         visibility=VisibilityIndicator? 
	 *         (
	 *             ((isComposite?='part' | isPort?='port')? direction=FeatureDirection? ownedMemberElement=FeatureDefinition) | 
	 *             ownedMemberElement=ConnectorDefinition | 
	 *             (isComposite?='part'? memberName=Name? memberElement=[Element|QualifiedName])
	 *         )
	 *     )
	 */
	protected void sequence_AssociationFeatureMember(ISerializationContext context, FeatureMembership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns OperatorExpression
	 *     BinaryExpression returns OperatorExpression
	 *     BinaryExpression.OperatorExpression_1_0 returns OperatorExpression
	 *     UnaryExpression returns OperatorExpression
	 *     SequenceAccessExpression returns OperatorExpression
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns OperatorExpression
	 *     PrimaryExpression returns OperatorExpression
	 *
	 * Constraint:
	 *     (
	 *         (operand+=BinaryExpression_OperatorExpression_1_0 ((operator=BinaryOperator operand+=Expression) | (operator='@' operand+=Expression))) | 
	 *         (operator=UnaryOperator operand+=SequenceAccessExpression)
	 *     )
	 */
	protected void sequence_BinaryExpression_UnaryExpression(ISerializationContext context, OperatorExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralBoolean
	 *     BinaryExpression returns LiteralBoolean
	 *     BinaryExpression.OperatorExpression_1_0 returns LiteralBoolean
	 *     UnaryExpression returns LiteralBoolean
	 *     SequenceAccessExpression returns LiteralBoolean
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns LiteralBoolean
	 *     PrimaryExpression returns LiteralBoolean
	 *     LiteralExpression returns LiteralBoolean
	 *     BooleanLiteralExpression returns LiteralBoolean
	 *
	 * Constraint:
	 *     value=BOOLEAN_VALUE
	 */
	protected void sequence_BooleanLiteralExpression(ISerializationContext context, LiteralBoolean semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.LITERAL_BOOLEAN__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.LITERAL_BOOLEAN__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBooleanLiteralExpressionAccess().getValueBOOLEAN_VALUETerminalRuleCall_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ClassDeclaration returns Class
	 *
	 * Constraint:
	 *     (isAbstract?='abstract'? name=Name (ownedMembership+=OwnedGeneralization ownedMembership+=OwnedGeneralization*)?)
	 */
	protected void sequence_ClassDeclaration(ISerializationContext context, org.omg.sysml.lang.sysml.Class semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnitDefinition returns Class
	 *     UnCommentedUnitDefinition returns Class
	 *     NonFeatureDefinition returns Class
	 *     ClassifierDefinitionOrStub returns Class
	 *     ClassDefinition returns Class
	 *     ClassDefinitionOrStub returns Class
	 *
	 * Constraint:
	 *     (isAbstract?='abstract'? name=Name (ownedMembership+=OwnedGeneralization ownedMembership+=OwnedGeneralization*)? ownedMembership+=ClassMember*)
	 */
	protected void sequence_ClassDeclaration_ClassDefinition(ISerializationContext context, org.omg.sysml.lang.sysml.Class semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ClassMember returns FeatureMembership
	 *     ClassFeatureMember returns FeatureMembership
	 *
	 * Constraint:
	 *     (
	 *         ownedElement+=Comment* 
	 *         visibility=VisibilityIndicator? 
	 *         (
	 *             ((isComposite?='part' | isPort?='port')? direction=FeatureDirection? ownedMemberElement=NamedFeatureDefinition) | 
	 *             ((isComposite?='part' | isPort?='port')? direction=FeatureDirection? ownedMemberElement=UnnamedFeatureDefinition) | 
	 *             ownedMemberElement=ConnectorDefinition | 
	 *             (((isComposite?='part'? memberName=Name?) | memberName=Name)? memberElement=[Element|QualifiedName])
	 *         )
	 *     )
	 */
	protected void sequence_ClassFeatureMember(ISerializationContext context, FeatureMembership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Comment returns Comment
	 *
	 * Constraint:
	 *     body=DOCUMENTATION_COMMENT
	 */
	protected void sequence_Comment(ISerializationContext context, Comment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.COMMENT__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.COMMENT__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCommentAccess().getBodyDOCUMENTATION_COMMENTTerminalRuleCall_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     CommentedUnitDefinition returns Package
	 *
	 * Constraint:
	 *     (ownedElement+=Comment+ ownedMembership+=UnitMember)
	 */
	protected void sequence_CommentedUnitDefinition(ISerializationContext context, org.omg.sysml.lang.sysml.Package semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnitDefinition returns Package
	 *
	 * Constraint:
	 *     ((ownedElement+=Comment+ ownedMembership+=UnitMember) | (name=Name ownedMembership+=PackageMember*))
	 */
	protected void sequence_CommentedUnitDefinition_PackageDefinition(ISerializationContext context, org.omg.sysml.lang.sysml.Package semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ConnectorDefinition returns Connector
	 *
	 * Constraint:
	 *     (name=Name? association=[Association|QualifiedName]? sourceFeature=[Feature|QualifiedName] targetFeature=[Feature|QualifiedName])
	 */
	protected void sequence_ConnectorDefinition(ISerializationContext context, Connector semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns ElementReferenceExpression
	 *     BinaryExpression returns ElementReferenceExpression
	 *     BinaryExpression.OperatorExpression_1_0 returns ElementReferenceExpression
	 *     UnaryExpression returns ElementReferenceExpression
	 *     SequenceAccessExpression returns ElementReferenceExpression
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns ElementReferenceExpression
	 *     PrimaryExpression returns ElementReferenceExpression
	 *     ElementReferenceExpression returns ElementReferenceExpression
	 *
	 * Constraint:
	 *     referent=[Element|QualifiedName]
	 */
	protected void sequence_ElementReferenceExpression(ISerializationContext context, ElementReferenceExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getElementReferenceExpressionAccess().getReferentElementQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(SysMLPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENT, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AssociationMember returns EndFeatureMembership
	 *     EndFeatureMember returns EndFeatureMembership
	 *
	 * Constraint:
	 *     (
	 *         ownedElement+=Comment* 
	 *         visibility=VisibilityIndicator? 
	 *         (
	 *             (direction=FeatureDirection? ownedMemberElement=NamedFeatureDefinition) | 
	 *             (direction=FeatureDirection? ownedMemberElement=UnnamedFeatureDefinition) | 
	 *             ((memberName=Name | memberName=Name)? memberElement=[Element|QualifiedName])
	 *         )
	 *     )
	 */
	protected void sequence_EndFeatureMember(ISerializationContext context, EndFeatureMembership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Generalization returns Generalization
	 *
	 * Constraint:
	 *     general=[Class|QualifiedName]
	 */
	protected void sequence_Generalization(ISerializationContext context, Generalization semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.GENERALIZATION__GENERAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.GENERALIZATION__GENERAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGeneralizationAccess().getGeneralClassQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(SysMLPackage.Literals.GENERALIZATION__GENERAL, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns InstanceCreationExpression
	 *     BinaryExpression returns InstanceCreationExpression
	 *     BinaryExpression.OperatorExpression_1_0 returns InstanceCreationExpression
	 *     UnaryExpression returns InstanceCreationExpression
	 *     SequenceAccessExpression returns InstanceCreationExpression
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns InstanceCreationExpression
	 *     PrimaryExpression returns InstanceCreationExpression
	 *     InstanceCreationExpression returns InstanceCreationExpression
	 *
	 * Constraint:
	 *     (class=[Class|QualifiedName] (argument+=Expression argument+=Expression*)?)
	 */
	protected void sequence_InstanceCreationExpression(ISerializationContext context, InstanceCreationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnitDefinition returns Feature
	 *     UnCommentedUnitDefinition returns Feature
	 *     NamedFeatureDefinition returns Feature
	 *
	 * Constraint:
	 *     (
	 *         name=Name 
	 *         (
	 *             (
	 *                 isComposite?='composes'? 
	 *                 referencedType+=[Class|QualifiedName]? 
	 *                 ownedMembership+=OwnedRedefinitionOrSubset? 
	 *                 (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)? 
	 *                 value=Expression? 
	 *                 ownedMembership+=ClassMember*
	 *             ) | 
	 *             (
	 *                 ownedMembership+=OwnedRedefinitionOrSubset 
	 *                 (
	 *                     (
	 *                         (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)? 
	 *                         ((value=Expression ownedMembership+=ClassMember*) | ownedMembership+=ClassMember+)?
	 *                     ) | 
	 *                     (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)
	 *                 )
	 *             )
	 *         )
	 *     )
	 */
	protected void sequence_NamedFeatureDefinition(ISerializationContext context, Feature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FeatureDefinition returns Feature
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             name=Name 
	 *             (
	 *                 (
	 *                     isComposite?='composes'? 
	 *                     referencedType+=[Class|QualifiedName]? 
	 *                     ownedMembership+=OwnedRedefinitionOrSubset? 
	 *                     (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)? 
	 *                     value=Expression? 
	 *                     ownedMembership+=ClassMember*
	 *                 ) | 
	 *                 (
	 *                     ownedMembership+=OwnedRedefinitionOrSubset 
	 *                     (
	 *                         (
	 *                             (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)? 
	 *                             ((value=Expression ownedMembership+=ClassMember*) | ownedMembership+=ClassMember+)?
	 *                         ) | 
	 *                         (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)
	 *                     )
	 *                 )
	 *             )
	 *         ) | 
	 *         (
	 *             ownedMembership+=OwnedRedefinitionOrSubset 
	 *             (
	 *                 (
	 *                     (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)? 
	 *                     ((value=Expression ownedMembership+=ClassMember*) | ownedMembership+=ClassMember+)?
	 *                 ) | 
	 *                 (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)
	 *             )
	 *         )
	 *     )
	 */
	protected void sequence_NamedFeatureDefinition_UnnamedFeatureDefinition(ISerializationContext context, Feature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralInteger
	 *     BinaryExpression returns LiteralInteger
	 *     BinaryExpression.OperatorExpression_1_0 returns LiteralInteger
	 *     UnaryExpression returns LiteralInteger
	 *     SequenceAccessExpression returns LiteralInteger
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns LiteralInteger
	 *     PrimaryExpression returns LiteralInteger
	 *     LiteralExpression returns LiteralInteger
	 *     NaturalLiteralExpression returns LiteralInteger
	 *     UnlimitedNaturalLiteralExpression returns LiteralInteger
	 *
	 * Constraint:
	 *     value=NATURAL_VALUE
	 */
	protected void sequence_NaturalLiteralExpression(ISerializationContext context, LiteralInteger semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.LITERAL_INTEGER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.LITERAL_INTEGER__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNaturalLiteralExpressionAccess().getValueNATURAL_VALUETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     NonFeatureMember returns Membership
	 *     ClassMember returns Membership
	 *     AssociationMember returns Membership
	 *
	 * Constraint:
	 *     (
	 *         ownedElement+=Comment* 
	 *         visibility=VisibilityIndicator? 
	 *         (ownedMemberElement=NonFeatureDefinition | (memberName=Name? memberElement=[Element|QualifiedName]))
	 *     )
	 */
	protected void sequence_NonFeatureMember(ISerializationContext context, Membership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PackageMember returns Membership
	 *
	 * Constraint:
	 *     (
	 *         (
	 *             ownedElement+=Comment* 
	 *             visibility=VisibilityIndicator? 
	 *             (ownedMemberElement=NonFeatureDefinition | (memberName=Name? memberElement=[Element|QualifiedName]))
	 *         ) | 
	 *         (
	 *             ownedElement+=Comment* 
	 *             visibility=VisibilityIndicator? 
	 *             (
	 *                 ownedMemberElement=NamedFeatureDefinition | 
	 *                 ownedMemberElement=UnnamedFeatureDefinition | 
	 *                 ((memberName=Name | memberName=Name)? memberElement=[Feature|QualifiedName])
	 *             )
	 *         )
	 *     )
	 */
	protected void sequence_NonFeatureMember_PackagedFeatureMember(ISerializationContext context, Membership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralNull
	 *     BinaryExpression returns LiteralNull
	 *     BinaryExpression.OperatorExpression_1_0 returns LiteralNull
	 *     UnaryExpression returns LiteralNull
	 *     SequenceAccessExpression returns LiteralNull
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns LiteralNull
	 *     PrimaryExpression returns LiteralNull
	 *     LiteralExpression returns LiteralNull
	 *     NullLiteralExpression returns LiteralNull
	 *
	 * Constraint:
	 *     {LiteralNull}
	 */
	protected void sequence_NullLiteralExpression(ISerializationContext context, LiteralNull semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     OwnedGeneralization returns Membership
	 *
	 * Constraint:
	 *     ownedMemberElement=Generalization
	 */
	protected void sequence_OwnedGeneralization(ISerializationContext context, Membership semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.MEMBERSHIP__OWNED_MEMBER_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.MEMBERSHIP__OWNED_MEMBER_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOwnedGeneralizationAccess().getOwnedMemberElementGeneralizationParserRuleCall_0(), semanticObject.getOwnedMemberElement());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     OwnedRedefinitionOrSubset returns Membership
	 *
	 * Constraint:
	 *     (ownedMemberElement=Redefinition | ownedMemberElement=Subset)
	 */
	protected void sequence_OwnedRedefinitionOrSubset(ISerializationContext context, Membership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnCommentedUnitDefinition returns Package
	 *     PackageDefinition returns Package
	 *     PackageDefinitionOrStub returns Package
	 *     NonFeatureDefinition returns Package
	 *
	 * Constraint:
	 *     (name=Name ownedMembership+=PackageMember*)
	 */
	protected void sequence_PackageDefinition(ISerializationContext context, org.omg.sysml.lang.sysml.Package semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PackagedFeatureMember returns Membership
	 *
	 * Constraint:
	 *     (
	 *         ownedElement+=Comment* 
	 *         visibility=VisibilityIndicator? 
	 *         (
	 *             ownedMemberElement=NamedFeatureDefinition | 
	 *             ownedMemberElement=UnnamedFeatureDefinition | 
	 *             ((memberName=Name | memberName=Name)? memberElement=[Feature|QualifiedName])
	 *         )
	 *     )
	 */
	protected void sequence_PackagedFeatureMember(ISerializationContext context, Membership semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralReal
	 *     BinaryExpression returns LiteralReal
	 *     BinaryExpression.OperatorExpression_1_0 returns LiteralReal
	 *     UnaryExpression returns LiteralReal
	 *     SequenceAccessExpression returns LiteralReal
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns LiteralReal
	 *     PrimaryExpression returns LiteralReal
	 *     LiteralExpression returns LiteralReal
	 *     RealLiteralExpression returns LiteralReal
	 *
	 * Constraint:
	 *     value=RealValue
	 */
	protected void sequence_RealLiteralExpression(ISerializationContext context, LiteralReal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.LITERAL_REAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.LITERAL_REAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRealLiteralExpressionAccess().getValueRealValueParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Redefinition returns Redefinition
	 *
	 * Constraint:
	 *     redefinedFeature=[Feature|QualifiedName]
	 */
	protected void sequence_Redefinition(ISerializationContext context, Redefinition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.REDEFINITION__REDEFINED_FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.REDEFINITION__REDEFINED_FEATURE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRedefinitionAccess().getRedefinedFeatureFeatureQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(SysMLPackage.Literals.REDEFINITION__REDEFINED_FEATURE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns SequenceAccessExpression
	 *     BinaryExpression returns SequenceAccessExpression
	 *     BinaryExpression.OperatorExpression_1_0 returns SequenceAccessExpression
	 *     UnaryExpression returns SequenceAccessExpression
	 *     SequenceAccessExpression returns SequenceAccessExpression
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns SequenceAccessExpression
	 *     PrimaryExpression returns SequenceAccessExpression
	 *
	 * Constraint:
	 *     (primary=SequenceAccessExpression_SequenceAccessExpression_1_0 index=Expression)
	 */
	protected void sequence_SequenceAccessExpression(ISerializationContext context, SequenceAccessExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.SEQUENCE_ACCESS_EXPRESSION__PRIMARY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.SEQUENCE_ACCESS_EXPRESSION__PRIMARY));
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.SEQUENCE_ACCESS_EXPRESSION__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.SEQUENCE_ACCESS_EXPRESSION__INDEX));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSequenceAccessExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_0(), semanticObject.getPrimary());
		feeder.accept(grammarAccess.getSequenceAccessExpressionAccess().getIndexExpressionParserRuleCall_1_2_0(), semanticObject.getIndex());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns SequenceConstructionExpression
	 *     BinaryExpression returns SequenceConstructionExpression
	 *     BinaryExpression.OperatorExpression_1_0 returns SequenceConstructionExpression
	 *     UnaryExpression returns SequenceConstructionExpression
	 *     SequenceAccessExpression returns SequenceConstructionExpression
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns SequenceConstructionExpression
	 *     PrimaryExpression returns SequenceConstructionExpression
	 *     SequenceConstructionExpression returns SequenceConstructionExpression
	 *
	 * Constraint:
	 *     (element+=Expression element+=Expression*)?
	 */
	protected void sequence_SequenceConstructionExpression(ISerializationContext context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralString
	 *     BinaryExpression returns LiteralString
	 *     BinaryExpression.OperatorExpression_1_0 returns LiteralString
	 *     UnaryExpression returns LiteralString
	 *     SequenceAccessExpression returns LiteralString
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns LiteralString
	 *     PrimaryExpression returns LiteralString
	 *     LiteralExpression returns LiteralString
	 *     StringLiteralExpression returns LiteralString
	 *
	 * Constraint:
	 *     value=STRING_VALUE
	 */
	protected void sequence_StringLiteralExpression(ISerializationContext context, LiteralString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.LITERAL_STRING__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.LITERAL_STRING__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringLiteralExpressionAccess().getValueSTRING_VALUETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Subset returns Subset
	 *
	 * Constraint:
	 *     subsettedFeature=[Feature|QualifiedName]
	 */
	protected void sequence_Subset(ISerializationContext context, Subset semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.SUBSET__SUBSETTED_FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.SUBSET__SUBSETTED_FEATURE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubsetAccess().getSubsettedFeatureFeatureQualifiedNameParserRuleCall_0_1(), semanticObject.eGet(SysMLPackage.Literals.SUBSET__SUBSETTED_FEATURE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     UnitMember returns Membership
	 *
	 * Constraint:
	 *     ownedMemberElement=UnCommentedUnitDefinition
	 */
	protected void sequence_UnitMember(ISerializationContext context, Membership semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SysMLPackage.Literals.MEMBERSHIP__OWNED_MEMBER_ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SysMLPackage.Literals.MEMBERSHIP__OWNED_MEMBER_ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getUnitMemberAccess().getOwnedMemberElementUnCommentedUnitDefinitionParserRuleCall_0(), semanticObject.getOwnedMemberElement());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns LiteralUnbounded
	 *     BinaryExpression returns LiteralUnbounded
	 *     BinaryExpression.OperatorExpression_1_0 returns LiteralUnbounded
	 *     UnaryExpression returns LiteralUnbounded
	 *     SequenceAccessExpression returns LiteralUnbounded
	 *     SequenceAccessExpression.SequenceAccessExpression_1_0 returns LiteralUnbounded
	 *     PrimaryExpression returns LiteralUnbounded
	 *     LiteralExpression returns LiteralUnbounded
	 *     UnlimitedNaturalLiteralExpression returns LiteralUnbounded
	 *
	 * Constraint:
	 *     {LiteralUnbounded}
	 */
	protected void sequence_UnlimitedNaturalLiteralExpression(ISerializationContext context, LiteralUnbounded semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     UnnamedFeatureDefinition returns Feature
	 *
	 * Constraint:
	 *     (
	 *         ownedMembership+=OwnedRedefinitionOrSubset 
	 *         (
	 *             (
	 *                 (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)? 
	 *                 ((value=Expression ownedMembership+=ClassMember*) | ownedMembership+=ClassMember+)?
	 *             ) | 
	 *             (lower=NaturalLiteralExpression? upper=UnlimitedNaturalLiteralExpression)
	 *         )
	 *     )
	 */
	protected void sequence_UnnamedFeatureDefinition(ISerializationContext context, Feature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
