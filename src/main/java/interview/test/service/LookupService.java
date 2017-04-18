package interview.test.service;

import interview.test.curl.domain.Search;
import interview.test.curl.domain.SearchResult;



/**
 * Services to perform curl logic
 */
public interface LookupService  {

    SearchResult search(Search search);

    SearchResult wordCount(String count);
    

}
