
package EndPoints;

public class Urls {

    public static String baseUrl = "https://reqres.in";

    public static String createUser = "/api/users";
    public static String GetSingleUser = "/api/users/2";
    public static String GetListUsers = "/api/users?page=2";
    public static String NotFoundSingleUser = "/api/users/23";

    public static String successRegister = "/api/register";
    public static String unsuccessfulRegister = "/api/register";

    public static String ValidLogin = "/api/login";
    public static String InValidLogin= "/api/login";

    public static String DeleteRequest = "/api/users/2";
    public static String PatchRequest = "/api/users/2";
    public static String PutRequest = "/api/users/2";
    public static String DelayResponse = "/api/users?delay=3";

    public static String SingleResource= "/api/unknown/2";
    public static String NotFoundSingleResource= "/api/unknown/23";
    public static String ListResource= "/api/unknown/";
}
