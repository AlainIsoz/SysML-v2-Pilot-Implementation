/*****************************************************************************
 * SysML 2 Pilot Implementation, PlantUML Visualization
 * Copyright (c) 2020 Mgnite Inc.
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
 * Contributors:
 *  Hisashi Miyashita, Mgnite Inc.
 * 
 *****************************************************************************/

package org.omg.sysml.plantuml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.omg.sysml.lang.sysml.ActionDefinition;
import org.omg.sysml.lang.sysml.ActionUsage;
import org.omg.sysml.lang.sysml.AnalysisCaseUsage;
import org.omg.sysml.lang.sysml.AttributeUsage;
import org.omg.sysml.lang.sysml.BindingConnector;
import org.omg.sysml.lang.sysml.Definition;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureMembership;
import org.omg.sysml.lang.sysml.FeatureTyping;
import org.omg.sysml.lang.sysml.IndividualUsage;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.ObjectiveMembership;
import org.omg.sysml.lang.sysml.PartUsage;
import org.omg.sysml.lang.sysml.ReferenceUsage;
import org.omg.sysml.lang.sysml.RequirementUsage;
import org.omg.sysml.lang.sysml.StateDefinition;
import org.omg.sysml.lang.sysml.StateUsage;
import org.omg.sysml.lang.sysml.SubjectMembership;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.TransitionUsage;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.Usage;
import org.omg.sysml.lang.sysml.VariantMembership;

public class VCompartment extends VStructure {
    private List<VTree> subtrees = new ArrayList<VTree>();

    private Element base;
    private VTree parent;

    protected boolean rec(Element e, boolean force) {
        VTree subtree = parent.subtree(base, e, force);
        if (subtree == null) return false;
        subtrees.add(subtree);
        return true;
    }

    private static class FeatureEntry implements Comparable<FeatureEntry> {
        public final Feature f;
        public final String alias;
        public final String prefix;

        private static int featureMetaclassCompare(Feature f1, Feature f2) {
            if (f1 instanceof AttributeUsage) {
                if (!(f2 instanceof AttributeUsage)) {
                    return -1;
                }
            } else if (f2 instanceof AttributeUsage) {
                return 1;
            } else if (f1 instanceof Usage) {
                if (!(f2 instanceof Usage)) {
                    return -1;
                }
            } else if (f2 instanceof Usage) {
                return 1;
            }
            
            String ec1 = f1.eClass().getName();
            String ec2 = f2.eClass().getName();
            return ec1.compareTo(ec2);
        }

        /*
        private static int featureTypeCompare(Feature f1, Feature f2) {
            List<Type> ts1 = f1.getType();
            List<Type> ts2 = f2.getType();
        }
        */

        private static int featureNameCompare(Feature f1, Feature f2) {
            String name1 = f1.getName();
            String name2 = f2.getName();
            if (name1 == null) {
                if (name2 == null) return 0;
                return -1;
            }
            if (name2 == null) return 1;
            return name1.compareTo(name2);
        }

        private static int featureCompare(Feature f1, Feature f2) {
            int v = featureMetaclassCompare(f1, f2);
            if (v != 0) return v;
            return featureNameCompare(f1, f2);
        }

        public int compareTo(FeatureEntry o) {
            int v = featureCompare(f, o.f);
            if (v != 0) return v;
            if (alias == null) {
                if (o.alias == null) return 0;
                return -1;
            }
            if (o.alias == null) return 1;
            return alias.compareTo(o.alias);
        }

        public FeatureEntry(Feature f, String alias, String prefix) {
            this.f = f;
            this.alias = alias;
            this.prefix = prefix;
        }
    }

    private List<FeatureEntry> featureEntries = new ArrayList<FeatureEntry>();

    protected void addFeature(Feature f,
                              String alias,
                              String prefix,
                              boolean nocheck,
                              boolean norec) {
        if (!nocheck && getFeatureName(f) == null) return;
        if (!norec && (alias == null) && (prefix == null)) {
            if (rec(f, false)) return;
        }
        featureEntries.add(new FeatureEntry(f, alias, prefix));
    }

    protected void addFeature(Feature f,
                              String alias) {
        addFeature(f, alias, null, false, false);
    }


    @Override
    public String caseFeature(Feature f) {
        addFeature(f, null);
        return "";
    }

    @Override
    public String casePartUsage(PartUsage pu) {
        rec(pu, true);
        return "";
    }

    @Override
    public String caseTransitionUsage(TransitionUsage tu) {
        addFeature(tu, null, null, false, true);
        return "";
    }

    @Override
    public String caseReferenceUsage(ReferenceUsage ru) {
        rec(ru, false);
        return "";
    }

    @Override
    public String caseRequirementUsage(RequirementUsage ru) {
        rec(ru, true);
        return "";
    }

    @Override
    public String caseIndividualUsage(IndividualUsage iu) {
        rec(iu, true);
        return "";
    }

    @Override
    public String caseAnalysisCaseUsage(AnalysisCaseUsage au) {
        rec(au, true);
        return "";
    }

    @Override
    public String caseDefinition(Definition d) {
        rec(d, true);
        return "";
    }

    @Override
    public String caseMembership(Membership m) {
        Element e = m.getMemberElement();
        if (e instanceof Feature) {
            addFeature((Feature) e, m.getMemberName());
        } else {
            rec(e, true);
        }
        return "";
    }

    @Override
    public String caseVariantMembership(VariantMembership vm) {
        rec(vm, true);
        return "";
    }

    @Override
    public String caseObjectiveMembership(ObjectiveMembership om) {
        rec(om, true);
        return "";
    }

    private static boolean isEmptyFeature(Feature f) {
        for (FeatureMembership fm: f.getOwnedFeatureMembership()) {
            if (fm.getMemberFeature() instanceof BindingConnector) continue;
            return false;
        }
        return true;
    }

    @Override
    public String caseSubjectMembership(SubjectMembership sm) {
        Usage u = sm.getOwnedSubjectParameter();
        boolean added = false;
        for (FeatureTyping ft: u.getOwnedTyping()) {
            Type typ = ft.getType();
            addPRelation(base, typ, sm, "<<subject>>");
            added = true;
        }
        if (!added) {
            if (u instanceof ReferenceUsage) {
                // Do not show empty ReferenceUsage.
                if (isEmptyFeature(u)) return "";
            }
            addFeature(u, null);
        }
        return "";
    }

    private static String getTitle(Feature f) {
        String s = SysML2PlantUMLText.getStereotypeName(f);
        if (s.endsWith("s")) {
            return s + "es";
        } else {
            return s + "s";
        }
    }

    private void addFeatures() {
        Collections.sort(featureEntries);
        
        final int size = featureEntries.size();
        EClass ec0 = null;
        for (int i = 0; i < size; i++) {
            FeatureEntry fe = featureEntries.get(i);
            EClass ec1 = fe.f.eClass();
            if (!ec1.equals(ec0)) {
                ec0 = ec1;
                if (!ec1.equals(SysMLPackage.Literals.ATTRIBUTE_USAGE)) {
                    append("--");
                    append(getTitle(fe.f));
                    append("--\n");
                }
            }
            if (fe.prefix != null) {
                append(fe.prefix);
            }
            if (getFeatureName(fe.f) == null) {
                addAnonymouseFeatureText(fe.f);
                append('\n');
            } else if (addFeatureText(fe.f)) {
                boolean first = true;
                for (int j = i + 1; j < size; j++) {
                    FeatureEntry fe2 = featureEntries.get(j);
                    if (fe.f.equals(fe2.f)) {
                        if (fe2.alias != null) {
                            if (first) append(" <b>as</b> ");
                            append(fe2.alias);
                            append(' ');
                            first = false;
                        }
                        i = j;
                    } else {
                        break;
                    }
                }
                append('\n');
            }
        }
    }

    public void startType(Type typ) {
        this.base = typ;
        traverse(typ);
        addFeatures();
    }

    public List<VTree> process(VTree parent, Type typ) {
        this.parent = parent;
        subtrees.clear();
        featureEntries.clear();
        startType(typ);
        return subtrees;
    }

    public VCompartment(Visitor prev) {
        super(prev);
    }


    private boolean mixedMode = false;

    void setMixedMode(boolean flag) {
        this.mixedMode = flag;
    }

    @Override
    public String caseStateDefinition(StateDefinition sd) {
        if (!mixedMode) return null;
        rec(sd, true);
        return "";
    }

    @Override
    public String caseStateUsage(StateUsage su) {
        if (!mixedMode) return null;
        rec(su, true);
        return "";
    }

    @Override
    public String caseActionDefinition(ActionDefinition ad) {
        if (!mixedMode) return null;
        rec(ad, true);
        return "";
    }

    @Override
    public String caseActionUsage(ActionUsage au) {
        if (!mixedMode) return null;
        rec(au, true);
        return "";
    }
}
