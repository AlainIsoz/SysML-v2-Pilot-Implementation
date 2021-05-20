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

package org.omg.sysml.xtext.util;

import java.util.Arrays;

public class SysMLRepositorySaveTest extends SysMLRepositorySaveUtil {
	
	protected static final String[] TEST_FILES = {
		"01-Parts Tree/1c-Parts Tree Redefinition.sysml",
		"02-Parts Interconnection/2a-Parts Interconnection.sysml",
		"03-Function-based Behavior/3a-Function-based Behavior-1.sysml",
		"03-Function-based Behavior/3a-Function-based Behavior-2.sysml",
		"04-Functional Allocation/4a-Functional Allocation.sysml",
		"05-State-based Behavior/5-State-based Behavior-1.sysml",
		"05-State-based Behavior/5-State-based Behavior-1a.sysml",
		"06-Individual and Snapshots/6-Individual and Snapshots.sysml",
		"07-Variant Configuration/7b-Variant Configurations.sysml",
		"08-Requirements/8-Requirements.sysml",
		"09-Verification/9-Verification-simplified.sysml",
		"10-Analysis and Trades/10b-Trade-off Among Alternative Configurations.sysml",
		"10-Analysis and Trades/10c-Fuel Economy Analysis.sysml",
		"11-View and Viewpoint/11a-View-Viewpoint.sysml",
		"11-View and Viewpoint/11b-Safety and Security Feature Views.sysml",
		"12-Dependency Relationships/12a-Dependency.sysml",
		"12-Dependency Relationships/12b-Allocation.sysml",
		"13-Model Containment/13a-Model Containment.sysml",
		"13-Model Containment/13b-Safety and Security Features Element Group.sysml",
		"13-Model Containment/13b-Safety and Security Features Element Group-1.sysml",
		"13-Model Containment/13b-Safety and Security Features Element Group-2.sysml",
		"14-Language Extensions/14b-Language Extensions.sysml",
		"15-Properties-Values-Expressions/15_05-Unification of Expression and Constraint Definition.sysml",
		"15-Properties-Values-Expressions/15_10-Primitive Data Types.sysml",
		"15-Properties-Values-Expressions/15_19-Materials with Properties.sysml",
	};
	
	protected String testFilePath;

	public SysMLRepositorySaveTest(String testFilePath) {
		super();
		this.testFilePath = testFilePath;
	}
	
	@Override
	protected void initialize(String[] args) {
		if (!args[0].endsWith("/")) {
			args[0] += "/";
		}
		args[0] += this.testFilePath;
		
		super.initialize(args);
	}
	
	public static void main(String[] args) {
		try {
			String[] args1 = Arrays.copyOf(args, args.length);
			for (String testFile: TEST_FILES) {
				new SysMLRepositorySaveTest(testFile).run(args1);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}