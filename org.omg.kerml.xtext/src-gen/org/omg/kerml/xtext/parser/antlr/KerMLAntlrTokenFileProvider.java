/*
 * generated by Xtext 2.34.0
 */
package org.omg.kerml.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class KerMLAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/omg/kerml/xtext/parser/antlr/internal/InternalKerML.tokens");
	}
}
