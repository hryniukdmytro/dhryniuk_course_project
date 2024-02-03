package envPropertiesSetup;

import java.util.HashMap;
import java.util.Map;

public class EnvTestDataSetup {
    public static String TESTDATA_NEW_USER_NAME;
    public static String TESTDATA_NEW_USER_PASSWORD;
    public static int TESTDATA_BOARD_COLUMN_BACKLOG;
    public static int TESTDATA_BOARD_COLUMN_READY;
    public static int TESTDATA_BOARD_COLUMN_WIP;
    public static int TESTDATA_BOARD_COLUMN_DONE;
    public static final int HTTP_STATUS_CODE_200 = 200;
    public static final Map<String, Integer> COLUMN_ID_MAP = new HashMap<>();

    public static void testDataConstantsSetup() {
        // Test user data
        TESTDATA_NEW_USER_NAME = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.TESTDATA_PROPERTIES_FILE_NAME, "newUserName");
        TESTDATA_NEW_USER_PASSWORD = GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.TESTDATA_PROPERTIES_FILE_NAME, "newUserPassword");
        // Task Columns IDs
        TESTDATA_BOARD_COLUMN_BACKLOG = Integer.parseInt(GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.TESTDATA_PROPERTIES_FILE_NAME, "backlog"));
        TESTDATA_BOARD_COLUMN_READY = Integer.parseInt(GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.TESTDATA_PROPERTIES_FILE_NAME, "ready"));
        TESTDATA_BOARD_COLUMN_WIP = Integer.parseInt(GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.TESTDATA_PROPERTIES_FILE_NAME, "workInProgress"));
        TESTDATA_BOARD_COLUMN_DONE = Integer.parseInt(GetPropertiesFromFile.propertyValue(GetPropertiesFromFile.PATH_TO_RESOURCE, GetPropertiesFromFile.TESTDATA_PROPERTIES_FILE_NAME, "done"));
    }

    // ID map columns setup
    public static void mapTaskColumnsIds() {
        COLUMN_ID_MAP.put("Backlog", TESTDATA_BOARD_COLUMN_BACKLOG);
        COLUMN_ID_MAP.put("Ready", TESTDATA_BOARD_COLUMN_READY);
        COLUMN_ID_MAP.put("Work in progress", TESTDATA_BOARD_COLUMN_WIP);
        COLUMN_ID_MAP.put("Done", TESTDATA_BOARD_COLUMN_DONE);
    }
}
