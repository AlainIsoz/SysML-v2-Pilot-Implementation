/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2020-2021 Model Driven Solutions, Inc.
 *    
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *  
 * You should have received a copy of theGNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *  
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 *  
 *******************************************************************************/
/**
 */
package org.omg.sysml.lang.sysml.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.common.util.DerivedEObjectEList;
import org.omg.sysml.lang.sysml.BindingConnector;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.Function;
import org.omg.sysml.lang.sysml.ReturnParameterMembership;
import org.omg.sysml.lang.sysml.CalculationDefinition;
import org.omg.sysml.lang.sysml.CalculationUsage;
import org.omg.sysml.lang.sysml.Step;
import org.omg.sysml.lang.sysml.SysMLFactory;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.CalculationDefinitionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.CalculationDefinitionImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.CalculationDefinitionImpl#getCalculation <em>Calculation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CalculationDefinitionImpl extends ActionDefinitionImpl implements CalculationDefinition {

	public static final String CALCULATION_DEFINITION_SUPERCLASS_DEFAULT = "Calculations::Calculation";

	/**
	 * The cached value of the BindingConnector from the result of the last
	 * sub-Expression to the result of this FunctionDefinition.
	 */
	protected BindingConnector resultConnector = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CalculationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.CALCULATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Expression> getExpression() {
		return new DerivedEObjectEList<Expression>(Expression.class, this, SysMLPackage.CALCULATION_DEFINITION__EXPRESSION,
				new int[] { SysMLPackage.TYPE__FEATURE });
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpression() {
		return !getExpression().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature getResult() {
		Feature result = basicGetResult();
		return result != null && result.eIsProxy() ? (Feature)eResolveProxy((InternalEObject)result) : result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Feature basicGetResult() {
		return getOwnedResultParameter();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setResult(Feature newResult) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<CalculationUsage> getCalculation() {
		return new DerivedEObjectEList<CalculationUsage>(CalculationUsage.class, this, SysMLPackage.CALCULATION_DEFINITION__CALCULATION,
				new int[] { SysMLPackage.TYPE__FEATURE });
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Step> getStep() {
		@SuppressWarnings("unchecked")
		EList<Step> expression = (EList<Step>)((EList<?>)getExpression());
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStep() {
  		return false;
	}

	protected String getDefaultSupertype() {
		return CALCULATION_DEFINITION_SUPERCLASS_DEFAULT;
	}
	
	public BindingConnector getResultConnector() {
		return resultConnector;
	}
	
	// Other methods
	
	public static void addResultParameter(Type type) {
		if (type.getOwnedFeatureMembership().stream().noneMatch(ReturnParameterMembership.class::isInstance)) {
			ReturnParameterMembership membership = SysMLFactory.eINSTANCE.createReturnParameterMembership();
			Feature resultParameter = SysMLFactory.eINSTANCE.createReferenceUsage();
			membership.setOwnedMemberParameter_comp(resultParameter);
			type.getOwnedFeatureMembership_comp().add(membership);
			((FeatureImpl)resultParameter).transform();
		}
	}
	
	@Override
	public void transform() {
		super.transform();
		addResultParameter(this);
		resultConnector = BlockExpressionImpl.getOrCreateResultConnectorFor(this, resultConnector, this.getResult());
	}
	
	//

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SysMLPackage.CALCULATION_DEFINITION__EXPRESSION:
				return getExpression();
			case SysMLPackage.CALCULATION_DEFINITION__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case SysMLPackage.CALCULATION_DEFINITION__CALCULATION:
				return getCalculation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SysMLPackage.CALCULATION_DEFINITION__EXPRESSION:
				getExpression().clear();
				getExpression().addAll((Collection<? extends Expression>)newValue);
				return;
			case SysMLPackage.CALCULATION_DEFINITION__RESULT:
				setResult((Feature)newValue);
				return;
			case SysMLPackage.CALCULATION_DEFINITION__CALCULATION:
				getCalculation().clear();
				getCalculation().addAll((Collection<? extends CalculationUsage>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SysMLPackage.CALCULATION_DEFINITION__EXPRESSION:
				getExpression().clear();
				return;
			case SysMLPackage.CALCULATION_DEFINITION__RESULT:
				setResult((Feature)null);
				return;
			case SysMLPackage.CALCULATION_DEFINITION__CALCULATION:
				getCalculation().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SysMLPackage.CALCULATION_DEFINITION__STEP:
				return isSetStep();
			case SysMLPackage.CALCULATION_DEFINITION__EXPRESSION:
				return isSetExpression();
			case SysMLPackage.CALCULATION_DEFINITION__RESULT:
				return basicGetResult() != null;
			case SysMLPackage.CALCULATION_DEFINITION__CALCULATION:
				return !getCalculation().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Function.class) {
			switch (derivedFeatureID) {
				case SysMLPackage.CALCULATION_DEFINITION__EXPRESSION: return SysMLPackage.FUNCTION__EXPRESSION;
				case SysMLPackage.CALCULATION_DEFINITION__RESULT: return SysMLPackage.FUNCTION__RESULT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Function.class) {
			switch (baseFeatureID) {
				case SysMLPackage.FUNCTION__EXPRESSION: return SysMLPackage.CALCULATION_DEFINITION__EXPRESSION;
				case SysMLPackage.FUNCTION__RESULT: return SysMLPackage.CALCULATION_DEFINITION__RESULT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CalculationDefinitionImpl
