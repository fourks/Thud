//
//  ANSIParser.java
//  Thud
//
//  Created by Anthony Parker on Sat Aug 03 2002.
//  Copyright (c) 2002 Anthony Parker. All rights reserved.
//
package btthud.util;

import javax.swing.text.*;
import java.awt.*;

/* This is a class full of static methods to help with ANSI parsing */

/*
 MUX uses these colors:

 f - flash                       i - inverse
 h - hilite                      n - normal

 x - black foreground            X - black background
 r - red foreground              R - red background
 g - green foreground            G - green background
 y - yellow foreground           Y - yellow background
 b - blue foreground             B - blue background
 m - magenta foreground          M - magenta background
 c - cyan foreground             C - cyan background
 w - white foreground            W - white background

 */

public class ANSIParser {

    // ---------
    // Utility methods

    /**
    * Check to see if an escape code refers to a bold code
     */
    static public boolean boldEscapeCode(int charCode1)
    {
            if (charCode1 == 1)
                return true;
            else
                return false;
    }
    
    /**
    * Check to see if this is a 'normal' code
    */
    static public boolean normalEscapeCode(int charCode1)
    {
        if (charCode1 == 0)
            return true;
        else
            return false;
    }
    
    /**
    * Parse 2 integers, and return an AttributeSet that holds the proper color information.
    */
    static public MutableAttributeSet parseEscapeCode(int charCode1, int charCode2)
    {
        // Make an attribute set that represents our current settings
        MutableAttributeSet			a = new SimpleAttributeSet();

        // if (charCode1 == 0) { /* do nothing */ }

        // some more esoteric styles:
        // #define ANSI_INVERSE  "\033[7m"
        // #define ANSI_BLINK    "\033[5m"
        // #define ANSI_UNDER    "\033[4m"
        
        if (charCode1 == 1)		// highlight
        {
            StyleConstants.setBold(a, true);
        }
        else if (charCode1 == 3)
        {
            switch (charCode2)
            {
                case 0:
                    StyleConstants.setForeground(a, Color.black);
                    break;
                case 1:
                    StyleConstants.setForeground(a, Color.red);
                    break;
                case 2:
                    StyleConstants.setForeground(a, Color.green);
                    break;
                case 3:
                    StyleConstants.setForeground(a, Color.yellow);
                    break;
                case 4:
                    StyleConstants.setForeground(a, Color.blue);
                    break;
                case 5:
                    StyleConstants.setForeground(a, Color.magenta);
                    break;
                case 6:
                    StyleConstants.setForeground(a, Color.cyan);
                    break;
                case 7:
                    StyleConstants.setForeground(a, Color.white);
                    break;
                default:					// dunno what this is.... change nothing
                    break;
            }
        } // end of charcode check
    
        return a;
    }
}