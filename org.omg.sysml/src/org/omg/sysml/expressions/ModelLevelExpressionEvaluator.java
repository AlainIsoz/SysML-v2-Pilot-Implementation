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

package org.omg.sysml.expressions;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.omg.sysml.expressions.functions.LibraryFunction;
import org.omg.sysml.expressions.util.EvaluationUtil;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureReferenceExpression;
import org.omg.sysml.lang.sysml.InvocationExpression;
import org.omg.sysml.lang.sysml.LiteralExpression;
import org.omg.sysml.lang.sysml.NullExpression;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.util.ExpressionUtil;
import org.omg.sysml.util.FeatureUtil;
import org.omg.sysml.util.TypeUtil;

import com.google.common.base.Predicates;

public class ModelLevelExpressionEvaluator {
	
	public static final ModelLevelExpressionEvaluator INSTANCE = new ModelLevelExpressionEvaluator();

	protected LibraryFunctionFactory libraryFunctionFactory = LibraryFunctionFactory.INSTANCE;
	
	public LibraryFunctionFactory getLibraryFunctionFactory() {
		return libraryFunctionFactory;
	}
	
	public void setLibraryFunctionFactory(LibraryFunctionFactory libraryFunctionFactory) {
		this.libraryFunctionFactory = libraryFunctionFactory;
	}
	
	public EList<Element> evaluate(Expression expression, Element target) {
		if (expression instanceof NullExpression) {
			return evaluateNull((NullExpression)expression, target);
		} else if (expression instanceof LiteralExpression) {
			return evaluateLiteral((LiteralExpression)expression, target);
		} else if (expression instanceof FeatureReferenceExpression) {
			return evaluateFeatureReference((FeatureReferenceExpression)expression, target);
		} else if (expression instanceof InvocationExpression) {
			return evaluateInvocation((InvocationExpression)expression, target);
		} else {
			return new BasicEList<>();
		}		
	}
	
	public EList<Element> evaluateNull(NullExpression expression, Element target) {
		return EvaluationUtil.nullList();
	}
	
	public EList<Element> evaluateLiteral(LiteralExpression expression, Element target) {
		return EvaluationUtil.singletonList(expression);
	}
	
	public EList<Element> evaluateFeatureReference(FeatureReferenceExpression expression, Element target) {
		Feature referent = expression.getReferent();
		return referent == null? null:
			   evaluateFeature(referent, target instanceof Type? (Type)target: null);
	}
	
	public EList<Element> evaluateInvocation(InvocationExpression expression, Element target) {
		LibraryFunction function = libraryFunctionFactory.getLibraryFunction(expression.getFunction());
		return function == null? null: function.invoke(expression, target);
	}
	
	public EList<Element> evaluateFeature(Feature feature, Type type) {
		if (type != null && TypeUtil.conforms(feature, ExpressionUtil.getSelfReferenceFeature(feature))) {
			// Evaluate "self" feature.
			return EvaluationUtil.singletonList(EvaluationUtil.getTargetFeatureFor(type));
		} else if (!feature.getOwnedFeatureChaining().isEmpty()) {
			// Evaluate feature with a feature chain.
			return evaluateFeatureChain(feature.getChainingFeature(), type);
		} else {
			// Evaluate regular feature.
			// Note: If "type" has a feature chain, than this represents a nested context, to be searched
			// in reverse from the last to the first chaining feature.
			List<? extends Type> types =
				type instanceof Feature && !((Feature) type).getOwnedFeatureChaining().isEmpty()?
					((Feature)type).getChainingFeature():
					Collections.singletonList(type);
			Collections.reverse(types);
			return types.stream().
					map(t->EvaluationUtil.getValueExpressionFor(feature, t)).
					filter(Predicates.notNull()).
					map(v->evaluate(v, type)).
					filter(Predicates.notNull()).
					findFirst().
					orElseGet(()->EvaluationUtil.singletonList(feature));
		}
	}
	
	public EList<Element> evaluateFeatureChain(List<Feature> chainingFeatures, Type type) {
		EList<Element> values = evaluateFeature(chainingFeatures.get(0), type);
		if (chainingFeatures.size() == 1) {
			return values;
		} else {
			// Evaluate the chain of features other than the first, with each value from the
			// result of evaluating the first chaining feature.
			List<Feature> subchainingFeatures = chainingFeatures.subList(1, chainingFeatures.size());
			EList<Element> result = new BasicEList<>();
			for (Element value: values) {
				EList<Element> featureValue = null;
				if (value instanceof Type) {
					Type target = value instanceof Feature? 
							FeatureUtil.chainFeatures(EvaluationUtil.getTargetFeatureFor(type), (Feature)value): 
							(Type)value;
					featureValue = evaluateFeatureChain(subchainingFeatures, target);
				}
				if (featureValue == null) {
					result.add(FeatureUtil.chainFeatures((Feature)value, FeatureUtil.chainFeatures(subchainingFeatures)));
				} else {
					result.addAll(featureValue);
				}
			}
			return result;
		}
	}
	
}
