/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2022 Model Driven Solutions, Inc.
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *  
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 *******************************************************************************/
/**
 */
package org.omg.sysml.lang.sysml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.PartUsage;
import org.omg.sysml.lang.sysml.StakeholderMembership;
import org.omg.sysml.lang.sysml.SysMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Membership</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.StakeholderMembershipImpl#getOwnedStakeholderParameter <em>Owned Stakeholder Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StakeholderMembershipImpl extends ParameterMembershipImpl implements StakeholderMembership {
	/**
	 * The cached setting delegate for the '{@link #getOwnedStakeholderParameter() <em>Owned Stakeholder Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStakeholderParameter()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate OWNED_STAKEHOLDER_PARAMETER__ESETTING_DELEGATE = ((EStructuralFeature.Internal)SysMLPackage.Literals.STAKEHOLDER_MEMBERSHIP__OWNED_STAKEHOLDER_PARAMETER).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderMembershipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.STAKEHOLDER_MEMBERSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PartUsage getOwnedStakeholderParameter() {
		return (PartUsage)OWNED_STAKEHOLDER_PARAMETER__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartUsage basicGetOwnedStakeholderParameter() {
		return (PartUsage)OWNED_STAKEHOLDER_PARAMETER__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedStakeholderParameter(PartUsage newOwnedStakeholderParameter) {
		OWNED_STAKEHOLDER_PARAMETER__ESETTING_DELEGATE.dynamicSet(this, null, 0, newOwnedStakeholderParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedStakeholderParameter() {
		return basicGetOwnedStakeholderParameter() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getOwnedMemberParameter() {
		return getOwnedStakeholderParameter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature basicGetOwnedMemberParameter() {
		return basicGetOwnedStakeholderParameter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedMemberParameter(Feature newOwnedMemberParameter) {
		if (newOwnedMemberParameter != null && !(newOwnedMemberParameter instanceof PartUsage)) {
			throw new IllegalArgumentException("newOwnedMemberParameter must be an instance of PartUsage");
		}
		setOwnedStakeholderParameter((PartUsage) newOwnedMemberParameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedMemberParameter() {
  		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_STAKEHOLDER_PARAMETER:
				if (resolve) return getOwnedStakeholderParameter();
				return basicGetOwnedStakeholderParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_STAKEHOLDER_PARAMETER:
				setOwnedStakeholderParameter((PartUsage)newValue);
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
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_STAKEHOLDER_PARAMETER:
				setOwnedStakeholderParameter((PartUsage)null);
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
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_MEMBER_PARAMETER:
				return isSetOwnedMemberParameter();
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_STAKEHOLDER_PARAMETER:
				return isSetOwnedStakeholderParameter();
		}
		return super.eIsSet(featureID);
	}

} //StakeholderMembershipImpl
