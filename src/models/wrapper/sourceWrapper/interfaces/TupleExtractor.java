package models.wrapper.sourceWrapper.interfaces;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

/**
 * Standard interface for a tuple extractor
 */
public interface TupleExtractor {

    /*
    * Input: Converted JSON object generated by formatter
    * Output: Array of JSON objects, minimal structures representing exactly one potential tuple
    * */
    public JSONArray getTuples(JSON all);

}
