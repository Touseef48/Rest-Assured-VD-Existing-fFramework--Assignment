package general;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class flatMapUtil {

    private flatMapUtil() {
        throw new AssertionError("No instances for you!");
    }

    public static String[] patterns = new String[]{};

    public static String transformJson(String jsonString){
        if(jsonString!=null && !jsonString.isEmpty()){
            if(jsonString.charAt(0) == '['){
                return "{\"data\":"+jsonString+"}";
            }
        }


        return jsonString;
    }

    public static Map<String, Object> flatten(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .flatMap(flatMapUtil::flatten)
                .collect(LinkedHashMap::new, (m, e) -> m.put("/" + e.getKey(), e.getValue()), LinkedHashMap::putAll);
    }

    private static Stream<Entry<String, Object>> flatten(Entry<String, Object> entry) {

        for (String pattern:patterns) {
            if(entry.getKey().toString().matches(pattern)){
                return Stream.empty();
            }
        }

        if (entry == null) {
            return Stream.empty();
        }

        if (entry.getValue() instanceof Map<?, ?>) {
            Map<?, ?> properties = (Map<?, ?>) entry.getValue();
            return properties.entrySet()
                    .stream()
                    .flatMap(e -> flatten(new SimpleEntry<>(entry.getKey() + "/" + e.getKey(), e.getValue())));
        }

        if (entry.getValue() instanceof List<?>) {
            List<?> list = (List<?>) entry.getValue();
            return IntStream.range(0, list.size())
                    .mapToObj(i -> new SimpleEntry<String, Object>(entry.getKey() + "/" + i, list.get(i)))
                    .flatMap(flatMapUtil::flatten);
        }

        return Stream.of(entry);
    }
}