package utils;

import java.util.List;

public interface ObjectMapper {

    static Object writeValueAsString(List<?> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeValueAsString'");
    }

    static <T> List<T> readValue(String json, TypeReference<List<T>> typeReference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readValue'");
    }

}
