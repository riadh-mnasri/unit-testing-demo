package com.riadh.samples.exo2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.riadh.samples.RegExpValidationException;

/**
 * RegExpHelper provides supporting methods to manipulate regular expressions.
 * 
 * @author Riadh MNASRI
 * 
 */
public class RegExpValidator {

    /**
     * Regular expression
     */
    private String regexp = null;

    /**
     * Text on which the regular expression will be applied
     */
    private String text   = null;

    public RegExpValidator() {
        this.regexp = null;
        this.text = null;
    }

    public RegExpValidator(String regexp, String text) {
        this.regexp = regexp;
        this.text = text;
    }

    /**
     * Registers the regular expression to use.
     * 
     * @param regexp
     *            A regular expression.
     */
    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    /**
     * Registers the text on which the regular expression should be applied.
     * 
     * @param regexp
     *            Some text.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Applies the regular expression on the defined text, then return a <code>Matcher</code>
     * object.
     * 
     * @throws FileManagerException
     * @return <code>Matcher</code> object.
     */
    public Matcher getMatcher() throws RegExpValidationException {
        Matcher result = null;

        Pattern p = null;
        if (this.regexp == null || this.text == null) {
            throw new RegExpValidationException("RegExp matching operation could not have regexp or text arguments");
        }
        try {
            p = Pattern.compile(this.regexp);
            result = p.matcher(this.text);
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
            System.err.println("Regex syntax error: " + e.getMessage());
            System.err.println("Error description: " + e.getDescription());
            System.err.println("Error index: " + e.getIndex());
            System.err.println("Erroneous pattern: " + e.getPattern());
            throw new RegExpValidationException("PatternSyntaxException: Regular expression syntax error: "
                    + e.getMessage() + "Error Description: " + e.getDescription() + "Text parsed: " + this.text
                    + "Regular Expression: " + this.regexp + "Error index: " + e.getIndex() + "Erroneous pattern: "
                    + e.getPattern());
        }

        return result;
    }

}
