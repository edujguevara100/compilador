/* The following code was generated by JFlex 1.6.1 */

package compilador;
import compilador.sym;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/compilador/Lexer.flex</tt>
 */
public class AnalizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int comment = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0, 42, 47, 48, 48, 47,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    13, 22, 41,  0,  0,  0, 32, 40,  7,  8, 29, 30, 34, 26,  0, 46, 
    39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 43, 23, 31, 28, 27,  0, 
     0, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 
    38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 44, 43, 45,  0,  4, 
     0,  6,  9, 21, 12, 10, 17, 11, 35,  1, 38, 38, 14,  5,  2, 15, 
    16, 38, 18, 19,  3, 20, 38, 38, 37, 36, 38, 24, 33, 25,  0,  0, 
     0,  0,  0,  0,  0, 48,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\3\2\1\1\2\2\1\3\1\4\2\2"+
    "\1\5\6\2\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\12\1\16\1\17\1\20\1\21\2\1"+
    "\1\22\1\23\1\15\1\5\2\24\1\25\1\24\1\26"+
    "\1\0\16\24\1\13\1\27\3\0\1\30\1\31\1\32"+
    "\10\24\1\33\2\24\1\34\4\24\1\35\1\36\1\0"+
    "\1\37\3\24\1\32\1\0\1\40\1\41\1\24\1\0"+
    "\1\24\1\42\1\24\1\43\1\0\2\24\1\44\6\0"+
    "\1\24\1\0\1\45\1\24\1\0\1\24\1\0\1\46"+
    "\6\0\1\24\1\0\1\47\11\0\1\50\1\0\1\51"+
    "\1\52\7\0\1\53\1\54\1\55\1\0\1\56\10\0"+
    "\1\57\10\0\1\60\2\0\1\32";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\u0157"+
    "\0\u0188\0\142\0\142\0\u01b9\0\u01ea\0\142\0\u021b\0\u024c"+
    "\0\u027d\0\u02ae\0\u02df\0\u0310\0\u0341\0\142\0\142\0\142"+
    "\0\u0372\0\u0341\0\u0341\0\142\0\142\0\142\0\142\0\142"+
    "\0\u03a3\0\u03d4\0\u0405\0\142\0\142\0\u0436\0\u0467\0\304"+
    "\0\u0498\0\304\0\u04c9\0\u0126\0\u04fa\0\u052b\0\u055c\0\u058d"+
    "\0\u05be\0\u05ef\0\u0620\0\u0651\0\u0682\0\u06b3\0\u06e4\0\u0715"+
    "\0\u0746\0\u0777\0\u07a8\0\142\0\142\0\u07d9\0\u080a\0\u083b"+
    "\0\142\0\142\0\u086c\0\u089d\0\u08ce\0\u08ff\0\u0930\0\u0961"+
    "\0\u0992\0\u09c3\0\u09f4\0\u0a25\0\u0a56\0\u0a87\0\304\0\u0ab8"+
    "\0\u0ae9\0\u0b1a\0\u0b4b\0\142\0\142\0\u0b7c\0\304\0\u0bad"+
    "\0\u0bde\0\u0c0f\0\304\0\u0c40\0\304\0\304\0\u0c71\0\u0ca2"+
    "\0\u0cd3\0\304\0\u0d04\0\304\0\u0d35\0\u0d66\0\u0d97\0\304"+
    "\0\u0dc8\0\u0df9\0\u0e2a\0\u0e5b\0\u0e8c\0\u0ebd\0\u0eee\0\u0f1f"+
    "\0\304\0\u0f50\0\u0f81\0\u0fb2\0\u0fe3\0\142\0\u1014\0\u1045"+
    "\0\u1076\0\u10a7\0\u10d8\0\u1109\0\u113a\0\u116b\0\304\0\u119c"+
    "\0\u11cd\0\u11fe\0\u122f\0\u1260\0\u1291\0\u12c2\0\u12f3\0\u1324"+
    "\0\142\0\u1355\0\304\0\142\0\u1386\0\u13b7\0\u13e8\0\u1419"+
    "\0\u144a\0\u147b\0\u14ac\0\142\0\142\0\142\0\u14dd\0\142"+
    "\0\u150e\0\u153f\0\u1570\0\u15a1\0\u15d2\0\u1603\0\u1634\0\u1665"+
    "\0\142\0\u1696\0\u16c7\0\u16f8\0\u1729\0\u175a\0\u178b\0\u17bc"+
    "\0\u17ed\0\142\0\u181e\0\u184f\0\142";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\2\5\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\2\5\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\32\1\36\1\37"+
    "\1\40\4\5\1\41\1\42\1\43\1\16\1\3\1\44"+
    "\1\45\1\46\1\16\1\0\35\16\1\47\21\16\64\0"+
    "\1\50\1\51\1\50\1\0\2\50\2\0\4\50\1\0"+
    "\3\50\1\52\4\50\15\0\4\50\13\0\3\50\1\0"+
    "\2\50\2\0\4\50\1\0\10\50\15\0\4\50\13\0"+
    "\3\50\1\0\2\50\2\0\4\50\1\0\4\50\1\53"+
    "\3\50\15\0\4\50\13\0\3\54\1\0\2\54\2\0"+
    "\4\54\1\0\10\54\4\0\1\55\10\0\5\54\12\0"+
    "\3\50\1\0\1\50\1\56\2\0\4\50\1\0\10\50"+
    "\15\0\4\50\13\0\3\50\1\0\2\50\2\0\4\50"+
    "\1\0\4\50\1\57\3\50\15\0\4\50\13\0\3\50"+
    "\1\0\2\50\2\0\1\50\1\60\2\50\1\0\1\50"+
    "\1\61\6\50\15\0\4\50\13\0\1\50\1\62\1\50"+
    "\1\0\2\50\2\0\4\50\1\0\1\63\7\50\15\0"+
    "\4\50\13\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\1\50\1\64\6\50\15\0\4\50\13\0\3\50\1\0"+
    "\2\50\2\0\4\50\1\0\2\50\1\65\5\50\15\0"+
    "\4\50\13\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\4\50\1\66\3\50\15\0\4\50\13\0\3\50\1\0"+
    "\1\50\1\67\2\0\4\50\1\0\1\50\1\70\4\50"+
    "\1\71\1\50\15\0\4\50\13\0\3\50\1\0\2\50"+
    "\2\0\1\50\1\72\2\50\1\0\10\50\15\0\4\50"+
    "\13\0\3\50\1\0\2\50\2\0\4\50\1\0\10\50"+
    "\15\0\1\73\3\50\46\0\1\74\57\0\1\75\13\0"+
    "\1\41\60\0\1\41\12\0\3\76\1\0\2\76\2\0"+
    "\15\76\15\0\5\76\12\0\3\77\1\0\2\77\2\0"+
    "\15\77\4\0\1\100\10\0\5\77\2\0\2\77\3\0"+
    "\1\77\36\0\1\101\101\0\1\102\3\0\2\50\1\103"+
    "\1\0\2\50\2\0\4\50\1\0\10\50\15\0\4\50"+
    "\13\0\3\50\1\0\2\50\2\0\4\50\1\0\6\50"+
    "\1\104\1\50\15\0\4\50\61\0\1\54\12\0\2\50"+
    "\1\105\1\0\2\50\2\0\4\50\1\0\10\50\15\0"+
    "\4\50\13\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\4\50\1\106\3\50\15\0\4\50\13\0\3\50\1\0"+
    "\2\50\2\0\2\50\1\107\1\50\1\0\10\50\15\0"+
    "\4\50\13\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\1\50\1\110\6\50\15\0\4\50\13\0\3\50\1\0"+
    "\2\50\2\0\3\50\1\111\1\0\10\50\15\0\4\50"+
    "\13\0\3\50\1\0\2\50\2\0\4\50\1\0\5\50"+
    "\1\112\2\50\15\0\4\50\13\0\3\50\1\0\2\50"+
    "\2\0\4\50\1\0\1\50\1\113\6\50\15\0\4\50"+
    "\13\0\2\50\1\114\1\0\2\50\2\0\4\50\1\0"+
    "\10\50\15\0\4\50\13\0\1\115\2\50\1\0\2\50"+
    "\2\0\4\50\1\0\10\50\15\0\4\50\13\0\3\50"+
    "\1\0\2\50\2\0\4\50\1\0\1\116\7\50\15\0"+
    "\4\50\13\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\4\50\1\117\3\50\15\0\4\50\13\0\1\50\1\120"+
    "\1\50\1\0\2\50\2\0\4\50\1\0\10\50\15\0"+
    "\4\50\13\0\2\50\1\121\1\0\1\50\1\122\2\0"+
    "\4\50\1\0\10\50\15\0\4\50\13\0\3\50\1\0"+
    "\1\50\1\123\2\0\4\50\1\0\10\50\15\0\4\50"+
    "\62\0\1\124\11\0\3\77\1\0\2\77\2\0\15\77"+
    "\4\0\1\100\10\0\5\77\1\0\1\125\2\77\3\0"+
    "\1\77\50\0\1\77\12\0\3\50\1\126\2\50\2\0"+
    "\4\50\1\0\10\50\15\0\4\50\13\0\3\50\1\0"+
    "\2\50\2\0\1\50\1\127\2\50\1\0\10\50\15\0"+
    "\4\50\13\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\4\50\1\130\3\50\15\0\4\50\13\0\3\50\1\0"+
    "\1\50\1\131\2\0\4\50\1\0\10\50\15\0\4\50"+
    "\13\0\1\132\2\50\1\0\2\50\2\0\4\50\1\0"+
    "\10\50\15\0\4\50\13\0\3\50\1\0\2\50\2\0"+
    "\4\50\1\0\1\133\7\50\15\0\4\50\13\0\3\50"+
    "\1\0\2\50\2\0\4\50\1\134\10\50\15\0\4\50"+
    "\13\0\3\50\1\0\2\50\2\0\1\50\1\135\2\50"+
    "\1\0\10\50\15\0\4\50\13\0\3\50\1\0\2\50"+
    "\2\0\4\50\1\0\2\50\1\136\5\50\15\0\4\50"+
    "\13\0\1\137\2\50\1\140\2\50\2\0\4\50\1\0"+
    "\10\50\15\0\4\50\13\0\1\50\1\141\1\50\1\0"+
    "\2\50\2\0\4\50\1\0\10\50\15\0\4\50\13\0"+
    "\3\50\1\0\2\50\2\0\4\50\1\0\5\50\1\104"+
    "\2\50\15\0\4\50\13\0\3\50\1\0\2\50\2\0"+
    "\4\50\1\0\7\50\1\142\15\0\4\50\13\0\3\50"+
    "\1\0\2\50\2\0\4\50\1\0\6\50\1\143\1\50"+
    "\15\0\4\50\13\0\3\50\1\0\2\50\2\0\3\50"+
    "\1\144\1\0\10\50\15\0\4\50\13\0\3\50\1\0"+
    "\2\50\2\0\4\50\1\0\4\50\1\133\3\50\15\0"+
    "\4\50\17\0\1\145\54\0\1\146\2\50\1\0\2\50"+
    "\2\0\4\50\1\0\10\50\15\0\4\50\13\0\3\50"+
    "\1\0\2\50\2\0\4\50\1\0\10\50\15\0\1\50"+
    "\1\147\2\50\13\0\1\50\1\150\1\50\1\0\2\50"+
    "\2\0\4\50\1\0\10\50\15\0\4\50\13\0\1\151"+
    "\3\0\1\152\4\0\1\153\3\0\1\154\1\155\1\0"+
    "\1\156\40\0\3\50\1\0\2\50\2\0\4\50\1\0"+
    "\1\50\1\157\6\50\15\0\4\50\26\0\1\160\45\0"+
    "\2\50\1\161\1\0\2\50\2\0\4\50\1\0\10\50"+
    "\15\0\4\50\13\0\3\50\1\0\2\50\2\0\4\50"+
    "\1\0\4\50\1\162\3\50\15\0\4\50\20\0\1\163"+
    "\53\0\3\50\1\0\2\50\2\0\4\50\1\0\10\50"+
    "\15\0\2\50\1\164\1\50\13\0\3\50\1\165\2\50"+
    "\2\0\4\50\1\0\10\50\15\0\4\50\33\0\1\166"+
    "\45\0\1\167\70\0\1\170\61\0\1\171\61\0\1\172"+
    "\57\0\1\173\4\0\1\174\35\0\1\50\1\175\1\50"+
    "\1\0\2\50\2\0\4\50\1\0\10\50\15\0\4\50"+
    "\24\0\1\176\47\0\1\50\1\177\1\50\1\0\2\50"+
    "\2\0\4\50\1\0\10\50\15\0\4\50\13\0\1\200"+
    "\60\0\3\50\1\201\2\50\2\0\4\50\1\0\10\50"+
    "\15\0\4\50\13\0\1\202\7\0\1\203\13\0\1\204"+
    "\34\0\1\205\102\0\1\206\54\0\1\207\44\0\1\210"+
    "\77\0\1\211\40\0\1\212\57\0\3\50\1\0\2\50"+
    "\2\0\4\50\1\0\5\50\1\213\2\50\15\0\4\50"+
    "\33\0\1\214\41\0\1\215\57\0\1\216\7\0\1\217"+
    "\13\0\1\220\35\0\1\221\75\0\1\222\104\0\1\223"+
    "\17\0\1\224\70\0\1\225\66\0\1\226\41\0\1\227"+
    "\104\0\1\230\42\0\1\231\53\0\1\232\75\0\1\233"+
    "\104\0\1\234\20\0\1\235\74\0\1\236\47\0\1\237"+
    "\71\0\1\240\51\0\1\241\53\0\1\242\74\0\1\243"+
    "\47\0\1\244\102\0\1\245\46\0\1\235\64\0\1\235"+
    "\40\0\1\246\106\0\1\247\46\0\1\242\64\0\1\242"+
    "\70\0\1\250\14\0\1\251\34\0\1\252\67\0\1\253"+
    "\14\0\1\254\60\0\1\251\42\0\1\255\15\0\1\251"+
    "\60\0\1\254\53\0\1\245\4\0\1\254\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6272];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\6\1\2\11\2\1\1\11\7\1\3\11"+
    "\3\1\5\11\3\1\2\11\7\1\1\0\16\1\2\11"+
    "\3\0\2\11\21\1\2\11\1\0\5\1\1\0\3\1"+
    "\1\0\4\1\1\0\3\1\6\0\1\1\1\0\2\1"+
    "\1\0\1\1\1\0\1\11\6\0\1\1\1\0\1\1"+
    "\11\0\1\11\1\0\1\1\1\11\7\0\3\11\1\0"+
    "\1\11\10\0\1\11\10\0\1\11\2\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    public String error = "";


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }



  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { error += "No reconoce: " + yytext() + " linea: " + (yyline+1) + " columna: "+(yycolumn+1) + "\n"; return new Symbol(sym.error, yyline, yycolumn,yytext());
            }
          case 49: break;
          case 2: 
            { error += "No se esperaba la letra: " + yytext() + " linea: " + yyline + " columna: "+yycolumn + "\n"; return new Symbol(sym.error, yyline, yycolumn,yytext());
            }
          case 50: break;
          case 3: 
            { return new Symbol(sym.ABREPAR, yyline, yycolumn,yytext());
            }
          case 51: break;
          case 4: 
            { return new Symbol(sym.CIERRAPAR, yyline, yycolumn,yytext());
            }
          case 52: break;
          case 5: 
            { 
            }
          case 53: break;
          case 6: 
            { return new Symbol(sym.NOT, yyline, yycolumn,yytext());
            }
          case 54: break;
          case 7: 
            { return new Symbol(sym.FINLINE, yyline, yycolumn,yytext());
            }
          case 55: break;
          case 8: 
            { return new Symbol(sym.ABRE, yyline, yycolumn,yytext());
            }
          case 56: break;
          case 9: 
            { return new Symbol(sym.CIERRA, yyline, yycolumn,yytext());
            }
          case 57: break;
          case 10: 
            { return new Symbol(sym.OPSR, yyline, yycolumn,yytext());
            }
          case 58: break;
          case 11: 
            { return new Symbol(sym.OPREL, yyline, yycolumn,yytext());
            }
          case 59: break;
          case 12: 
            { return new Symbol(sym.ASIG, yyline, yycolumn,yytext());
            }
          case 60: break;
          case 13: 
            { return new Symbol(sym.OPMD, yyline, yycolumn,yytext());
            }
          case 61: break;
          case 14: 
            { return new Symbol(sym.AND, yyline, yycolumn,yytext());
            }
          case 62: break;
          case 15: 
            { return new Symbol(sym.OR, yyline, yycolumn,yytext());
            }
          case 63: break;
          case 16: 
            { return new Symbol(sym.COMA, yyline, yycolumn,yytext());
            }
          case 64: break;
          case 17: 
            { return new Symbol(sym.INT, yyline, yycolumn,yytext());
            }
          case 65: break;
          case 18: 
            { return new Symbol(sym.ABRECOR, yyline, yycolumn,yytext());
            }
          case 66: break;
          case 19: 
            { return new Symbol(sym.CIERRACOR, yyline, yycolumn,yytext());
            }
          case 67: break;
          case 20: 
            { error += "No se esperaba: " + yytext() + " linea: " + (yyline+1) + " columna: "+(yycolumn+1) + "\n"; return new Symbol(sym.error, yyline, yycolumn,yytext());
            }
          case 68: break;
          case 21: 
            { return new Symbol(sym.IF, yyline, yycolumn,yytext());
            }
          case 69: break;
          case 22: 
            { return new Symbol(sym.ID, yyline, yycolumn,yytext());
            }
          case 70: break;
          case 23: 
            { return new Symbol(sym.HASTA, yyline, yycolumn,yytext());
            }
          case 71: break;
          case 24: 
            { yybegin(comment);
            }
          case 72: break;
          case 25: 
            { yybegin(YYINITIAL);
            }
          case 73: break;
          case 26: 
            { return new Symbol(sym.TYPE, yyline, yycolumn,yytext());
            }
          case 74: break;
          case 27: 
            { return new Symbol(sym.OPT, yyline, yycolumn,yytext());
            }
          case 75: break;
          case 28: 
            { return new Symbol(sym.FOR, yyline, yycolumn,yytext());
            }
          case 76: break;
          case 29: 
            { return new Symbol(sym.CHAR, yyline, yycolumn,yytext());
            }
          case 77: break;
          case 30: 
            { return new Symbol(sym.STRING, yyline, yycolumn,yytext());
            }
          case 78: break;
          case 31: 
            { return new Symbol(sym.BOOL, yyline, yycolumn,yytext());
            }
          case 79: break;
          case 32: 
            { return new Symbol(sym.ELSE, yyline, yycolumn,yytext());
            }
          case 80: break;
          case 33: 
            { return new Symbol(sym.LOOP, yyline, yycolumn,yytext());
            }
          case 81: break;
          case 34: 
            { return new Symbol(sym.FUNC, yyline, yycolumn,yytext());
            }
          case 82: break;
          case 35: 
            { return new Symbol(sym.READ, yyline, yycolumn,yytext());
            }
          case 83: break;
          case 36: 
            { return new Symbol(sym.BEGIN, yyline, yycolumn,yytext());
            }
          case 84: break;
          case 37: 
            { return new Symbol(sym.PRINT, yyline, yycolumn,yytext());
            }
          case 85: break;
          case 38: 
            { return new Symbol(sym.ENDI, yyline, yycolumn,yytext());
            }
          case 86: break;
          case 39: 
            { return new Symbol(sym.RETURN, yyline, yycolumn,yytext());
            }
          case 87: break;
          case 40: 
            { return new Symbol(sym.ENDF, yyline, yycolumn,yytext());
            }
          case 88: break;
          case 41: 
            { return new Symbol(sym.OPTIONS, yyline, yycolumn,yytext());
            }
          case 89: break;
          case 42: 
            { return new Symbol(sym.DEFOPT, yyline, yycolumn,yytext());
            }
          case 90: break;
          case 43: 
            { return new Symbol(sym.ENDM, yyline, yycolumn,yytext());
            }
          case 91: break;
          case 44: 
            { return new Symbol(sym.ENDE, yyline, yycolumn,yytext());
            }
          case 92: break;
          case 45: 
            { return new Symbol(sym.ENDL, yyline, yycolumn,yytext());
            }
          case 93: break;
          case 46: 
            { return new Symbol(sym.ENDFU, yyline, yycolumn,yytext());
            }
          case 94: break;
          case 47: 
            { return new Symbol(sym.MAIN, yyline, yycolumn,yytext());
            }
          case 95: break;
          case 48: 
            { return new Symbol(sym.ENDO, yyline, yycolumn,yytext());
            }
          case 96: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
