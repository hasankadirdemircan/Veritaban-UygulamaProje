package com.hkadirdemircan.otogalarim.RestApi;

/**
 * Created by Hkadir on 27.03.2018.
 */

public class BaseManager {

    protected RestApi getRestApi()
    {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.URL);
        return restApiClient.getRestApi();
    }
}
