package customExceptions;

public class ElementOnPageNotFoundException extends RuntimeException {
    public ElementOnPageNotFoundException(String elementName, String pageName) {
        super(String.format("\nElement with name '%s' was not found. " +
                "Check element in '%s' element name mapper", elementName, pageName));
    }
}