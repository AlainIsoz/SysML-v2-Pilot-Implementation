/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2021 Model Driven Solutions, Inc.
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

package org.omg.sysml.adapter;

import java.util.Collections;
import java.util.List;

import org.omg.sysml.lang.sysml.ActionDefinition;
import org.omg.sysml.lang.sysml.ActionUsage;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureMembership;
import org.omg.sysml.lang.sysml.StateSubactionMembership;
import org.omg.sysml.lang.sysml.TransitionFeatureMembership;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.util.TypeUtil;

public class ActionUsageAdapter extends OccurrenceUsageAdapter {
	
	public static final String STATE_BASE = "States::StateAction";
	public static final String TRANSITION_BASE = "States::TransitionAction";
	public static final String[] TRANSITION_REDEFINED_FEATURES = {"accepter", "guard", "effect"};
	
	public ActionUsageAdapter(ActionUsage element) {
		super(element);
	}
	
	// Implicit Generalization
	
	@Override
	public ActionUsage getTarget() {
		return (ActionUsage)super.getTarget();
	}

	@Override
	protected String getDefaultSupertype() {
		return isSubaction()? 
					getDefaultSupertype("subaction"):
					getDefaultSupertype("base");
	}
	
	public boolean isSubaction() {
		Type owningType = getTarget().getOwningType();
		return owningType instanceof ActionDefinition || owningType instanceof ActionUsage;
	}
	
	// Computed Redefinition
	
	@Override
	public List<? extends Feature> getRelevantFeatures() {
		return TypeUtil.getItemFeaturesOf(getTarget());
	}	
	
	@Override
	protected List<? extends Feature> getRelevantFeatures(Type type) {
		ActionUsage target = getTarget();
		String redefinedFeature = getRedefinedFeature(target);
		return redefinedFeature == null? super.getRelevantFeatures(type):
			   type == target.getOwningType()? Collections.singletonList(target):
			   Collections.singletonList((Feature)getLibraryType(redefinedFeature));
	}
	
	protected static String getRedefinedFeature(Feature target) {
		FeatureMembership membership = target.getOwningFeatureMembership();
		return membership instanceof StateSubactionMembership?
					STATE_BASE + "::" + ((StateSubactionMembership)membership).getKind().toString() + "Action": 
			   membership instanceof TransitionFeatureMembership? 
					TRANSITION_BASE + "::" + TRANSITION_REDEFINED_FEATURES[((TransitionFeatureMembership)membership).getKind().getValue()]: 
					null;
	}
	
}
