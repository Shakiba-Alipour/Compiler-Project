grammar Jython;

program : importclass* (classDef)? ;

importclass : 'import' CLASSNAME ;

classDef : 'class' CLASSNAME ('(' CLASSNAME ')')? '{' class_body* '}';

class_body : varDec | methodDec | constructor | arrayDec ;

varDec : TYPE ID ;

arrayDec : TYPE '['INTEGER']' ID ;

methodDec : 'def' (TYPE|'void') ID '(' parameter* ')''{' ( statement)* '}';

constructor : 'def' TYPE '(' parameter* ')''{' ( statement)* '}' ;

parameter : varDec (',' varDec)* ;
statement : varDec | assignment | print_statment | method_call | return_statment
|if_statment | while_statment | if_else_statment | for_statment;

return_statment : 'return' exp ;

condition_list : condition (('or'|'and') condition)* ;

condition : BOOL | prefixexp | (exp) relational_operators (exp);

if_statment : 'if' '(' condition_list ')' '{' statement* '}';

while_statment : 'while' '(' condition_list ')' '{' statement* '}' ;

if_else_statment :'if' '(' condition_list ')' '{' statement* '}' ('elif' '(' condition_list ')' '{' statement* '}')* 'else' '{' statement* '}' ;

print_statment : 'print' '(' (prefixexp | TYPE args | INTEGER |STRING | BOOL) ')' ;

for_statment : 'for' ID 'in' ID '{' statement* '}'
| 'for' ID 'in' 'range''('INTEGER (',' INTEGER)? (',' INTEGER)? ')' '{' statement* '}' ;

method_call : ID '.'args ;

assignment : prefixexp assignment_operators exp
| varDec assignment_operators exp
| arrayDec '=' TYPE args ('['INTEGER']') ;

exp :'none' | BOOL | INTEGER | STRING | FLOAT | prefixexp | exp arithmetic_operator exp
| TYPE args | '('exp')' | ID args ;

prefixexp : ID | prefixexp '[' INTEGER ']' | prefixexp '.' ID | prefixexp '.' ID args ;

args : '(' (explist)? ')' ;

explist : exp (',' exp)*;

arithmetic_operator: '+' | '-' | '*' | '/' | '%' ;

relational_operators : '<' | '>' | '<=' | '>=' | '==' | '!=' ;

assignment_operators : '=' | '+=' | '-=' | '*=' | '/=' ;

//added by shakiba

DIGIT: '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';

CAPITAL_LETTER : 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O'
                  | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z';

SMALL_LETTER : 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o'
                | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z';

BOOL : 'true' | 'false';

INTEGER : DIGIT (DIGIT)*;

FLOAT : INTEGER '.' INTEGER;

NUMBER : INTEGER | FLOAT;

STRING : '\'' (SMALL_LETTER | CAPITAL_LETTER | NUMBER)* '\'';

CLASSNAME : CAPITAL_LETTER (SMALL_LETTER)*;

TYPE : 'int' | 'float' | 'class' | 'string' | 'bool' | CLASSNAME | (CAPITAL_LETTER (SMALL_LETTER | DIGIT)*);

ID : SMALL_LETTER (SMALL_LETTER | CAPITAL_LETTER | DIGIT)* ('_' (SMALL_LETTER | CAPITAL_LETTER | DIGIT)*)*;