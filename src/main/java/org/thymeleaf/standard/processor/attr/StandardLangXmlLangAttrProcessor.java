/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2012, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.standard.processor.attr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.standard.expression.Expression;

/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.0
 *
 */
public final class StandardLangXmlLangAttrProcessor 
        extends AbstractStandardSingleValueMultipleAttributeModifierAttrProcessor {

    public static final int ATTR_PRECEDENCE = 990;
    public static final String ATTR_NAME = "lang-xmllang";
    public static final Set<String> TARGET_ATTR_NAMES = 
        new HashSet<String>(Arrays.asList(new String[] {"lang", "xml:lang"}));
    
    
    
    public StandardLangXmlLangAttrProcessor() {
        super(ATTR_NAME);
    }



    @Override
    public int getPrecedence() {
        return ATTR_PRECEDENCE;
    }


    @Override
    protected Set<String> getModifiedAttributeNames(final Arguments arguments,
            final Element element, final String attributeName, final String attributeValue, 
            final Expression expression) {
        return TARGET_ATTR_NAMES;
    }

    
    @Override
    protected ModificationType getModificationType(
            final Arguments arguments, 
            final Element element, final String attributeName, final String newAttributeName) {
        return ModificationType.SUBSTITUTION;
    }



    @Override
    protected boolean removeAttributeIfEmpty(
            final Arguments arguments, final Element element, final String attributeName, final String newAttributeName) {
        return true;
    }


}
