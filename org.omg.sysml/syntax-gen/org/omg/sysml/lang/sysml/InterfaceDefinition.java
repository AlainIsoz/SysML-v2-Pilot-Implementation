/**
 */
package org.omg.sysml.lang.sysml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>An InterfaceDefinition is a ConnectionDefinition all of whose ends are PortUsages, defining an interface between elements that interact through such ports.</p>
 * 
 * <p>An InterfaceDefinition must subclass, directly or indirectly, the base InterfaceDefinition Interface from the Systems model library.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.InterfaceDefinition#getInterfaceEnd <em>Interface End</em>}</li>
 * </ul>
 *
 * @see org.omg.sysml.lang.sysml.SysMLPackage#getInterfaceDefinition()
 * @model
 * @generated
 */
public interface InterfaceDefinition extends ConnectionDefinition {
	/**
	 * Returns the value of the '<em><b>Interface End</b></em>' reference list.
	 * The list contents are of type {@link org.omg.sysml.lang.sysml.PortUsage}.
	 * <p>
	 * This feature redefines the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.omg.sysml.lang.sysml.ConnectionDefinition#getConnectionEnd() <em>Connection End</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The PortUsages that are the <code>associationEnds</code> of this InterfaceDefinition.
	 * 
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface End</em>' reference list.
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getInterfaceDefinition_InterfaceEnd()
	 * @model lower="2" transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='interfaceDefinitionWithEnd'"
	 *        annotation="redefines"
	 * @generated
	 */
	EList<PortUsage> getInterfaceEnd();

} // InterfaceDefinition
