package Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import general.flatMapUtil;
import general.baseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Config.envGlobals.Differnce;


public class reusableFunctions {

    // get response path array list
    public static ArrayList responseList(String key) {
        return envGlobals.response.then().
                extract().
                path(key);
    }

    // get response size
    public static int getResponseLength() {
        return envGlobals.response.body().path("list.size()");
    }

    // print response string
    public static void printResponse() {
        System.out.println(envGlobals.response.getBody().asString());
    }

    // get response as string
    public static String getResponse() {
        return envGlobals.response.getBody().asString();
    }

    // sort response by id
    private static JSONArray sortApiResponse(JSONArray jsonArr, String sortBy, boolean sortOrder) {
        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.length(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        final String KEY_NAME = sortBy;
        final Boolean SORT_ORDER = sortOrder;
        Collections.sort(jsonValues, new Comparator<JSONObject>() {

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Integer valA = new Integer(0);
                Integer valB = new Integer(0);

                try {
                    valA = (Integer) a.get(KEY_NAME);
                    valB = (Integer) b.get(KEY_NAME);
                } catch (JSONException e) {
                    //exception
                }
                if (SORT_ORDER) {
                    return valA.compareTo(valB);
                } else {
                    return -valA.compareTo(valB);
                }
            }
        });

        for (int i = 0; i < jsonArr.length(); i++) {
            sortedJsonArray.put(jsonValues.get(i));
        }

        return sortedJsonArray;
    }

    // get response path
    public static String getResponsePath(String key) {
        return envGlobals.response.getBody().path(key).toString();
    }

    public static int getLength(String Path) {
        return envGlobals.response.body().path(Path);
    }


    //get response json
    public static JSONArray getResponseJson(String... params) {

        JsonPath jsonPathEvaluator = envGlobals.response.jsonPath();

        JSONArray jArray = new JSONArray();

        ArrayList<Object> list1 = jsonPathEvaluator.get(params[0]);

        ArrayList<Object> list2 = jsonPathEvaluator.get(params[1]);

        for (int i = 0; i < getResponseLength(); i++) {

            JSONObject obj = new JSONObject();

            for (int j = 0; j < params.length; j++) {
                if (j == 0) {
                    obj.put(params[j], list1.get(i));
                } else
                    obj.put(params[j], list2.get(i));
            }

            jArray.put(obj);


        }
        ;
        return sortApiResponse(jArray, "id", true);
    }

    // set content type
    private static void contentType(String contentType) {
        baseTest.REQUEST = RestAssured.given().contentType(contentType);
    }

    // Given function with no parameters
    public static void given() {
        contentType("application/json");
        envGlobals.requestSpecification = baseTest.REQUEST.given();
    }

    // Given function with 1 parameter - For multipart API's
    public static void givenFormData(Map<String, String> formData) {
        contentType("multipart/form-data");

        Iterator<Map.Entry<String, String>> it = formData.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            envGlobals.requestSpecification = baseTest.REQUEST.given()
                    .multiPart(pair.getKey(), pair.getValue());
            it.remove();
        }
    }

    // Given function with one parameter - Headers
    public static void givenHeaders(Map<String, String> headers) {
        contentType("application/json");
        envGlobals.requestSpecification = baseTest.REQUEST.given()
                .headers(headers);
    }

    // Given function with 2 parameters - API (parameters, headers)
//    public static void givenParamHeader(Map<String, String> params, Map<String, String> headers) {
//        contentType("application/json");
//        envGlobals.requestSpecification = baseTest.REQUEST.given()
//                .queryParam(String.valueOf(params))
//                .headers(headers);
//    }

    // Given function with 3 parameters - API (parameters, headers, payload)
    // pass null value when calling a function if params or headers not required
    public static void givenHeaderPayload(Map<String, String> headers, String
            payload) {
        contentType("application/json");
        envGlobals.requestSpecification = baseTest.REQUEST.given();
        if (headers == null) {
            envGlobals.requestSpecification = baseTest.REQUEST.given()
                    .body(payload);
        } else if (payload == null) {
            envGlobals.requestSpecification = baseTest.REQUEST.given()
                    .headers(headers);
        } else {
            envGlobals.requestSpecification = baseTest.REQUEST.given()
                    .headers(headers)
                    .body(payload);
        }
    }

    // Given function with two params, Headers and Formdata
    public static void givenHeaderFormData(Map<String, String> headers, Map<String,
            String> formData) {
        contentType("multipart/form-data");
        Iterator<Map.Entry<String, String>> it = formData.entrySet().iterator();


        if (headers == null) {
            envGlobals.requestSpecification = baseTest.REQUEST.given();
            while (it.hasNext()) {
                Map.Entry<String, String> pair = it.next();
                envGlobals.requestSpecification = baseTest.REQUEST.given()
                        .multiPart(pair.getKey(), pair.getValue());
                it.remove();
            }
        } else {
            envGlobals.requestSpecification = baseTest.REQUEST.given()
                    .headers(headers);
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                envGlobals.requestSpecification = baseTest.REQUEST.given()
                .multiPart((String) pair.getKey(), pair.getValue());
                it.remove();
            }
        }
    }


    // When function with request type(Get, Post etc) & API endpoint
    public static void whenFunction(String requestType, String endPoint) {
        switch (requestType) {
            case "post":
                envGlobals.response =
                        envGlobals.requestSpecification
                                .when().log().all()
                                .post(endPoint);
                break;

            case "get":
                envGlobals.response =
                        envGlobals.requestSpecification
                                .when().log().all()
                                .get(endPoint);
                break;
            case "delete":
                envGlobals.response =
                        envGlobals.requestSpecification
                                .when().log().all()
                                .delete(endPoint);
                break;
            case "put":
                envGlobals.response =
                        envGlobals.requestSpecification
                                .when().log().all()
                                .put(endPoint);
                break;
            case "patch":
                envGlobals.response =
                        envGlobals.requestSpecification
                                .when().log().all()
                                .patch(endPoint);
                break;
        }

    }

    // Then function to verify status code
    public static void thenFunction(int statusCode) {
        //envGlobals.response.then().statusCode(statusCode);
        envGlobals.response.then().log().all().statusCode(statusCode);
    }

    public static void thenObjectmatch (String path, String matchers)
    {

        envGlobals.response.then().body(path, Matchers.hasItem(matchers));

    }

    // Hashmap for params, headers, form-data
    public static <K, V> Map<K, V> headers(Object... keyValues) {
        Map<K, V> map = new HashMap<>();

        for (int index = 0; index < keyValues.length / 2; index++) {
            map.put((K) keyValues[index * 2], (V) keyValues[index * 2 + 1]);
        }

        return map;
    }

    public static <K, V> Map<K, V> form_data(Object... keyValues) {
        Map<K, V> map = new HashMap<>();

        for (int index = 0; index < keyValues.length / 2; index++) {
            map.put((K) keyValues[index * 2], (V) keyValues[index * 2 + 1]);
        }

        return map;
    }

    public static <K, V> Map<K, V> params(Object... keyValues) {
        Map<K, V> map = new HashMap<>();

        for (int index = 0; index < keyValues.length / 2; index++) {
            map.put((K) keyValues[index * 2], (V) keyValues[index * 2 + 1]);
        }

        return map;
    }


    public static void compareFile(String apiResponse, String jsonFile, String[] ignoreFields)
    {
        JSONParser jsonParser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();

        try {

            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(new FileReader(jsonFile));
            String expectedResponse = jsonObject.toString();
            flatMapUtil.patterns = ignoreFields;

            apiResponse = flatMapUtil.transformJson(apiResponse);
            expectedResponse = flatMapUtil.transformJson(expectedResponse);

            // convert JSON string to Map
            Map<String, Object> mapActual = mapper.readValue(apiResponse, Map.class);
            Map<String, Object> mapExpected = mapper.readValue(expectedResponse, Map.class);

            Map<String, Object> actualFlatMap = flatMapUtil.flatten(mapActual);
            Map<String, Object> ExpectedFlatMap = flatMapUtil.flatten(mapExpected);


            MapDifference<String, Object> difference = Maps.difference(actualFlatMap, ExpectedFlatMap);

            System.out.println("Entries only on left\n--------------------------");
            difference.entriesOnlyOnLeft().forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("\n\nEntries only on right\n--------------------------");
            difference.entriesOnlyOnRight().forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("\n\nEntries differing\n--------------------------");
            difference.entriesDiffering().forEach((key, value) -> System.out.println(key + ": " + value));
            System.out.println("\n\nEntries differing\n--------------------------");
            difference.entriesDiffering().forEach((key, value) -> Differnce.append(key + ": " + value));

            System.out.println("\n\nEntries in common\n--------------------------");
            difference.entriesInCommon().forEach((key, value) -> System.out.println(key + ": " + value));

            Assert.assertEquals(difference.entriesDiffering().size(),0);

            Assert.assertEquals(difference.entriesOnlyOnLeft().size(),difference.entriesOnlyOnRight().size());

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    // get respons length wrt path
    public static int getPathLength(String Path)
    {
        return envGlobals.response.body().path(Path);
    }


}