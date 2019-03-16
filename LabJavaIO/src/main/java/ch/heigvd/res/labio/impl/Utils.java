package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {


    String tab[] = new String[2];

    boolean contains = false; //true if there are new line separators
    char check; //current char
    int elem = 0;//position

    for (int i = 0; i < lines.length(); ++i) {

      check = lines.charAt(i);


      if (check == '\n' || ( check == '\r' && i+1==lines.length())) {
        elem = i + 1;
        contains = true;
        break;


      } else if (i > 0 && lines.charAt(i-1) == '\r') {
        elem = i;
        contains = true;
        break;

      }


    }

    if (contains) {
      tab[0] = lines.substring(0, elem);
      tab[1] = lines.substring(elem);

    } else {
      tab[0] = "";
      tab[1] = lines;
    }

    return tab;
  }

}
