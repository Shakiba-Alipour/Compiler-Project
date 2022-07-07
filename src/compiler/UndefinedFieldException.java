package compiler;

public class UndefinedFieldException extends Throwable {
    public UndefinedFieldException(String idefName, int scopeNumber) {
        super("Error105 : in line " + scopeNumber + ", cannot find variable " + idefName);
    }
}
