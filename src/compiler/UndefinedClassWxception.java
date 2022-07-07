package compiler;

public class UndefinedClassWxception extends Throwable {
    public UndefinedClassWxception(String idefName, int scopeNumber) {
        super("Error105 : in line " + scopeNumber + ", cannot find class " + idefName);
    }
}
