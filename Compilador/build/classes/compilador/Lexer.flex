package compilador;
import compilador.sym;
import java_cup.runtime.Symbol;
%%

%unicode
%class AnalizadorLexico
%cup
%type Symbol
%public
%line
%char
%column
%full
%state comment

%{
    public String error = "";
%}

main = "int_main()"
begin = "begin"
endm = "end main"
endl = "end loop"
endf = "end for"
endi = "end if"
ende = "end else"
endo = "end options"
endfu = "end func"
print = "print"
not = "!"
else = "else"
finline = ";"
opllaveA = "{"
opllaveB = "}"
opHASTA = "->"
opASIG = "="
opMD = [*/]
opSR = [+-]
opREL = ("=="|">="|"<="|"!="|">"|"<")
andor = ("&"|"|")
separator = ","
return = "return"
data_type = (int|char|bool|array_int|array_char|array_bool|matrix_int|matrix_char|matirx_bool)
func = "func"
if = "if"
palabra = [a-zA-Z]+
letra = [a-zA-Z ]
int = -?[0-9]+
id = "_"({letra}|{int})+
bool = ("true"|"false")
char = '[0-9a-zA-Z ]'
string = \"({palabra}|{int}|{espacio})+\"
espacio = [ \n\r\t]
oppar = "("
cerrarpar = ")"
for = "for"
options = "options"
option = "opt"
defaultOption = "opt_def"
loop = "loop"
abreComment = "/*"
cierraComment = "*/"
valor = ({int}|{char}|{bool})
%%
<YYINITIAL> {
	{abreComment} {yybegin(comment);}
        {id} {return new Symbol(sym.ID, yyline, yycolumn,yytext());}
        {valor} {return new Symbol(sym.VALOR, yyline, yycolumn,yytext());}
        {not} {return new Symbol(sym.NOT, yyline, yycolumn,yytext());}
        {string} {return new Symbol(sym.STRING, yyline, yycolumn,yytext());}
        {begin} {return new Symbol(sym.BEGIN, yyline, yycolumn,yytext());}
        {endi} {return new Symbol(sym.ENDI, yyline, yycolumn,yytext());}
        {ende} {return new Symbol(sym.ENDE, yyline, yycolumn,yytext());}
        {endo} {return new Symbol(sym.ENDO, yyline, yycolumn,yytext());}
        {endm} {return new Symbol(sym.ENDM, yyline, yycolumn,yytext());}
        {endl} {return new Symbol(sym.ENDL, yyline, yycolumn,yytext());}
        {endf} {return new Symbol(sym.ENDF, yyline, yycolumn,yytext());}
        {endfu} {return new Symbol(sym.ENDFU, yyline, yycolumn,yytext());}
        {print} {return new Symbol(sym.PRINT, yyline, yycolumn,yytext());}
        {else} {return new Symbol(sym.ELSE, yyline, yycolumn,yytext());}
	{andor} {return new Symbol(sym.ANDOR, yyline, yycolumn,yytext());}
	{opREL} {return new Symbol(sym.OPREL, yyline, yycolumn,yytext());}
	{loop} {return new Symbol(sym.LOOP, yyline, yycolumn,yytext());}
	{main} {return new Symbol(sym.MAIN, yyline, yycolumn,yytext());}
	{for} {return new Symbol(sym.FOR, yyline, yycolumn,yytext());}
	{options} {return new Symbol(sym.OPTIONS, yyline, yycolumn,yytext());}
	{option} {return new Symbol(sym.OPT, yyline, yycolumn,yytext());}
	{defaultOption} {return new Symbol(sym.DEFOPT, yyline, yycolumn,yytext());}
	{finline} {return new Symbol(sym.FINLINE, yyline, yycolumn,yytext());}
	{opllaveA} {return new Symbol(sym.ABRE, yyline, yycolumn,yytext());}
	{opllaveB} {return new Symbol(sym.CIERRA, yyline, yycolumn,yytext());}
	{opHASTA} {return new Symbol(sym.HASTA, yyline, yycolumn,yytext());}
	{opASIG} {return new Symbol(sym.ASIG, yyline, yycolumn,yytext());}
	{opMD} {return new Symbol(sym.OPMD, yyline, yycolumn,yytext());}
	{opSR} {return new Symbol(sym.OPSR, yyline, yycolumn,yytext());}
	{separator} {return new Symbol(sym.COMA, yyline, yycolumn,yytext());}
	{return} {return new Symbol(sym.RETURN, yyline, yycolumn,yytext());}
	{data_type} {return new Symbol(sym.TYPE, yyline, yycolumn,yytext());}
	{func} {return new Symbol(sym.FUNC, yyline, yycolumn,yytext());}
	{if} {return new Symbol(sym.IF, yyline, yycolumn,yytext());}
	{espacio} {}	
	{oppar} {return new Symbol(sym.ABREPAR, yyline, yycolumn,yytext());}
	{cerrarpar} {return new Symbol(sym.CIERRAPAR, yyline, yycolumn,yytext());}
        {letra} {error += "No se esperaba la letra: " + yytext() + " linea: " + yyline + " columna: "+yycolumn + "\n"; return new Symbol(sym.error, yyline, yycolumn,yytext());}
        {palabra} {error += "No se esperaba: " + yytext() + " linea: " + yyline + " columna: "+yycolumn + "\n"; return new Symbol(sym.error, yyline, yycolumn,yytext());}
	. {error += "No reconoce: " + yytext() + " linea: " + yyline + " columna: "+yycolumn + "\n"; return new Symbol(sym.error, yyline, yycolumn,yytext());}
}
<comment> {
	{cierraComment} {yybegin(YYINITIAL);}
	. {}
}

