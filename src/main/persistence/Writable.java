package persistence;

import org.json.JSONObject;

public interface Writable {
    // return this as JSON object
    JSONObject toJson();
}
