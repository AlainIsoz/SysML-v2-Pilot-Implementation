/**
 */
package org.omg.sysml.lang.sysml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.ViewUsage;

/**
 * This is the item provider adapter for a {@link org.omg.sysml.lang.sysml.ViewUsage} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewUsageItemProvider extends PartUsageItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewUsageItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addViewDefinitionPropertyDescriptor(object);
			addSatisfiedViewpointPropertyDescriptor(object);
			addExposedElementPropertyDescriptor(object);
			addViewRenderingPropertyDescriptor(object);
			addViewConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the View Definition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addViewDefinitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewUsage_viewDefinition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewUsage_viewDefinition_feature", "_UI_ViewUsage_type"),
				 SysMLPackage.Literals.VIEW_USAGE__VIEW_DEFINITION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Satisfied Viewpoint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSatisfiedViewpointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewUsage_satisfiedViewpoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewUsage_satisfiedViewpoint_feature", "_UI_ViewUsage_type"),
				 SysMLPackage.Literals.VIEW_USAGE__SATISFIED_VIEWPOINT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Exposed Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExposedElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewUsage_exposedElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewUsage_exposedElement_feature", "_UI_ViewUsage_type"),
				 SysMLPackage.Literals.VIEW_USAGE__EXPOSED_ELEMENT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the View Rendering feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addViewRenderingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewUsage_viewRendering_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewUsage_viewRendering_feature", "_UI_ViewUsage_type"),
				 SysMLPackage.Literals.VIEW_USAGE__VIEW_RENDERING,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the View Condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addViewConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewUsage_viewCondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewUsage_viewCondition_feature", "_UI_ViewUsage_type"),
				 SysMLPackage.Literals.VIEW_USAGE__VIEW_CONDITION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns ViewUsage.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ViewUsage"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ViewUsage)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ViewUsage_type") :
			getString("_UI_ViewUsage_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == SysMLPackage.Literals.ELEMENT__OWNED_RELATIONSHIP ||
			childFeature == SysMLPackage.Literals.NAMESPACE__OWNED_MEMBERSHIP ||
			childFeature == SysMLPackage.Literals.ELEMENT__OWNED_ANNOTATION ||
			childFeature == SysMLPackage.Literals.NAMESPACE__OWNED_IMPORT ||
			childFeature == SysMLPackage.Literals.FEATURE__OWNED_FEATURE_INVERTING ||
			childFeature == SysMLPackage.Literals.TYPE__OWNED_SPECIALIZATION ||
			childFeature == SysMLPackage.Literals.TYPE__OWNED_CONJUGATOR ||
			childFeature == SysMLPackage.Literals.TYPE__OWNED_INTERSECTING ||
			childFeature == SysMLPackage.Literals.TYPE__OWNED_UNIONING ||
			childFeature == SysMLPackage.Literals.TYPE__OWNED_DISJOINING ||
			childFeature == SysMLPackage.Literals.TYPE__OWNED_DIFFERENCING ||
			childFeature == SysMLPackage.Literals.FEATURE__OWNED_TYPE_FEATURING ||
			childFeature == SysMLPackage.Literals.FEATURE__OWNED_FEATURE_CHAINING ||
			childFeature == SysMLPackage.Literals.USAGE__VARIANT_MEMBERSHIP;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
