package compiler;

public class FieldAlreadyExistsException extends Throwable {

    public FieldAlreadyExistsException(String idefName, int scopeNumber) {
        super("Error102 : in line " + scopeNumber + " , field " + idefName + " has been defined already");
    }
}
