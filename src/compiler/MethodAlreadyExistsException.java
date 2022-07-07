package compiler;

public class MethodAlreadyExistsException extends Throwable {
    public MethodAlreadyExistsException(String idefName, int scopeNumber) {
        super("Error102 : in line " + scopeNumber + " , method " + idefName + " has been defined already");
    }
}
