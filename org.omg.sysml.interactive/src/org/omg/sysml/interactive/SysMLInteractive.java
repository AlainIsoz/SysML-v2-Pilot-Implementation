/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2019-2021 Model Driven Solutions, Inc.
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
 *  Ed Seidewitz, MDS
 *  Hisashi Miyashita, Mgnite
 *  Zoltan Ujhelyi, MDS
 * 
 *****************************************************************************/
package org.omg.sysml.interactive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.omg.kerml.xtext.KerMLStandaloneSetup;
import org.omg.kerml.xtext.naming.KerMLQualifiedNameConverter;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.Namespace;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.util.SysMLLibraryUtil;
import org.omg.sysml.plantuml.SysML2PlantUMLLinkProvider;
import org.omg.sysml.plantuml.SysML2PlantUMLSvc;
import org.omg.sysml.util.SysMLUtil;
import org.omg.sysml.util.traversal.Traversal;
import org.omg.sysml.util.traversal.facade.impl.ApiElementProcessingFacade;
import org.omg.sysml.xtext.SysMLStandaloneSetup;

import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SysMLInteractive extends SysMLUtil {
	
	public static final String KERNEL_LIBRARY_DIRECTORY = "Kernel Library";
	public static final String SYSTEMS_LIBRARY_DIRECTORY = "Systems Library";
	public static final String DOMAIN_LIBRARIES_DIRECTORY = "Domain Libraries";
	public static final String QUANTITIES_AND_UNITS_DIRECTORY = DOMAIN_LIBRARIES_DIRECTORY + "/Quantities and Units";
	public static final String GEOMETRY_DIRECTORY = DOMAIN_LIBRARIES_DIRECTORY + "/Geometry";
	public static final String ANALYSIS_DIRECTORY = DOMAIN_LIBRARIES_DIRECTORY + "/Analysis";
	public static final String KERML_EXTENSION = ".kerml";
	public static final String SYSML_EXTENSION = ".sysml";
	
	protected static Injector injector;
	protected static SysMLInteractive instance = null;
		
	protected String apiBasePath = ApiElementProcessingFacade.DEFAULT_BASE_PATH;
	
	protected int counter = 1;
	protected XtextResource resource;
	
	protected Traversal traversal;
	
    protected SysML2PlantUMLSvc sysml2PlantUMLSvc;

    @Inject
	private IGlobalScopeProvider scopeProvider;
	
	@Inject
	private KerMLQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private IResourceValidator validator;
	
	@Inject
	private SysMLInteractive() {
		super(new StrictShadowingResourceDescriptionData());
	}
	
	public void loadLibrary(String path) {
		if (path != null) {
			if (!path.endsWith("/")) {
				path += "/";
			}
			SysMLLibraryUtil.setModelLibraryDirectory(path);
			this.readAll(path + KERNEL_LIBRARY_DIRECTORY, false, KERML_EXTENSION);
			this.readAll(path + SYSTEMS_LIBRARY_DIRECTORY, false, SYSML_EXTENSION);
			this.readAll(path + DOMAIN_LIBRARIES_DIRECTORY, false, SYSML_EXTENSION);
		}
	}
	
	public void setApiBasePath(String apiBasePath) {
		this.apiBasePath = apiBasePath;
	}
	
	public int next() {
		this.resource = (XtextResource)this.createResource(this.counter + SYSML_EXTENSION);
		this.addInputResource(this.resource);
		return this.counter++;
	}
	
	public XtextResource getResource() {
		return this.resource;
	}
	
	public void removeResource() {
		if (this.resource != null) {
			try {
				this.resource.delete(null);
				this.resource = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Element getRootElement() {
		XtextResource resource = this.getResource();
		if (resource == null) {
			return null;
		} else {
			final IParseResult result = resource.getParseResult();
			return result == null? null: (Element)result.getRootASTElement();
		}
	}
	
	public void parse(String input) throws IOException {
		XtextResource resource = this.getResource();
		if (resource != null) {
			resource.reparse(input);
		}
	}
	
	public List<Issue> validate() {
		XtextResource resource = this.getResource();
		return resource == null? Collections.emptyList():
			validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}
	
	public SysMLInteractiveResult eval(String input) {
		return eval(input, true);
	}
	
	public SysMLInteractiveResult eval(String input, boolean isAddResource) {
		this.next();
		try {
			this.parse(input);
			List<Issue> issues = this.validate();
			Element rootElement = this.getRootElement();
			SysMLInteractiveResult result = new SysMLInteractiveResult(rootElement, issues);
			if (result.hasErrors()) {
				this.removeResource();
			} else if (isAddResource) {
				this.addResourceToIndex(resource);
			}
			return result;
		} catch (Exception e) {
			this.removeResource();
			return new SysMLInteractiveResult(e);
		}
	}
	
	public Element resolve(String name) {
		List<Resource> resources = this.resourceSet.getResources();
		if (!resources.isEmpty()) {
			IScope scope = scopeProvider.getScope(
					resources.get(resources.size() - 1), 
					SysMLPackage.eINSTANCE.getNamespace_Member(), 
					Predicates.alwaysTrue());
			IEObjectDescription description = scope.getSingleElement(
					this.qualifiedNameConverter.toQualifiedName(name));
			if (description != null) {
				EObject object = description.getEObjectOrProxy();
				return object instanceof Element? (Element)object: null;
			}
		}
		return null;
	}
	
	public String listLibrary() {
		this.counter++;
		try {
			List<Membership> globalMemberships = 
					resourceSet.getResources().stream().
					filter(r->!inputResources.contains(r)).
					flatMap(r->r.getContents().stream()).
					filter(Namespace.class::isInstance).
					flatMap(n->((Namespace)n).publicMemberships().stream()).
					collect(Collectors.toList());
			return SysMLInteractiveUtil.formatMembershipList(globalMemberships);
		} catch (Exception e) {
			return SysMLInteractiveUtil.formatException(e);
		}
	}
	
	public String listQuery(String query) {
		if (!query.endsWith(";")) {
			query += ";";
		}
		SysMLInteractiveResult result = this.eval("import " + query, false);
		if (result.hasErrors()) {
			return result.toString();
		} else {
			List<Membership> memberships = ((Namespace)result.getRootElement()).publicMemberships();
			this.removeResource();
			return SysMLInteractiveUtil.formatMembershipList(memberships);
		}
	}
	
	public String list(String query) {
		return Strings.isNullOrEmpty(query)? listLibrary(): listQuery(query);
	}
	
	public String show(String name) {
		this.counter++;
		try {
			Element element = this.resolve(name);
			return element == null? "ERROR:Couldn't resolve reference to Element '" + name + "'\n":
					SysMLInteractiveUtil.formatTree(element);
		} catch (Exception e) {
			return SysMLInteractiveUtil.formatException(e);
		}
	}
	
	public String publish(String name) {
		this.counter++;
		try {
			Element element = this.resolve(name);
			if (element == null) {
				return "ERROR:Couldn't resolve reference to Element '" + name + "'\n";
			} else if (!inputResources.contains(element.eResource())) {
				return "ERROR:'" + name + "' is a library element\n";
			} else {
				String modelName = element.getName() + " " + new Date();
				ApiElementProcessingFacade processingFacade = this.getProcessingFacade(modelName);
				processingFacade.getTraversal().visit(element);
				processingFacade.commit();
				System.out.println();
				return "Saved to Project " + modelName + " (" + processingFacade.getProjectId() + ")\n";
			}
		} catch (Exception e) {
			return SysMLInteractiveUtil.formatException(e);
		}
	}
	
	protected ApiElementProcessingFacade getProcessingFacade(String modelName) {
		System.out.println("API base path: " + this.apiBasePath);
		ApiElementProcessingFacade processingFacade = new ApiElementProcessingFacade(modelName, this.apiBasePath);	
		processingFacade.setTraversal(new Traversal(processingFacade));
		return processingFacade;
	}
	
	public VizResult viz(List<String> names, List<String> views, List<String> styles) {
		this.counter++;
        List<EObject> elements = new ArrayList<EObject>(names.size());
		try {
            for (String name: names) {
                Element element = this.resolve(name);
                if (element != null) {
                    elements.add(element);
                } else {
                    return VizResult.unresolvedResult(name);
                }
            }
            if (!elements.isEmpty()) {
                SysML2PlantUMLSvc svc = getSysML2PlantUMLSvc();
                if (!views.isEmpty()) {
                    String view = views.get(0);
                    svc.setView(view);
                }

                List<String> fStyles = filterStyle(styles, "PUMLCODE");
                if (fStyles.size() != styles.size()) {
                    // --style PUMLCODE option
                    return VizResult.plantumlResult(svc.getPlantUMLCode(elements, fStyles));
                } else {
                    return VizResult.svgResult(svc.getSVG(elements, fStyles));
                }

            } else {
                return VizResult.emptyResult();
            }
		} catch (Exception e) {
			return VizResult.exceptionResult(e);
		}
	}
	
	protected VizResult viz(String name) {
		return this.viz(Collections.singletonList(name), Collections.emptyList(), Collections.singletonList("PUMLCODE"));
	}
	
    private static List<String> filterStyle(List<String> styles, String name) {
        return styles.stream()
            .filter(x -> !x.toUpperCase().equals(name))
            .collect(Collectors.toList());
    }

    private class LinkProvider implements SysML2PlantUMLLinkProvider {
    	private Map<EObject, UUID> elementMap = new HashMap<EObject, UUID>(); 

        @Override
        public String getLinkString(EObject eObj) {
        	UUID uuid = elementMap.get(eObj);
        	if (uuid == null) {
        		uuid = UUID.randomUUID();
        		elementMap.put(eObj,  uuid);
        	}

            return "psysml:" + uuid.toString();
        }

        @Override
        public String getText(EObject eObj) {
            ICompositeNode node = NodeModelUtils.getNode(eObj);
            if (node == null) return null;
            return node.getText();
        }
    }

    protected SysML2PlantUMLSvc getSysML2PlantUMLSvc() {
        if (sysml2PlantUMLSvc == null) {
            sysml2PlantUMLSvc = new SysML2PlantUMLSvc(new LinkProvider());
        }
        return sysml2PlantUMLSvc;
    }

	public void setGraphVizPath(String path) {
		getSysML2PlantUMLSvc().setGraphVizPath(path);
	}
	
	public void run(String input) {
		if (input != null && !input.isEmpty()) {
			System.out.print(this.eval(input));
		}
	}
	
	public void run() {
        try (Scanner in = new Scanner(System.in)) {
	        do {
	        	System.out.print(this.counter + "> ");
	        	String input = in.nextLine().trim();
	        	if (input.startsWith("%")) {
	        		if ("%".equals(input)) {
	        			input = "";
	        			String line = in.nextLine();
	        			while (!"%".equals(line.trim())) {
	        				if ("%%".equals(line.trim())) {
	        					input = null;
	        					break;
	        				}
	        				input += line + "\n";
	        				line = in.nextLine();
	        			}
		        		run(input);
	        		} else {
	        			int i = input.indexOf(' ');
	        			String command = i == -1? input: input.substring(0, i);
	        			String argument = i == -1? "": input.substring(i + 1).trim();
	        			
	        			if ("%exit".equals(command)) {
	        				break;
	        			} else if ("%list".equals(command)) {
	        				System.out.print(this.list(argument));
	        			} else if ("%show".equals(command)) {
	        				if (!"".equals(argument)) {
	        					System.out.print(this.show(argument));
	        				}
	        			} else if ("%publish".equals(command)) {
	        				if (!"".equals(argument)) {
	        					System.out.print(this.publish(argument));
	        				}
	        			} else if ("%viz".equals(command)) {
	        				if (!"".equals(argument)) {
	        					System.out.print(this.viz(argument));
	        				}
	        			} else {
	        				System.out.println("ERROR:Invalid command '" + input + "'");
	        			}
	        		}
	        	} else {
	        		run(input);
	        	}
	        } while(true);
        }
    }
	
	public static SysMLInteractive createInstance() {
		if (injector == null) {
			// Note: An EPackage must be registered to be sure the correctly configured
			// CompositeEValidator is used.
			EPackage.Registry.INSTANCE.put(SysMLPackage.eNS_URI, SysMLPackage.eINSTANCE);
			KerMLStandaloneSetup.doSetup();
			injector = new SysMLStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
		return injector.getInstance(SysMLInteractive.class);
	}
	
	public static SysMLInteractive getInstance() {
		if (instance == null) {
			instance = createInstance();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("SysML v2 Pilot Implementation");
		SysMLInteractive instance = getInstance();
		if (args.length > 0) {
			instance.loadLibrary(args[0]);
			if (args.length > 1) {
				instance.setApiBasePath(args[1]);
			}
		}
		instance.run();	
	}

}
