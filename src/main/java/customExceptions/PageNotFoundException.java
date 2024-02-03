package customExceptions;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(String pageTypeName, String allPages) {
        super(String.format("Page with name '%s' was not found. Current pages: %n%s", pageTypeName, allPages));
    }
}
