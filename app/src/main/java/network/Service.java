package network;

import Util.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Retrofit retrofit;
    private static Retrofit getRetrofit()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        }
        return retrofit;
    }

    private static OkHttpClient okHttpClient;
    private static OkHttpClient getOkHttpClient()
    {
        if(okHttpClient == null)
        {
            okHttpClient =  new OkHttpClient().newBuilder().build();
        }
        return okHttpClient;
    }


    private ServiceApi serviceApi;
    public ServiceApi getServiceApi()
    {
        if(serviceApi == null)
        {
            serviceApi = getRetrofit().create(ServiceApi.class);
        }
        return serviceApi;
    }
}
