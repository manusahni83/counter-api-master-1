package interview.test.curl.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class SearchResult implements Serializable {

    private static final long serialVersionUID = 1L;
    private LinkedHashMap<String,Integer> counts = new LinkedHashMap<String,Integer>();
    public LinkedHashMap<String, Integer> getCounts() {
        return counts;
    }
    public void setCounts(LinkedHashMap<String, Integer> counts) {
        this.counts = counts;
    }
    @Override
    public String toString() {
        return "SearchResult [counts=" + counts + "]";
    }
    

}
