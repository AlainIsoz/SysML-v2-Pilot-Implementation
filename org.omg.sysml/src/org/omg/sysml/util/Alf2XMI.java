/*****************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2018-2019 Model Driven Solutions, Inc.
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
 *  Ed Seidewitz
 * 
 *****************************************************************************/

package org.omg.sysml.util;

import java.io.IOException;

public class Alf2XMI extends AlfUtil {
	
	public static void main(String[] args) {
		try {
			Alf2XMI util = new Alf2XMI();
			
			System.out.println("Reading " + args[0] + "...");
			util.read(args[0]);
			
			String outputPath = util.getOutputPath(args[0]);
			System.out.println("Writing " + outputPath + "...");
			util.write(util.getOutputPath(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
