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
 *  
 *******************************************************************************/

package org.omg.sysml.delegate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.omg.sysml.lang.sysml.ElementFilterMembership;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Package;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.util.NamespaceUtil;
import org.omg.sysml.util.NonNotifyingEObjectEList;

public class Package_filterCondition_SettingDelegate extends BasicDerivedListSettingDelegate  {

	public Package_filterCondition_SettingDelegate(EStructuralFeature eStructuralFeature) {
		super(eStructuralFeature);
	}

	@Override
	protected EList<?> basicGet(InternalEObject owner) {
		EList<Expression> filterConditions = new NonNotifyingEObjectEList<>(Expression.class, owner, SysMLPackage.PACKAGE__FILTER_CONDITION);
		NamespaceUtil.getOwnedMembersByMembershipIn((Package)owner, ElementFilterMembership.class, Expression.class).forEachOrdered(filterConditions::add);
		return filterConditions;
	}

}
